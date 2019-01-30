package ch.zhaw.roma.helpers;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class InitDBService extends Service<InitDbResult> {
    @Override
    protected Task<InitDbResult> createTask() {
        return new Task<InitDbResult>() {
            @Override
            protected InitDbResult call() {
                try {
                    StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                            .configure("hibernate.cfg.xml")
                            .build();
                    SessionFactory factory = new MetadataSources(registry)
                            .buildMetadata()
                            .buildSessionFactory();

                    return new InitDbResult(registry, factory);

                }catch (Exception ex) {
                    return new InitDbResult(null, null);
                }
            }
        };
    }
}
