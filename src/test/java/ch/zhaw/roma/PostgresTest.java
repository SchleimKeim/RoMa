package ch.zhaw.roma;

import ch.zhaw.roma.model.BookModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
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
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			Assert.fail();
			StandardServiceRegistryBuilder.destroy( registry );
		}
	}

	@After
	public void after() throws Exception {
		try {
            if (sessionFactory != null && !sessionFactory.isClosed())
                sessionFactory.close();
		}catch (Exception ex) {
			Assert.fail(ex.getMessage());
		}
	}

	@Test
	public void testBasicUsage() {
		if(sessionFactory == null) {
			Assert.fail();
			return;
		}

		final Session save = sessionFactory.openSession();
		save.beginTransaction();
		Arrays.stream(getTestModels()).forEach(b -> save.save(b));
		save.getTransaction().commit();
		save.close();

		final Session load = sessionFactory.openSession();
        load.beginTransaction();
		List<BookModel> result = load.createQuery("From BookModel").getResultList();

		Assert.assertTrue(result.stream().allMatch(r -> (r != null) && !r.getTitle().isEmpty()));

      	load.getTransaction().commit();
        load.close();

        Assert.assertTrue(true);
	}

	private BookModel[] getTestModels() {
		return new BookModel[] {
			new BookModel("xxxxxxx", "The Dark Tower"),
			new BookModel("xxxxxxx", "The King in Yellow"),
			new BookModel("xxxxxxx", "Cthulu")
		};
	}
}
