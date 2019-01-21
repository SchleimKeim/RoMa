package test.ch.zhaw.roma.model.excel.persistence;

import ch.zhaw.roma.TestRepository;
import ch.zhaw.roma.helpers.excel.ExcelImporter;
import ch.zhaw.roma.model.excel.SheetType;
import ch.zhaw.roma.model.excel.bookwire.BookWireSheet;
import ch.zhaw.roma.model.excel.inhouse.InhouseSheet;
import ch.zhaw.roma.model.excel.persistence.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * EntityTests Tester.
 *
 * @author Mathias Mader
 * @version 1.0
 * @since Jan 21, 2019
 */
public class EntityTestsTest {

    private final static SessionFactory sessionFactory = new TestRepository().getSessionFactory();
    //region Private Fields
    private Path inhouseFile;
    private InhouseSheet inhouseSheet;
    private InhouseSheetModel inhouseSheetModel;
    private Path bookWireFile;
    private BookWireSheet bookWireSheet;
    private BookWireSheetModel bookWireSheetModel;


    //endregion

    @Before
    public void before() throws Exception {
        inhouseFile = Paths.get("src/test/resources/inhouse.xlsx");
        inhouseSheet = new ExcelImporter(inhouseFile.toString(), SheetType.Verlagsabrechnung).Import().asInhouse();

        Assert.assertNotNull(inhouseFile);
        Assert.assertNotNull(sessionFactory);
        Assert.assertNotNull(inhouseSheet);

        inhouseSheetModel = ExcelToEntityConverter.createFrom(inhouseSheet);
        Assert.assertNotNull(inhouseSheetModel);
        Assert.assertTrue(inhouseSheetModel.getRows().size() == inhouseSheet.getRowCount());
        bookWireFile = Paths.get("src/test/resources/bookwire.xlsx");
        bookWireSheet = new ExcelImporter(bookWireFile.toString(), SheetType.Bookwire).Import().asBookwire();
        Assert.assertNotNull(bookWireSheet);
        bookWireSheetModel = ExcelToEntityConverter.createFrom(bookWireSheet);
        Assert.assertNotNull(bookWireSheetModel);

    }

    @Test
    public void saveBookwireSheetTest() {
        try {
            Session s = sessionFactory.openSession();
            s.beginTransaction();

            s.save(bookWireSheetModel);
            for (BookWireRowModel row : bookWireSheetModel.getRows())
                s.save(row);

            s.getTransaction().commit();
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Test
    public void loadBookwireTest() {
        try {
            Session s = sessionFactory.openSession();
            s.beginTransaction();
            List result = s.createSQLQuery("SELECT * FROM BOOKWIRE_SHEETS").list();
            Assert.assertNotNull(result);
            Assert.assertTrue(result.size() > 0);
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }


    @Test
    public void saveInhouseSheetTest() {
        try {
            Session s = sessionFactory.openSession();
            s.beginTransaction();

            s.save(inhouseSheetModel);
            for (InhouseRowModel row : inhouseSheetModel.getRows())
                s.save(row);

            s.getTransaction().commit();
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Test
    public void loadInhouseTest() {
        try {
            Session s = sessionFactory.openSession();
            s.beginTransaction();
            List result = s.createSQLQuery("SELECT * FROM INHOUSE_SHEETS").list();
            Assert.assertNotNull(result);
            Assert.assertTrue(result.size() > 0);
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }
}
