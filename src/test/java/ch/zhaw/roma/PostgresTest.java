package ch.zhaw.roma;

import ch.zhaw.roma.model.test.TestBookModel;
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
                                 //.addAnnotatedClass(TestBookModel.class)
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
            for (TestBookModel b : getTestModels())
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
            List<TestBookModel> existing = s.createQuery("FROM TestBookModel").list();
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
            List<TestBookModel> existing = s.createQuery("FROM TestBookModel").list();
            Assert.assertNotNull(existing);
            TestBookModel newEntry = new TestBookModel("XXXXXwwQ", "Der Wind in den Hosen");
            s.save(newEntry);
            s.getTransaction().commit();


            s.beginTransaction();
            List<TestBookModel> updated = s.createQuery("FROM TestBookModel").list();
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

    private final TestBookModel[] getTestModels() {
        return new TestBookModel[]{
            new TestBookModel("xxxxxxx", "The Dark Tower"),
            new TestBookModel("xxxxxxx", "The King in Yellow"),
            new TestBookModel("xxxxxxx", "Cthulu")
        };
    }
}
