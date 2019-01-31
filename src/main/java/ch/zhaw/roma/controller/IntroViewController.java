package ch.zhaw.roma.controller;

import ch.zhaw.roma.helpers.InitDBService;
import ch.zhaw.roma.helpers.InitDbResult;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IntroViewController implements Initializable {

    //region Private Fields
    private StandardServiceRegistry serviceRegistry;
    private SessionFactory sessionFactory;
    //endregion

    public Button editData;
    public Button openSettings;
    public Button importExcel;
    //endregion

    //region Construction
    public IntroViewController() {
        initDb();
    }
    //endregion

    //region Aciton Handler
    public void onOpenNewCalculation(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CreateCalculationView.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void onOpenExcelFileImporter(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ImportExcelView.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            ImportExcelViewController controller = loader.getController();

            if (controller != null) {
                controller.setDbConnection(serviceRegistry, sessionFactory);
                stage.show();
            } else {
                throw new Exception("Controller not loaded!");
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void onOpenDataEditor(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DataEditorView.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void onOpenSettings(ActionEvent actionEvent) {
        openWindow("/view/SettingsView.fxml", "Einstellungen...");
    }
    //endregion

    //region Private Helpers
    private void initDb() {
        serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        sessionFactory = new MetadataSources(serviceRegistry)
                .buildMetadata()
                .buildSessionFactory();
    }

    private void openWindow(String path, String title) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource(path))));
        } catch (Exception e) {
            e.printStackTrace();
        }
        stage.setTitle(title);
        stage.show();
    }
    //endregion

    //region Overrides
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(sessionFactory == null || serviceRegistry == null)
            initDb();
    }
    //endregion
}
