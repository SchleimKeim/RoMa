package ch.zhaw.roma.controller;

import ch.zhaw.roma.model.royaltycalculation.Author;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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


    private ManageAuthorsController() {

    }

    @FXML
    private void initialize() {
        //initialization of the author table with two columns.
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory((cellData -> cellData.getValue().lastNameProperty()));
    }

}
