package ch.zhaw.roma.customcontrols;

import ch.zhaw.roma.controller.PersonsViewController;
import ch.zhaw.roma.model.PersonModel;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;

import java.util.ArrayList;
import java.util.List;

public class PersonsView extends AnchorPane {
    //region Private Fields
    private List<PersonModel> list = new ArrayList<>();
    private ObservableList<PersonModel> persons = FXCollections.observableList(list);
    private SimpleObjectProperty<SessionFactory> sessionFactory = new SimpleObjectProperty<>(this, "sessionFactory");
    private SimpleObjectProperty<StandardServiceRegistry> serviceRegistry = new SimpleObjectProperty<>(this, "serviceRegistry");
    //endregion

    //region Construction
    public PersonsView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/PersonsView.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();

            PersonsViewController controller = fxmlLoader.getController();
            if(controller != null)
                controller.setDbConnection(getSessionFactory(), getServiceRegistry());

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    //endregion

    //region Getters And Setters
    public ObservableList<PersonModel> getPersons() {
        return persons;
    }

    public void setPersons(ObservableList<PersonModel> value) {
         persons = value;
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
