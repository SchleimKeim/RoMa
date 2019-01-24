package ch.zhaw.roma.controller;

import ch.zhaw.roma.Main;
import ch.zhaw.roma.helpers.AuthorCollection;
import ch.zhaw.roma.model.royaltycalculation.Author;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageAuthorsController {

    @FXML
    private TableView<Author> authorTable;
    @FXML
    private TableColumn<Author, String> firstNameColumn;
    @FXML
    private TableColumn<Author, String> lastNameColumn;

    @FXML
    private Label greeting;
    @FXML
    private Label firstName;
    @FXML
    private Label lastName;
    @FXML
    private Label street1;
    @FXML
    private Label street2;
    @FXML
    private Label street3;
    @FXML
    private Label zipCode;
    @FXML
    private Label city;
    @FXML
    private Label country;
    @FXML
    private Label email;
    @FXML
    private Label website;
    @FXML
    private Label mobileNr;
    @FXML
    private Label officeNr;
    @FXML
    private Label privateNr;
    @FXML
    private Button newButton;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;

    private Main main;


    private ManageAuthorsController() {

    }

    @FXML
    private void initialize() {
        //initialization of the author table with two columns.
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory((cellData -> cellData.getValue().lastNameProperty()));
        showAuthorDetails(null);

        authorTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showAuthorDetails(newValue));



    }

    public void showAuthorDetails(Author author) {
        if (author.getGreeting().getGreetingString() != null) {
            greeting.setText(author.getGreeting().getGreetingString());
        } else {
            greeting.setText("");
        }
        if (author.getCountry().getCountryString() != null) {
            country.setText(author.getCountry().getCountryString());
        } else {
            greeting.setText("");
        }
        firstName.setText(author.getFirstName());
        lastName.setText(author.getLastName());
        street1.setText(author.getStreet1());
        street2.setText(author.getStreet2());
        street3.setText(author.getStreet3());
        zipCode.setText(Integer.toString(author.getZipCode()));
        city.setText(author.getCity());

        email.setText(author.getEmail());
        website.setText(author.getWebsite());
        mobileNr.setText(author.getPhoneMobile());
        officeNr.setText(author.getPhoneWork());
        privateNr.setText(author.getPhoneHome());
    }

    @FXML
    public void handleNew() {
        Author author = new Author();
        openEditAuthor(author);
        boolean safeClicked = openEditAuthor(author);
        if(safeClicked == true) {
            main.addToAuthorList(author);

        }
    }

    @FXML
    public void handleEdit() {
        Author author = authorTable.getSelectionModel().getSelectedItem();
        if(author != null) {
            boolean safeClicked = openEditAuthor(author);
            if(safeClicked) {

            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("Keine Auswahl");
            alert.setHeaderText("Kein Author ausgewählt");
            alert.setContentText("Bitte wählen Sie einen Author aus der Liste aus");
            alert.showAndWait();
        }
    }

    @FXML
    public void handleDelete() {
        Author author = authorTable.getSelectionModel().getSelectedItem();
        AuthorCollection collection = main.getAuthorCollection();
        collection.removeAuthor(author);

    }


    public boolean openEditAuthor(Author author) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/EditAuthorView.fxml"));
            AnchorPane manageAuthors = (AnchorPane) loader.load();

            Stage editStage = new Stage();
            editStage.setTitle("Neuen Author erfassen");
            editStage.initModality(Modality.WINDOW_MODAL);
            editStage.initOwner(main.getPrimaryStage());
            Scene scene = new Scene(manageAuthors);
            editStage.setScene(scene);

            EditAuthorViewController controller = loader.getController();
            controller.setDialogStage(editStage);
            controller.setAuthor(author);

            editStage.showAndWait();
            return controller.isSafeClicked();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    public void setMain(Main main){
        this.main = main;
        authorTable.setItems(main.getAuthorCollection().getAuthorList());
    }

}
