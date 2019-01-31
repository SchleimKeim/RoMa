package ch.zhaw.roma.controller;

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
    public void setDbConnection(StandardServiceRegistry registry, SessionFactory factory) {
        serviceRegistry = registry;
        sessionFactory = factory;
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

    /*
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
     */
    //endregion
}
