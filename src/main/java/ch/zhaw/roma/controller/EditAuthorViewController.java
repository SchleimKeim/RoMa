package ch.zhaw.roma.controller;

import ch.zhaw.roma.model.form.Country;
import ch.zhaw.roma.model.form.Greeting;
import ch.zhaw.roma.model.royaltycalculation.Author;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditAuthorViewController {

    @FXML
    public ComboBox greeting;
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
    private ComboBox country;
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
    private Button safeButton;
    @FXML
    private Button cancelButton;

    private Stage dialogStage;
    private Author author;
    private Boolean safeClicked = false;
    private Boolean isNewAuthor = false;

    @FXML
    private void initialize() {

    }

    //Set stage for edit Author
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setAuthor(Author author) {
        //Combobox needs observable List
        greeting = new ComboBox(FXCollections.observableList(new Greeting().GREETINGS));
        country = new ComboBox((FXCollections.observableList(new Country().COUNTRIES)));

        if(author != null) {
            this.author = author;
            if (author.getGreeting().getGreetingString() != null) {
                greeting.setValue(author.getGreeting().getGreetingString());
            } else {
                greeting.setValue(null);

                firstName.setText(author.getFirstName());
                lastName.setText(author.getLastName());
                street1.setText(author.getStreet1());
                street2.setText(author.getStreet2());
                street3.setText(author.getStreet3());
                zipCode.setText(Integer.toString(author.getZipCode()));
                city.setText(author.getCity());

                if (author.getCountry().getCountryString() != null) {
                    country.setValue(author.getCountry().getCountryString());
                } else {
                    greeting.setValue(null);
                }
                email.setText(author.getEmail());
                website.setText(author.getWebsite());
                mobileNr.setText(author.getPhoneMobile());
                officeNr.setText(author.getPhoneWork());
                privateNr.setText(author.getPhoneHome());
                author = new Author();
                isNewAuthor = true;
                greeting.setValue(null);
                firstName.setText("");
                lastName.setText("");
                street1.setText("");
                street2.setText("");
                street3.setText("");
                zipCode.setText("");
                city.setText("");
                email.setText("");
                website.setText("");
                mobileNr.setText("");
                officeNr.setText("");
                privateNr.setText("");
            }
        }
    }

    @FXML
    public void handleSafe() {
        //TODO: Input validation
        author.setGreeting(new Greeting(greeting.getValue().toString()));
        author.setFirstName(firstName.getText());
        author.setLastName(lastName.getText());
        author.setStreet1(street1.getText());
        author.setStreet2(street2.getText());
        author.setStreet3(street3.getText());
        author.setZipCode(Integer.parseInt(zipCode.getText()));
        author.setCity(city.getText());
        author.setEmail(email.getText());
        author.setWebsite(website.getText());
        author.setPhoneMobile(mobileNr.getText());
        author.setPhoneHome(privateNr.getText());
        author.setPhoneWork(officeNr.getText());
        author.setCountry((new Country(country.getValue().toString())));

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

    //TODO: input validation

}

