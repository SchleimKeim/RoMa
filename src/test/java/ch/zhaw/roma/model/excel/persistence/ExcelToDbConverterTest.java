package ch.zhaw.roma.model.excel.persistence;

import ch.zhaw.roma.helpers.TestRepo;
import ch.zhaw.roma.helpers.excel.ExcelImporter;
import ch.zhaw.roma.model.excel.SheetType;
import ch.zhaw.roma.model.excel.inhouse.InhouseSheet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ExcelToDbConverterTest {

    private final Path inhouseFile = Paths.get("src/test/resources/inhouse.xlsx");
    private final Path bookWireFile = Paths.get("src/test/resources/bookwire.xlsx");

    private Session session;

    @Before
    public void setUp() {
        SessionFactory factory = new TestRepo().getSessionFactory();
        try {
            session = factory.openSession();
            Assert.assertNotNull(session);
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }

    }

    @After
    public void tearDown() throws Exception {
        try {
            if((session != null) && session.isOpen())
                session.close();
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Test
    public void createFromInhouse() {
        InhouseSheet sheet = new ExcelImporter(inhouseFile.toString(), SheetType.Verlagsabrechnung).Import().asInhouse();

        Session s = session;
        try {
            s.beginTransaction();
            s.save(ExcelToDbConverter.createFrom(sheet));
            s.getTransaction().commit();
            s.close();
        } catch (Exception ex) {
            if(s != null &&s != null &&  s.isOpen())
                s.close();
        }


    }

    @Test
    public void createFromBookWire() {
    }
}