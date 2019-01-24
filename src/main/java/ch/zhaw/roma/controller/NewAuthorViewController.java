package ch.zhaw.roma.controller;

import ch.zhaw.roma.model.royaltycalculation.Author;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class NewAuthorViewController {
    @FXML
    private TextField firstNameField;
    @FXML
    private ComboBox titleField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField street1Field;
    @FXML
    private TextField street2Field;
    @FXML
    private TextField steet3Field;
    @FXML
    private TextField zipcodeField;
    @FXML
    private TextField cityField;
    @FXML
    private ComboBox countryField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField websiteField;
    @FXML
    private TextField mobileNrField;
    @FXML
    private TextField officeNrField;
    @FXML
    private TextField privateNrField;

    private Author author;

    public NewAuthorViewController() {

    }


    public void initialize(Author author) {
        this.author = author;
    }


}
