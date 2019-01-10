package ch.zhaw.roma.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ImportExcelViewController implements Initializable {
    public TextField path;
    public Button chooseFile;
    public Button startImport;
    public RadioButton documentTypeVerlag;
    public RadioButton documentTypeBookwire;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void onChooseFile(ActionEvent actionEvent) {
    }
}
