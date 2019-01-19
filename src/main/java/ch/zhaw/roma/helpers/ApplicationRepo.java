package ch.zhaw.roma.helpers;

import ch.zhaw.roma.interfaces.IRepositority;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

// 19.01.2019 mma: Class taken createRowFrom:
// https://www.baeldung.com/hibernate-one-to-many
// Until DI solution is found.
public class ApplicationRepo implements IRepositority {

    //region Private Fields
    private static SessionFactory sessionFactory;
    //endregion

    //region Private Helpers
    private SessionFactory buildSessionFactory() {

		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.xml") // configures settings createRowFrom hibernate.cfg.xml
				.build();
		try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
		catch (Exception e) {
            StandardServiceRegistryBuilder.destroy( registry );
        }

        return sessionFactory;
    }
    //endregion

    //region Public Members
    public SessionFactory getSessionFactory() {
        if(sessionFactory == null)
            sessionFactory = buildSessionFactory();

        return sessionFactory;
    }
    //endregion
}
