package ch.zhaw.roma;

import ch.zhaw.roma.model.BookModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PostgresTest {

    private SessionFactory sessionFactory;

    @Before
    public void before() throws Exception {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                                                     .configure("hibernate.cfg.xml") // configures settings createRowFrom hibernate.cfg.xml
                                                     .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    @After
    public void after() throws Exception {
        try {
            if (sessionFactory != null && !sessionFactory.isClosed())
                sessionFactory.close();
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Test
    public void testLoad() {
        final Session s = sessionFactory.openSession();
        s.beginTransaction();
        List existing = s.createQuery("FROM BOOKS", BookModel.class).getResultList();
        Assert.assertNotNull(existing);

        s.getTransaction().commit();
        s.flush();
        s.close();
    }

    @Test
    public void testSave() throws NoSuchFieldException {

        final Session s = sessionFactory.openSession();
        s.beginTransaction();
        List existing = s.createQuery(BookModel.class.toString()).getResultList();

        existing.addAll(Arrays.asList(getTestModels()));

        Transaction transaction = s.getTransaction();
        transaction.commit();
        //s.getTransaction().commit();
        s.close();

//        final Session load = sessionFactory.openSession();
//        load.beginTransaction();
//        List<BookModel> result = load.createQuery("FROM BOOKS", BookModel.class).getResultList();
//
//        Assert.assertTrue(result.stream().allMatch(r -> (r != null) && !r.getTitle().isEmpty()));
//
//        load.getTransaction().commit();
//        load.close();
//
//        Assert.assertTrue(true);
    }

    private BookModel[] getTestModels() {
        return new BookModel[]{
            new BookModel("xxxxxxx", "The Dark Tower"),
            new BookModel("xxxxxxx", "The King in Yellow"),
            new BookModel("xxxxxxx", "Cthulu")
        };
    }
}
