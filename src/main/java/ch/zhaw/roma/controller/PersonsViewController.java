package ch.zhaw.roma.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.net.URL;
import java.util.ResourceBundle;

public class PersonsViewController implements Initializable {

    //region Private Fields
    SessionFactory sessionFactory;
    StandardServiceRegistry serviceRegistry;
    //endregion

    //region Public Fields
    public TextField firstName;
    public TextField lastName;
    public TextField street1;
    public TextField street2;
    public TextField street3;
    public TextField zipCode;
    public TextField city;
    public TextField country;
    public TextField email;
    public TextField website;
    public TextField mobilePhone;
    public TextField officePhone;
    public TextField privatePhone;
    public TextField greeting;
    //endregion

    //region Getters And Setters
    //endregion

    //region Construction
    public PersonsViewController() {
        initDb();
    }
    //endregion

    //region Public Members
    public void setDbConnection(SessionFactory factory, StandardServiceRegistry registry) {
        if (sessionFactory == null)
            sessionFactory = factory;
        if (registry == null)
            serviceRegistry = registry;
    }
    //endregion

    //region Action Handler
    public void onImportPersons(ActionEvent actionEvent) {
    }

    public void onSave(ActionEvent actionEvent) {
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

    //endregion

    //region Overrides
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(serviceRegistry == null || sessionFactory == null)
            initDb();
    }
    //endregion
}
