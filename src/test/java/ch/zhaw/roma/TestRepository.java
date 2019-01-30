package ch.zhaw.roma;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

public class TestRepository  {
    protected static SessionFactory sessionFactory;
    protected StandardServiceRegistry serviceRegistry;

    @Before
    public void before() {
         serviceRegistry = new StandardServiceRegistryBuilder()
                                                     .configure("hibernate.cfg.xml")
                                                     .build();
        try {
            sessionFactory = new MetadataSources(serviceRegistry)
                                 .buildMetadata()
                                 .buildSessionFactory();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
        }
    }


    @After
    public void after() {
        try {
            if (sessionFactory != null && !sessionFactory.isClosed())
                sessionFactory.close();
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }
}
