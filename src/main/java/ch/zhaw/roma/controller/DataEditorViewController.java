package ch.zhaw.roma.controller;

import ch.zhaw.roma.helpers.InitDBService;
import ch.zhaw.roma.helpers.InitDbResult;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;

import java.net.URL;
import java.util.ResourceBundle;

public class DataEditorViewController implements Initializable {
    //region Private Fields
    private SessionFactory sessionFactory;
    private StandardServiceRegistry serviceRegistry;
    //endregion

    //region Public Fields
    public AnchorPane personsView;
    public AnchorPane booksView;
    public SimpleBooleanProperty personsViewVisibility = new SimpleBooleanProperty(this, "personsViewVisibility");
    public SimpleBooleanProperty booksViewVisibility = new SimpleBooleanProperty(this, "booksViewVisibility");
    //endregion

    //region Getters And Setters
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
    //endregion

    //region Private Helpers
    private void initDb() {
        InitDBService service = new InitDBService();
        service.setOnSucceeded(e -> {
            InitDbResult result = (InitDbResult) e.getSource().getValue();
            if(result.IsSuccess()) {
                serviceRegistry = result.getServiceRegistry();
                sessionFactory = result.getSessionFactory();
                System.out.println("Datenbank geladen.");
            }
            else
                System.out.println("Datenbank NICHT geladen!");
        });
    }

    private void showPersonsView() {
        setBooksViewVisibility(false);
        setPersonsViewVisibility(true);
//        PersonsViewController controller = (PersonsViewController)personsView.getProperties().get("ctrl");
//        controller.setDbConnection(sessionFactory, serviceRegistry);
    }

    private void showBooksView() {
        setPersonsViewVisibility(false);
        setBooksViewVisibility(true);
//        BooksViewController controller = (BooksViewController) booksView.getProperties().get("ctrl");
//        controller.setDbConnection(sessionFactory, serviceRegistry);
    }

    //endregion

    //region Overrides
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initDb();
    }
    //endregion
}
