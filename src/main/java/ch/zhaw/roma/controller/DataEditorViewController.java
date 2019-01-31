package ch.zhaw.roma.controller;

import ch.zhaw.roma.model.BookModel;
import ch.zhaw.roma.model.PersonModel;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

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

    public SimpleBooleanProperty personsViewVisibility = new SimpleBooleanProperty(this, "personsViewVisibility");
    public SimpleBooleanProperty booksViewVisibility = new SimpleBooleanProperty(this, "booksViewVisibility");
    private StandardServiceRegistry serviceRegistry;
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

    private void initDb() {
        serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        SessionFactory sessionFactory = new MetadataSources(serviceRegistry)
                .buildMetadata()
                .buildSessionFactory();
    }

    //endregion

    //region Overrides
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initDb();
        showBooksView();
    }
    //endregion
}
