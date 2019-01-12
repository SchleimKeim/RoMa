package ch.zhaw.roma.helpers.excel;

import ch.zhaw.roma.model.excel.ExcelSheet;
import ch.zhaw.roma.model.excel.ExcelSheetType;
import ch.zhaw.roma.model.excel.SheetType;
import ch.zhaw.roma.model.excel.inhouse.InhouseSheet;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ExcelImporterTest {

    //region Private Fields
    private final Path testFile = Paths.get("src/test/resources/Verkäufe2017_offizielle_Zahlen.dev.xlsx");
    private final SheetType expectedType = new ExcelSheetType(SheetType.Verlagsabrechnung).getType();
    //endregion

    //region Tests
    @Test
    public void getFile() {
        String debug1 = getTestInstance().getFile().toAbsolutePath().toString();
        String debug2 = testFile.toAbsolutePath().toString();
        Assert.assertTrue(debug2.equalsIgnoreCase(debug1));
    }

    @Test
    public void getType() {
        Assert.assertTrue(getTestInstance().getType().equals(expectedType));
    }

    @Test
    public void importTest()
    {
        ExcelSheet excelSheet = getTestInstance().Import();
        Assert.assertNotNull(excelSheet);

        InhouseSheet testSheet = excelSheet.asInhouse();
        Assert.assertTrue(testSheet.getRowCount() > 1);
    }
    //endregion

    //region Private Helpers
    private ExcelImporter getTestInstance() {
        ExcelImporter imp = new ExcelImporter(testFile.toString(), SheetType.Verlagsabrechnung);
        Assert.assertNotNull(imp);
        return  imp;
    }
    //endregion
}