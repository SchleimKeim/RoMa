package ch.zhaw.roma.customcontrols;

import ch.zhaw.roma.controller.BooksViewController;
import ch.zhaw.roma.model.BookModel;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;

import java.util.ArrayList;
import java.util.List;

public class BooksView extends AnchorPane {
    //region Fields
    private List<BookModel> list = new ArrayList<>();
    private ObservableList<BookModel> books = FXCollections.observableList(list);
    private SimpleObjectProperty<SessionFactory> sessionFactory = new SimpleObjectProperty<>(this, "sessionFactory");
    private SimpleObjectProperty<StandardServiceRegistry> serviceRegistry = new SimpleObjectProperty<>(this, "serviceRegistry");
    //endregion

    //region Construction
    public BooksView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/BooksView.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();

            BooksViewController controller = fxmlLoader.getController();
            if(controller != null)
                controller.setDbConnection(getSessionFactory(), getServiceRegistry());

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    //endregion

    //region Getters And Setters
    public ObservableList<BookModel> getBooks() {
        return books;
    }

    public void setBooks(ObservableList<BookModel> value) {
        books = value;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory.get();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory.set(sessionFactory);
    }

    public StandardServiceRegistry getServiceRegistry() {
        return serviceRegistry.get();
    }

    public void setServiceRegistry(StandardServiceRegistry serviceRegistry) {
        this.serviceRegistry.set(serviceRegistry);
    }
    //endregion
}
