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

	private SessionFactory sessionFactory;

	@Before
	public void before() throws Exception {
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
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
		if ( sessionFactory != null ) {
			sessionFactory.close();
		}
	}

	@SuppressWarnings({ "unchecked" })
	@Test
	public void testBasicUsage() {
		// create a couple of events...
		if(sessionFactory == null)
			Assert.fail();

		BookModel[] books = getTestModels();

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		for(BookModel book: books) {
			session.save(book);
		}
		session.getTransaction().commit();
		session.close();

		// now lets pull events from the database and list them
		session = sessionFactory.openSession();
        session.beginTransaction();

		List<BookModel> result = session.createQuery( "from BookModel" ).list();
		Assert.assertTrue(result.stream().allMatch(r -> r != null));
      	session.getTransaction().commit();
        session.close();

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
