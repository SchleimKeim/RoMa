package ch.zhaw.roma.controller;

import ch.zhaw.roma.model.BookModel;
import ch.zhaw.roma.model.PersonModel;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CreateCalculationController implements Initializable {

    public Button closeButton;
    public ListView authorList;
    public ListView bookList;
    public Button importButton;

    public boolean getIsImportButtonDisabled() {
        return isImportButtonDisabled.get();
    }

    public SimpleBooleanProperty isImportButtonDisabledProperty() {
        return isImportButtonDisabled;
    }

    public void setIsImportButtonDisabled(boolean isImportButtonDisabled) {
        this.isImportButtonDisabled.set(isImportButtonDisabled);
    }

    private SimpleBooleanProperty isImportButtonDisabled = new SimpleBooleanProperty(true);
    public BookModel getSelectedBook() {
        return selectedBook.get();
    }

    public SimpleObjectProperty<BookModel> selectedBookProperty() {
        return selectedBook;
    }

    public void setSelectedBook(BookModel selectedBook) {
        this.selectedBook.set(selectedBook);
    }

    public PersonModel getSelectedPerson() {
        return selectedPerson.get();
    }

    public SimpleObjectProperty<PersonModel> selectedPersonProperty() {
        return selectedPerson;
    }

    public void setSelectedPerson(PersonModel selectedPerson) {
        this.selectedPerson.set(selectedPerson);
    }

    private SimpleObjectProperty<PersonModel> selectedPerson;
    private SimpleObjectProperty<BookModel> selectedBook;
    private StandardServiceRegistry serviceRegistry;
    private SessionFactory sessionFactory;
    private ArrayList<BookModel> bookModels = new ArrayList<>();
    private ArrayList<PersonModel> personModels = new ArrayList<>();

    public ObservableList<PersonModel> getAuthors() {
        return authors;
    }

    public void setAuthors(ObservableList<PersonModel> authors) {
        this.authors = authors;
    }

    private ObservableList<PersonModel> authors = FXCollections.observableArrayList(personModels);

    public ObservableList<BookModel> getBooks() {
        return books;
    }

    public void setBooks(ObservableList<BookModel> books) {
        this.books = books;
    }

    private ObservableList<BookModel> books = FXCollections.observableList(bookModels);

    private void initDb() {
        serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        sessionFactory = new MetadataSources(serviceRegistry)
                .buildMetadata()
                .buildSessionFactory();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initDb();
        setIsImportButtonDisabled(true);

        bookList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(oldValue != newValue) {
                setSelectedBook((BookModel)newValue);
            }
        });

        authorList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(oldValue != newValue) {
                setSelectedPerson((PersonModel)newValue);
            }
        });

        loadBooks();
        loadPeople();
    }

    private void loadPeople() {
     Session s = sessionFactory.openSession();
        s.beginTransaction();

        List<PersonModel> result = s.createQuery("FROM PersonModel").list();
        for(PersonModel p: result) {
            authors.add(p);
        }
    }

    private void loadBooks() {
        Session s = sessionFactory.openSession();
        s.beginTransaction();

        List<BookModel> result = s.createQuery("FROM BookModel").list();
        for(BookModel b: result) {
            books.add(b);
        }
    }

    public void onCreatePdf(ActionEvent actionEvent) {

    }

    public boolean canSave() {

        return false;
    }

    public void onClose(){
        Stage stage = ((Stage) closeButton.getScene().getWindow());
        if(stage != null)
            stage.close();
    }
}
