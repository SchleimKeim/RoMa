package ch.zhaw.roma.model.excel.persistence;

import ch.zhaw.roma.helpers.excel.ExcelImporter;
import ch.zhaw.roma.model.excel.SheetType;
import ch.zhaw.roma.model.excel.bookwire.BookWireSheet;
import ch.zhaw.roma.model.excel.inhouse.InhouseSheet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ExcelToDbConverterTest {

    //region Private Fields
    private final Path inhouseFile = Paths.get("src/test/resources/inhouse.xlsx");
    private final Path bookWireFile = Paths.get("src/test/resources/bookwire.xlsx");
    private SessionFactory sessionFactory;
    //endregion

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
			Assert.fail(e.getMessage());
			StandardServiceRegistryBuilder.destroy( registry );
		}
	}

	@After
	public void after() {

        try {
            if ((sessionFactory != null) && !sessionFactory.isClosed())
                sessionFactory.close();
        }catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
	}

    @Test
    public void createFromInhouse() {
        InhouseSheet sheet = new ExcelImporter(inhouseFile.toString(), SheetType.Verlagsabrechnung).Import().asInhouse();

        Session s = sessionFactory.openSession();
        try {
            s.beginTransaction();
            s.save(ExcelToDbConverter.createFrom(sheet));
            s.getTransaction().commit();
            s.close();
        } catch (Exception ex) {
            if((s != null) &&  s.isOpen())
                s.close();
        }
    }

    @Test
    public void createFromBookWire() {
        BookWireSheet sheet = new ExcelImporter(bookWireFile.toString(), SheetType.Bookwire).Import().asBookwire();

        Session s = sessionFactory.openSession();
        try {
            s.beginTransaction();
            s.save(ExcelToDbConverter.createFrom(sheet));
            s.getTransaction().commit();
            s.close();
        } catch (Exception ex) {
            if(s != null && s.isOpen())
                s.close();
        }
    }
}