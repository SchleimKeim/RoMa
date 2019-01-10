package ch.zhaw.roma.controller;

import ch.zhaw.roma.model.settings.RoMaSettings;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsViewController implements Initializable {

    //region Private Fields
    private SimpleObjectProperty<RoMaSettings> settings = new SimpleObjectProperty<>(this, "settings");
    //endregion

    //region FXML fields
    public Button cancelButton;
    public Button loadButton;
    public Button saveButton;
    //endregion

    //region Event Handlers
    public void onCancelAction(ActionEvent actionEvent) {
    }

    public void onLoadAction(ActionEvent actionEvent) {
    }

    public void onSaveAction(ActionEvent actionEvent) {
    }
    //endregion

    //region Getters and Setters
    public RoMaSettings getSettings() {
        return settings.get();
    }

    public void setSettings(RoMaSettings settings) {
        this.settings.set(settings);
    }
    //endregion

    //region Interface Implementations
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize Settings
        settings.setValue(RoMaSettings.load(RoMaSettings.DEFUALT_PATH.toString()));
    }
    //endregion
}
