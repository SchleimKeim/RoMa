package ch.zhaw.roma;

import ch.zhaw.roma.interfaces.IRepositority;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class TestRepository implements IRepositority {

    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry registry;

    @Override
    public SessionFactory getSessionFactory() {
        if (registry == null)
            registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        if (sessionFactory == null)
            sessionFactory = loadSessionFactory();

        return sessionFactory;
    }

    private SessionFactory loadSessionFactory() {

        try {
            return (registry != null)
                       ? new MetadataSources(registry)
                             .buildMetadata()
                             .buildSessionFactory()
                       : null;

        } catch (Exception e) {
            if(registry != null)
                StandardServiceRegistryBuilder.destroy(registry);
            if((sessionFactory != null) && !sessionFactory.isClosed())
                sessionFactory.close();
        }
        return null;
    }
}
