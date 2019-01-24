package ch.zhaw.roma.model.excel.persistence;

import ch.zhaw.roma.TestRepository;
import ch.zhaw.roma.helpers.excel.ExcelImporter;
import ch.zhaw.roma.model.excel.SheetType;
import ch.zhaw.roma.model.excel.bookwire.BookWireSheet;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BookWireSheetModelTest extends TestRepository {

    private final Path bookWireFile = Paths.get("src/test/resources/bookwire.xlsx");
    private BookWireSheetModel bookWireSheetModel;

    @Test
    public void BookWireSheetModelTest(){
        BookWireSheet bookWireSheet = new ExcelImporter(bookWireFile.toString(), SheetType.Bookwire).Import().asBookwire();
        Assert.assertNotNull(bookWireSheet);
        bookWireSheetModel = ExcelToEntityConverter.createFrom(bookWireSheet);
        Assert.assertNotNull(bookWireSheetModel);
    }

    @Test
    public void saveBookWireSheetModelTest() {
        if(bookWireSheetModel == null)
            BookWireSheetModelTest();

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
    public void loadBookWireSheetTest() {
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
}
