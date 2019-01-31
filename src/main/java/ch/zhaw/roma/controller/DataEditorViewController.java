package ch.zhaw.roma.controller;

import ch.zhaw.roma.model.BookModel;
import ch.zhaw.roma.model.PersonModel;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DataEditorViewController implements Initializable {

    //region Fields
    private List<BookModel> bookList = new ArrayList<>();
    public ObservableList<BookModel> books = FXCollections.observableList(bookList);
    private List<PersonModel> personList = new ArrayList<>();
    public ObservableList<PersonModel> persons = FXCollections.observableList(personList);

    private SimpleObjectProperty<StandardServiceRegistry> serviceRegistry = new SimpleObjectProperty<>(this, "serviceRegistry");
    private SimpleObjectProperty<SessionFactory> sessionFactory = new SimpleObjectProperty<>(this, "sessionFactory");

    public SimpleBooleanProperty personsViewVisibility = new SimpleBooleanProperty(this, "personsViewVisibility");
    public SimpleBooleanProperty booksViewVisibility = new SimpleBooleanProperty(this, "booksViewVisibility");
    //endregion

    //region Getters And Setters
    public ObservableList<PersonModel> getPersons() {
        return persons;
    }

    public void setPersons(ObservableList<PersonModel> persons) {
        this.persons = persons;
    }

    public ObservableList<BookModel> getBooks() {
        return books;
    }

    public void setBooks(ObservableList<BookModel> value) {
        books = value;
    }

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


    //region Public Members
    public void setDbInformation(SessionFactory factory, StandardServiceRegistry registry) {
        setSessionFactory(factory);
        setServiceRegistry(registry);
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

    //region Private Helpers
    private void showPersonsView() {
        setBooksViewVisibility(false);
        setPersonsViewVisibility(true);
    }

    private void showBooksView() {
        setPersonsViewVisibility(false);
        setBooksViewVisibility(true);
    }
    private void loadData() {
        SessionFactory factory = getSessionFactory();
        if(factory != null) {
            Session s = factory.openSession();
            List<BookModel> list = s.createQuery("FROM BOOKS").list();
            for(BookModel b : list)
                books.add(b);
        }
    }
    //endregion

    //region Overrides
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        showBooksView();
        loadData();
    }
    //endregion
}
