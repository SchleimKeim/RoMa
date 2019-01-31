package ch.zhaw.roma.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;

import java.net.URL;
import java.util.ResourceBundle;

public class PersonViewController implements Initializable {

    //region Private Fields
    private SessionFactory sessionFactory;
    private StandardServiceRegistry serviceRegistry;
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
    public void setDbConnection(SessionFactory factory, StandardServiceRegistry registry) {
        if(sessionFactory == null)
            sessionFactory = factory;
        if(serviceRegistry == null)
            serviceRegistry = registry;
    }
    //endregion

    //region Private Helpers
    //endregion

    //region Overrides
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    //endregion
}
