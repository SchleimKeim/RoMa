package ch.zhaw.roma.controller;

import ch.zhaw.roma.helpers.InitDBService;
import ch.zhaw.roma.helpers.InitDbResult;
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
    public AnchorPane peronsView;
    public AnchorPane booksView;
    //endregion

    //region Getters And Setters
    //endregion

    //region Construction
    public DataEditorViewController() {

    }
    //endregion

    //region Action Handler
    public void onShowBooksView(ActionEvent actionEvent) {
    }

    public void onShowPersonsView(ActionEvent actionEvent) {
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

    //endregion

    //region Overrides
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initDb();
    }
    //endregion
}
