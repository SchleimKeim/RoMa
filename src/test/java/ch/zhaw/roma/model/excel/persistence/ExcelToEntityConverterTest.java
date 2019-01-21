package ch.zhaw.roma.model.excel.persistence;

import ch.zhaw.roma.helpers.excel.ExcelImporter;
import ch.zhaw.roma.model.excel.SheetType;
import ch.zhaw.roma.model.excel.bookwire.BookWireSheet;
import ch.zhaw.roma.model.excel.inhouse.InhouseSheet;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ExcelToEntityConverterTest {


    //region Private Fields
    private final Path inhouseFile = Paths.get("src/test/resources/inhouse.xlsx");
    private final Path bookWireFile = Paths.get("src/test/resources/bookwire.xlsx");
    //endregion

    @Test
    public void createFromInhouse() {
        InhouseSheet sheet = new ExcelImporter(
            inhouseFile.toString(),
            SheetType.Verlagsabrechnung
        )
        .Import()
        .asInhouse();
        Assert.assertNotNull(sheet);
        int rowCount = sheet.getRows().length;

        try {
            InhouseSheetModel modelSheet = ExcelToEntityConverter.createFrom(sheet);
            Assert.assertNotNull(modelSheet);
            Assert.assertTrue(modelSheet.getRows().size() == rowCount);
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Test
    public void createFromBookWire() {

        try {
            BookWireSheet sheet = new ExcelImporter(
                bookWireFile.toString(),
                SheetType.Bookwire
            ).Import()
            .asBookwire();

            BookWireSheetModel modelSheet = ExcelToEntityConverter.createFrom(sheet);
            Assert.assertNotNull(modelSheet);
            Assert.assertTrue(modelSheet.getRows().size() == sheet.getRowCount());
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }
}