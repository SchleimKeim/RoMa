package ch.zhaw.roma.controller;

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
    //endregion

    //region Private Helpers
    //endregion

    //region Overrides
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setDbConnection(SessionFactory factory, StandardServiceRegistry registry) {
        if(sessionFactory == null)
            sessionFactory = factory;
        if(serviceRegistry == null)
            serviceRegistry = registry;
    }
    //endregion
}
