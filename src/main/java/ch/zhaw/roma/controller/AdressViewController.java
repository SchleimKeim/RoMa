package ch.zhaw.roma.controller;

import ch.zhaw.roma.viewmodel.AdressViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AdressViewController implements Initializable {

    //region Private Fields
    @FXML private TextField firstName;
    @FXML private TextField lastName;
    @FXML private TextField street1;
    @FXML private TextField street2;
    @FXML private TextField city;
    @FXML private TextField zipCode;
    @FXML private TextField emailAdress;
    @FXML private TextField webSite;

    @FXML private Button search;
    @FXML private Button save;
    @FXML private Button apply;
    @FXML private Button cancel;

    //endregion

    //region Construction
    public AdressViewController() {

    }
    //endregion

    //region Overrides
    public void initialize(URL location, ResourceBundle resources) {

    }
    //endregion
}
