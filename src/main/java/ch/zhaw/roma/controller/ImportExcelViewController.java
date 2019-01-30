package ch.zhaw.roma.controller;

import ch.zhaw.roma.helpers.excel.ExcelImporter;
import ch.zhaw.roma.model.excel.ExcelSheet;
import ch.zhaw.roma.model.excel.SheetType;
import ch.zhaw.roma.model.excel.persistence.BookWireSheetModel;
import ch.zhaw.roma.model.excel.persistence.ExcelToEntityConverter;
import ch.zhaw.roma.model.excel.persistence.InhouseSheetModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class ImportExcelViewController implements Initializable {

    //region Fields
    @FXML
    private SimpleStringProperty filePath = new SimpleStringProperty(this, "filePath");

    public TextField path;
    public Button chooseFile;
    public Button startImport;
    public RadioButton documentTypeVerlag;
    public RadioButton documentTypeBookwire;
    private SessionFactory sessionFactory;
    private StandardServiceRegistry serviceRegistry;
    //endregion

    //region Getters and Setters
    public StringProperty filePathProperty() {
        return filePath;
    }

    public String getFilePath() {
        return filePath.get();
    }

    public void setFilePath(String filePath) {
        this.filePath.set(filePath);
    }
    //endregion

    //region Construction
    public ImportExcelViewController() {
    }
    //endregion

    //region Overrides
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setFilePath("Bitte Datei Wählen...");

        serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        sessionFactory = new MetadataSources(serviceRegistry)
                .buildMetadata()
                .buildSessionFactory();

        documentTypeVerlag.getToggleGroup().selectToggle(documentTypeVerlag);
    }
    //endregion

    //region Public Members
    public void importSheet(SheetType type) {
        ExcelSheet sheet = new ExcelImporter(filePath.get(), type).importSheet();
        if (sheet == null)
            return;

        if (sheet.isInhouseSheet())
            saveInhouse(ExcelToEntityConverter.createFrom(sheet.asInhouse()));
        else
            saveBookWire(ExcelToEntityConverter.createFrom(sheet.asBookwire()));
    }
    //endregion

    //region Action Handler
    public void onImport(ActionEvent actionEvent) {
        if (filePath == null)
            return;

        importSheet(getSelectedType());
    }

    public void onChooseFile(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        if (stage == null)
            return;

        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(Paths.get("./src/test/resources").toFile());
        fileChooser.setTitle("Open Resource File");
        setFilePath(fileChooser.showOpenDialog(stage).toString());
    }
    //endregion

    //region Private Helpers
    private void showDialog(boolean success) {
        if(success) {
            showSuccess();
            closeDBConnection();
            closeWindow();
        }
        else
            showError();
    }

    private void closeDBConnection() {
        try {
            sessionFactory.close();
            serviceRegistry.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void closeWindow() {
        Stage stage = (Stage) startImport.getScene().getWindow();
        if(stage != null)
            stage.close();
    }

    private void showError() {
        showAlert("Beim Import der Datei ist etwas schief gelaufen!.", Alert.AlertType.ERROR);
    }

    private void showAlert(String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(type == Alert.AlertType.ERROR ? "Fehler!" : "Erfolg");
        alert.setHeaderText(message);
        alert.showAndWait();
    }

    private void showSuccess() {
        showAlert("Datei erfolgreich Importiert.", Alert.AlertType.INFORMATION);
    }

    private SheetType getSelectedType() {
        return documentTypeBookwire.isSelected() ? SheetType.Bookwire : SheetType.Verlagsabrechnung;
    }

    private void saveBookWire(BookWireSheetModel bookWireSheetModel) {
        showDialog(bookWireSheetModel.save(sessionFactory.openSession()));
    }

    private void saveInhouse(InhouseSheetModel inhouseSheetModel) {
        showDialog(inhouseSheetModel.save(sessionFactory.openSession()));
    }

    public void setDbConnection(StandardServiceRegistry registry, SessionFactory factory) {
        if(serviceRegistry == null)
            serviceRegistry = registry;
        if(sessionFactory == null)
            sessionFactory = factory;
    }
    //endregion
}
