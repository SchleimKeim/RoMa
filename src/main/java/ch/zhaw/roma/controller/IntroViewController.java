package ch.zhaw.roma.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IntroViewController implements Initializable {
    public Button editData;
    public Button startNewRoyaltyCalculation;
    public Button openSettings;
    public Button importExcel;
    private Stage settingsViewStage = new Stage();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        settingsViewStage.setTitle("Einstellungen...");
        try {
            settingsViewStage.setScene(
                new Scene(
                    FXMLLoader.load(getClass().getResource("/view/SettingsView.fxml"))
                )
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openNewCalculation(ActionEvent actionEvent) {
    }

    public void openExcelFileImporter(ActionEvent actionEvent) {
    }

    public void openDataEditor(ActionEvent actionEvent) {
    }

    public void openSettings(ActionEvent actionEvent) {
        settingsViewStage.show();
    }
}
