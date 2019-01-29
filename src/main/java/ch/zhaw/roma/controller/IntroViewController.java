package ch.zhaw.roma.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IntroViewController implements Initializable {
    public Button editData;
    public Button startNewRoyaltyCalculation;
    public Button openSettings;
    public Button importExcel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void openNewCalculation(ActionEvent actionEvent) {
    }

    public void openExcelFileImporter(ActionEvent actionEvent) {
        openWindow("/view/ImportExcelView.fxml", "Excel Datei Importieren...");
    }

    public void openDataEditor(ActionEvent actionEvent) {
    }

    public void openSettings(ActionEvent actionEvent) {
        openWindow("/view/SettingsView.fxml", "Einstellungen...");
    }

    private void openWindow(String path, String title) {
        Stage settingsViewStage = new Stage();
        try {
            settingsViewStage.setScene(new Scene(FXMLLoader.load(getClass().getResource(path))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        settingsViewStage.setTitle(title);
        settingsViewStage.show();
    }
}
