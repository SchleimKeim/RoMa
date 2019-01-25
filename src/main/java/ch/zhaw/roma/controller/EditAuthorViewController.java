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
    private ComboBox greetingBox = new ComboBox();
    @FXML
    private TextField firstName = new TextField();
    @FXML
    private TextField lastName = new TextField();
    @FXML
    private TextField street1 = new TextField();
    @FXML
    private TextField street2 = new TextField();
    @FXML
    private TextField street3 = new TextField();
    @FXML
    private TextField zipCode = new TextField();
    @FXML
    private TextField city = new TextField();
    @FXML
    private ComboBox countryBox = new ComboBox();
    @FXML
    private TextField email = new TextField();
    @FXML
    private TextField website = new TextField();
    @FXML
    private TextField mobileNr = new TextField();
    @FXML
    private TextField officeNr = new TextField();
    @FXML
    private TextField privateNr = new TextField();

    @FXML
    private Button safeButton;
    @FXML
    private Button cancelButton;

    private Stage dialogStage;

    private Author author;
    private Boolean safeClicked = false;


    @FXML
    private void initialize() {
        greetingBox.getItems().removeAll(greetingBox.getItems());
        for(String greets: Greeting.getGREETINGS()) {
            greetingBox.getItems().add(greets);
        }
        countryBox.getItems().removeAll(countryBox.getItems());
        for(String country : Country.getCOUNTRIES()) {
            countryBox.getItems().add(country);
        }
    }

    //Set stage for edit Author
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setDataFields(Author author) {

        greetingBox.getSelectionModel().select(author.getGreeting().getGreetingString());
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
        //TODO: Input validation
        author.setGreeting(new Greeting(greetingBox.getSelectionModel().getSelectedItem().toString()));
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
