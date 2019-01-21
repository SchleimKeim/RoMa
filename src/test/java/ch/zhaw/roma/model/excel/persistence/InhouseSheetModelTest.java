package ch.zhaw.roma.model.excel.persistence;

import ch.zhaw.roma.helpers.excel.ExcelImporter;
import ch.zhaw.roma.model.excel.SheetType;
import ch.zhaw.roma.model.excel.inhouse.InhouseSheet;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class InhouseSheetModelTest {

    private final Path inhouseFile = Paths.get("src/test/resources/inhouse.xlsx");


    @Test
    public void InhouseSheetModelTest() {
        InhouseSheet sheet = new ExcelImporter(inhouseFile.toString(), SheetType.Verlagsabrechnung)
                .Import()
                .asInhouse();

        Assert.assertNotNull(sheet);
        InhouseSheetModel modelsheet = ExcelToDbConverter.createFrom(sheet);
        Assert.assertNotNull(modelsheet);
    }
}
