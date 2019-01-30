package ch.zhaw.roma.controller;

import ch.zhaw.roma.model.form.Country;
import ch.zhaw.roma.model.form.Greeting;
import ch.zhaw.roma.model.royaltycalculation.Author;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditAuthorViewController {

    @FXML
    private TextField greetingBox;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField street1;
    @FXML
    private TextField street2;
    @FXML
    private TextField street3;
    @FXML
    private TextField zipCode;
    @FXML
    private TextField city;
    @FXML
    private ComboBox countryBox;
    @FXML
    private TextField email;
    @FXML
    private TextField website;
    @FXML
    private TextField mobileNr;
    @FXML
    private TextField officeNr;
    @FXML
    private TextField privateNr;

    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;

    private Stage dialogStage;

    private Author author;
    private Boolean safeClicked = false;


    @FXML
    private void initialize() {

        countryBox.getItems().removeAll(countryBox.getItems());
        for (String country : Country.getCOUNTRIES()) {
            countryBox.getItems().add(country);
        }
    }

    //Set stage for edit Author
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setDataFields(Author author) {

        countryBox.getSelectionModel().select(author.getCountry().getCountryString());

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

        this.author = author;
    }

    @FXML
    public void handleSafe() {
        author.setFirstName(firstName.getText());
        author.setLastName(lastName.getText());
        author.setStreet1(street1.getText());
        author.setStreet2(street2.getText());
        author.setStreet3(street3.getText());
        author.setZipCode(Integer.parseInt(zipCode.getText()));
        author.setCity(city.getText());
        author.setCountry(new Country(countryBox.getSelectionModel().getSelectedItem().toString()));
        author.setEmail(email.getText());
        author.setWebsite(website.getText());
        author.setPhoneMobile(mobileNr.getText());
        author.setPhoneHome(privateNr.getText());
        author.setPhoneWork(officeNr.getText());
        author.setCountry((new Country(countryBox.getValue().toString())));

        safeClicked = true;
        dialogStage.close();

    }

    public boolean isSafeClicked() {
        return safeClicked;
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    //TODO: input validation
}
