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
    private final Path bookWireFile = Paths.get("src/test/resources/bookwire.ods");
    //endregion

    //region Tests
    @Test
    public void getFile() {
        String path1 = getInhouseInstance().getFile().toAbsolutePath().toString();
        String path2 = inhouseFile.toAbsolutePath().toString();
        Assert.assertTrue(path2.equalsIgnoreCase(path1));
    }

    @Test
    public void getType() {
        Assert.assertTrue(getInhouseInstance().getType().equals(SheetType.Verlagsabrechnung));
    }

    @Test
    public void loadInhouseSheetTest()
    {
        ExcelSheet excelSheet = getInhouseInstance().Import();
        Assert.assertNotNull(excelSheet);

        InhouseSheet testSheet = excelSheet.asInhouse();
        Assert.assertTrue(testSheet.getRowCount() > 10);
        Assert.assertTrue(Arrays.stream(testSheet.getRows()).noneMatch(r -> r.getAmazonInventory().toString().isEmpty()));
    }

    @Test
    public void loadBookWireSheetTest()
    {
        ExcelSheet excelSheet = getBookWireInstance().Import();
        Assert.assertNotNull(excelSheet);
        BookWireSheet testSheet = excelSheet.asBookwire();
        Assert.assertTrue(testSheet.getRowCount() > 10);
        Assert.assertTrue(Arrays.stream(testSheet.getRows()).count() > 5);
        Assert.assertTrue(Arrays.stream(testSheet.getRows()).allMatch(r -> r.getAmountTotal() > 1));
    }
    //endregion

    //region Private Helpers
    private ExcelImporter getBookWireInstance() {
        ExcelImporter imp = new ExcelImporter(bookWireFile.toAbsolutePath().toString(), SheetType.Bookwire);
        Assert.assertNotNull(imp);
        return imp;
    }
    private ExcelImporter getInhouseInstance() {
        ExcelImporter imp = new ExcelImporter(inhouseFile.toString(), SheetType.Verlagsabrechnung);
        Assert.assertNotNull(imp);
        return imp;
    }
    //endregion
}