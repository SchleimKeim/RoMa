package ch.zhaw.roma.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    //region @FXML fields
    @FXML private Button openAgencyView;
    @FXML private Button openBookView;
    @FXML private Button openAuthorView;
    @FXML private Button openTranslatorView;
    @FXML private Button openAdressView;
    @FXML private Button enterHonoraries;

    @FXML private AnchorPane adressView;
    @FXML private AnchorPane agencyView;
    @FXML private AnchorPane authorView;
    @FXML private AnchorPane bookView;
    @FXML private AnchorPane optionsView;
    @FXML private AnchorPane translatorView;
    //endregion

    //region controller
    @FXML private AdressViewController adressViewController;
    @FXML private AgencyViewController agencyViewController;
    @FXML private AuthorViewController authorViewController;
    @FXML private BookViewController bookViewController;
    @FXML private OptionsViewController optionsViewController;
    @FXML private TranslatorViewController translatorViewController;
    //endregion

    //region overrides and interface implementations
    public void initialize(URL location, ResourceBundle resources) {

    }
    //endregion

    //region Event Handler
    public void onOpenAgencyView(ActionEvent actionEvent) {
    }

    public void onOpenBookView(ActionEvent actionEvent) {
    }

    public void onOpenAuthorView(ActionEvent actionEvent) {
    }

    public void onOpenTranslatorView(ActionEvent actionEvent) {
    }

    public void onOpenAdressView(ActionEvent actionEvent) {
    }

    public void onEnterHonoraries(ActionEvent actionEvent) {
    }
    //endregion
}
