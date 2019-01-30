package ch.zhaw.roma.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class PersonViewController implements Initializable {
    public TextField firstName;
    public TextField lastName;
    public TextField street1;
    public TextField street2;
    public TextField street3;
    public TextField zipCode;
    public TextField city;
    public TextField country;
    public TextField email;
    public TextField website;
    public TextField mobilePhone;
    public TextField officePhone;
    public TextField privatePhone;
    public TextField greeting;

    //region Private Fields
    //endregion

    //region Public Fields
    //endregion

    //region Getters And Setters
    //endregion

    //region Construction
    public PersonViewController() {

    }
    //endregion

    //region Action Handler
    public void onSave(ActionEvent actionEvent) {
    }

    public void onCancel(ActionEvent actionEvent) {
    }
    //endregion

    //region Public Members
    //endregion

    //region Private Helpers
    //endregion

    //region Overrides
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    //endregion
}
