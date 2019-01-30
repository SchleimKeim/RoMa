package ch.zhaw.roma.helpers.excel;

import ch.zhaw.roma.model.excel.ExcelSheet;
import ch.zhaw.roma.model.excel.SheetType;
import ch.zhaw.roma.model.excel.bookwire.BookWireSheet;
import ch.zhaw.roma.model.excel.inhouse.InhouseSheet;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class ExcelImporterTest {

    //region Private Fields
    private final Path inhouseFile = Paths.get("src/test/resources/inhouse.xlsx");
    private final Path bookWireFile = Paths.get("src/test/resources/bookwire.xlsx");
    //endregion

    //region Tests
    @Test
    public void getFile() {
        String inhouse = inhouseFile.toAbsolutePath().toString();
        System.out.println(inhouse);
        Assert.assertTrue(inhouse.contains("inhouse"));


        String bookWire = bookWireFile.toAbsolutePath().toString();
        System.out.println(bookWire);
        Assert.assertTrue(bookWire.contains("bookwire"));
    }

    @Test
    public void loadInhouseSheetTest() {
        ExcelSheet excelSheet = getInhouse().importSheet();
        Assert.assertNotNull(excelSheet);

        InhouseSheet testSheet = excelSheet.asInhouse();
        Assert.assertTrue(testSheet.getRowCount() > 10);
        Assert.assertTrue(Arrays.stream(testSheet.getRows()).noneMatch(r -> r.getAmazonInventory().toString().isEmpty()));
    }

    @Test
    public void basicLoadBookWireSheetTest() {
        ExcelSheet excelSheet = getBookWire().importSheet();
        Assert.assertNotNull(excelSheet);
        BookWireSheet testSheet = excelSheet.asBookwire();
        Assert.assertTrue(testSheet.getRowCount() == 98);
    }
    //endregion

    //region Private Helpers
    private ExcelImporter getBookWire() {
        ExcelImporter imp = new ExcelImporter(bookWireFile.toAbsolutePath().toString(), SheetType.Bookwire);
        Assert.assertNotNull(imp);
        return imp;
    }

    private ExcelImporter getInhouse() {
        ExcelImporter imp = new ExcelImporter(inhouseFile.toString(), SheetType.Verlagsabrechnung);
        Assert.assertNotNull(imp);
        return imp;
    }
    //endregion
}