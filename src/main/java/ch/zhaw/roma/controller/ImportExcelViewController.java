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
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
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
    @FXML
    private SimpleStringProperty statusText = new SimpleStringProperty(this, "statusText");

    public TextField path;
    public Button chooseFile;
    public Button startImport;
    public RadioButton documentTypeVerlag;
    public RadioButton documentTypeBookwire;
    public TextArea statusTextArea;
    private SessionFactory sessionFactory;
    private StandardServiceRegistry registry;
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

    public StringProperty statusTextProperty() {
        return filePath;
    }

    public String getStatusText() {
        return statusText.get();
    }

    public void setStatusText(String statusText) {
        this.statusText.set(statusText);
    }
    //endregion

    //region Construction
    public ImportExcelViewController() {
        setFilePath("Bitte Datei wählen...");
        setStatusText("Bitte Datei wählen...");
    }
    //endregion

    //region Overrides
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setFilePath("call from initialize...");
        setStatusText("call from initialize...");

        registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();

        documentTypeVerlag.getToggleGroup().selectToggle(documentTypeVerlag);
    }
    //endregion

    //region Action Handler
    public void onImport(ActionEvent actionEvent) {
        if (filePath == null)
            return;

        SheetType type = getSelectedType();

        ExcelSheet sheet = new ExcelImporter(filePath.get(), type).importSheet();
        if (sheet == null)
            return;

        if (sheet.isInhouseSheet())
            saveInhouse(ExcelToEntityConverter.createFrom(sheet.asInhouse()));
        else
            saveBookWire(ExcelToEntityConverter.createFrom(sheet.asBookwire()));
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
    private void changeStatusText(boolean success) {
        setStatusText(success ? "Datei erfolgreich importiert" : "Datei konnte nicht importiert werden!");
    }

    private SheetType getSelectedType() {
        return documentTypeBookwire.isSelected() ? SheetType.Bookwire : SheetType.Verlagsabrechnung;
    }

    private void saveBookWire(BookWireSheetModel bookWireSheetModel) {
        changeStatusText(bookWireSheetModel.save(sessionFactory.openSession()));
    }

    private void saveInhouse(InhouseSheetModel inhouseSheetModel) {
        changeStatusText(inhouseSheetModel.save(sessionFactory.openSession()));
    }
    //endregion

}
