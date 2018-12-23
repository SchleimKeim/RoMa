package ch.zhaw.roma.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    //region @FXML fields
    @FXML private AnchorPane adressView;
    @FXML private AdressViewController adressViewController;
    @FXML private AnchorPane agencyView;
    @FXML private AgencyViewController agencyViewController;
    @FXML private AnchorPane authorView;
    @FXML private AuthorViewController authorViewController;
    @FXML private AnchorPane bookView;
    @FXML private BookViewController bookViewController;
    @FXML private AnchorPane opitonsView;
    @FXML private OptionsViewController optionsViewController;
    @FXML private AnchorPane translatorView;
    @FXML private TranslatorViewController translatorViewController;
    //endregion



    //region overrides and interface implementations
    public void initialize(URL location, ResourceBundle resources) {

    }
    //endregion
}
