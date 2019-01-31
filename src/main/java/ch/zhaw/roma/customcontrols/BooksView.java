package ch.zhaw.roma.customcontrols;

import ch.zhaw.roma.controller.BooksViewController;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;

public class BooksView extends AnchorPane {
    private SimpleObjectProperty<SessionFactory> sessionFactory = new SimpleObjectProperty<>(this, "sessionFactory");
    private SimpleObjectProperty<StandardServiceRegistry> serviceRegistry = new SimpleObjectProperty<>(this, "serviceRegistry");

    //region Construction
    public BooksView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/BooksView.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();

            BooksViewController controller = fxmlLoader.getController();
            if(controller == null) {
                String stop = "";
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
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
