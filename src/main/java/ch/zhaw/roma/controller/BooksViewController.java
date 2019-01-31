package ch.zhaw.roma.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;

import java.net.URL;
import java.util.ResourceBundle;

public class BooksViewController implements Initializable {
    //region Private Fields
    SessionFactory sessionFactory;
    StandardServiceRegistry serviceRegistry;
    //endregion

    //region Public Fields
    //endregion

    //region Getters And Setters
    //endregion

    //region Construction
    //endregion

    //region Public Members
    public void setDbConnection(SessionFactory factory, StandardServiceRegistry registry) {
        if(sessionFactory == null)
            sessionFactory = factory;
        if(registry == null)
            serviceRegistry = registry;
    }
    //endregion


    //region Private Helpers
    //endregion

    //region Overrides
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void onImportBooks(ActionEvent actionEvent) {
    }
    //endregion
}
