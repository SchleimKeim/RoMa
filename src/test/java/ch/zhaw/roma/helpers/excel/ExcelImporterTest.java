package ch.zhaw.roma.helpers.excel;

import ch.zhaw.roma.model.excel.ExcelSheetType;
import ch.zhaw.roma.model.excel.SheetType;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ExcelImporterTest {

    //region Private Fields
    private final Path testFile = Paths.get("Verkäufe2017_offizielle_Zahlen.dev.xlsx");
    private final SheetType expectedType = new ExcelSheetType(SheetType.Verlagsabrechnung).getType();
    //endregion

    //region Tests
    @Test
    public void getFile() {
        Assert.assertTrue(getTestInstance().getFile().toString() == testFile.toString());
    }

    @Test
    public void getType() {
        Assert.assertTrue(getTestInstance().getType().equals(expectedType));
    }

    @Test
    public void importTest()
    {
        Assert.assertNotNull(getTestInstance().Import());
        // TODO: am besten noch auf ein paar Properties hin testen...
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