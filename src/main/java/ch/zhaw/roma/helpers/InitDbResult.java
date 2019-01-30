package ch.zhaw.roma.helpers;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.service.ServiceRegistry;

import java.util.function.BooleanSupplier;

public class InitDbResult {
    //region Private Fields
    private final BooleanSupplier success;
    private SessionFactory sessionFactory;
    private StandardServiceRegistry serviceRegistry;
    //endregion

    //region Getters And Setters
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public StandardServiceRegistry getServiceRegistry() {
        return serviceRegistry;
    }
    //endregion

    //region Construction
    public InitDbResult(StandardServiceRegistry registry, SessionFactory factory) {
        serviceRegistry = registry;
        sessionFactory = factory;
        success = () -> ((sessionFactory != null) && (serviceRegistry != null));
    }
    //endregion

    //region Public Members
    public boolean IsSuccess() {
        return success.getAsBoolean();
    }
    //endregion
}
