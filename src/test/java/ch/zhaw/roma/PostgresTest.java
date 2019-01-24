package ch.zhaw.roma;

import ch.zhaw.roma.model.BookModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PostgresTest {

    private static SessionFactory sessionFactory;

    @Before
    public void before() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                                                     .configure("hibernate.cfg.xml")
                                                     .build();
        try {
            sessionFactory = new MetadataSources(registry)
                                 //.addAnnotatedClass(BookModel.class)
                                 .buildMetadata()
                                 .buildSessionFactory();

            fillTables();
            Assert.assertTrue(true);

        } catch (Exception e) {
            Assert.fail(e.getMessage());
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    private void fillTables() {
        try {
            Session s = sessionFactory.openSession();
            s.beginTransaction();
            for (BookModel b : getTestModels())
                s.save(b);

            s.getTransaction().commit();
            Assert.assertTrue(true);
        }
        catch (Exception ex) {
            Assert.fail(ex.getMessage());
            Assert.assertTrue(false);
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

    @Test()
    public void testLoad() {
        final Session s = sessionFactory.openSession();
        try {
            s.beginTransaction();
            List<BookModel> existing = s.createQuery("FROM BookModel").list();
            s.getTransaction().commit();
            Assert.assertTrue(existing != null);
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
            if (s != null) {
                s.flush();
                s.disconnect();
            }
        }
    }

    @Test
    public void testSave() {

        final Session s = sessionFactory.openSession();
        try {
            s.beginTransaction();
            List<BookModel> existing = s.createQuery("FROM BookModel").list();
            Assert.assertNotNull(existing);
            BookModel newEntry = new BookModel("XXXXXwwQ", "Der Wind in den Hosen");
            s.save(newEntry);
            s.getTransaction().commit();


            s.beginTransaction();
            List<BookModel> updated = s.createQuery("FROM BookModel").list();
            s.getTransaction().commit();

            Assert.assertNotNull(updated);
            Assert.assertTrue(updated.stream().anyMatch(b -> b.getTitle().contains("Hose")));

            s.close();
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
            if (s != null) {
                s.flush();
                s.disconnect();
            }
            return;
        }

        Assert.assertTrue(true);
    }

    private final BookModel[] getTestModels() {
        return new BookModel[]{
            new BookModel("xxxxxxx", "The Dark Tower"),
            new BookModel("xxxxxxx", "The King in Yellow"),
            new BookModel("xxxxxxx", "Cthulu")
        };
    }
}
