package ch.zhaw.roma.model.excel.persistence;

import ch.zhaw.roma.helpers.excel.ExcelImporter;
import ch.zhaw.roma.model.excel.SheetType;
import ch.zhaw.roma.model.excel.bookwire.BookWireSheet;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class BookWireSheetModelTest {

    private final Path bookWireFile = Paths.get("src/test/resources/bookwire.xlsx");

    @Test
    public void BookWireSheetModelTest (){
        BookWireSheet sheet = new ExcelImporter(bookWireFile.toString(), SheetType.Bookwire).Import().asBookwire();
        Assert.assertNotNull(sheet);
        BookWireSheetModel modelsheet = ExcelToDbConverter.createFrom(sheet);
        Assert.assertNotNull(modelsheet);
    }
}
