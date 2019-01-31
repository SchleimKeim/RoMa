package ch.zhaw.roma.controller;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;

import java.net.URL;
import java.util.ResourceBundle;

public class DataEditorViewController implements Initializable {
    //region Private Fields
    //endregion

    //region Public Fields
    public AnchorPane personsView;
    public SimpleBooleanProperty personsViewVisibility = new SimpleBooleanProperty(this, "personsViewVisibility");
    public SimpleBooleanProperty booksViewVisibility = new SimpleBooleanProperty(this, "booksViewVisibility");

    private SimpleObjectProperty<StandardServiceRegistry> serviceRegistry = new SimpleObjectProperty<>(this, "serviceRegistry");
    private SimpleObjectProperty<SessionFactory> sessionFactory = new SimpleObjectProperty<>(this, "sessionFactory");
    //endregion

    //region Getters And Setters
    public StandardServiceRegistry getServiceRegistry() {
        return serviceRegistry.get();
    }

    public void setServiceRegistry(StandardServiceRegistry serviceRegistry) {
        this.serviceRegistry.set(serviceRegistry);
    }

    public SimpleObjectProperty<StandardServiceRegistry> serviceRegistrySimpleObjectProperty() {
        return serviceRegistry;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory.get();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory.set(sessionFactory);
    }

    public SimpleObjectProperty<SessionFactory> sessionFactorySimpleObjectProperty() {
        return sessionFactory;
    }

    public BooleanProperty booksViewVisibilityProperty() {
        return booksViewVisibility;
    }

    public boolean getBooksViewVisibility() {
        return booksViewVisibility.get();
    }

    public void setBooksViewVisibility(boolean value) {
        this.booksViewVisibility.set(value);
    }

    public BooleanProperty personsViewVisibilityProperty() {
        return personsViewVisibility;
    }

    public boolean getPersonsViewVisibility() {
        return personsViewVisibility.get();
    }

    public void setPersonsViewVisibility(boolean value) {
        this.personsViewVisibility.set(value);
    }
    //endregion

    //region Construction
    public DataEditorViewController() {

    }
    //endregion

    //region Action Handler
    public void onShowBooksView(ActionEvent actionEvent) {
        showBooksView();
    }

    public void onShowPersonsView(ActionEvent actionEvent) {
        showPersonsView();
    }
    //endregion

    //region Public Members
    public void setDbConnection(StandardServiceRegistry registry, SessionFactory factory) {
        setServiceRegistry(registry);
        setSessionFactory(factory);
    }
    //endregion

    //region Private Helpers
    private void showPersonsView() {
        setBooksViewVisibility(false);
        setPersonsViewVisibility(true);
    }

    private void showBooksView() {
        setPersonsViewVisibility(false);
        setBooksViewVisibility(true);
    }
    //endregion

    //region Overrides
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    //endregion
}
