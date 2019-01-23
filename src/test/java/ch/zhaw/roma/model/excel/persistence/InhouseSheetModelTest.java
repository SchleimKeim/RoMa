package ch.zhaw.roma.model.excel.persistence;

import ch.zhaw.roma.TestRepository;
import ch.zhaw.roma.helpers.excel.ExcelImporter;
import ch.zhaw.roma.model.excel.SheetType;
import ch.zhaw.roma.model.excel.inhouse.InhouseSheet;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class InhouseSheetModelTest extends TestRepository {

    private final Path inhouseFile = Paths.get("src/test/resources/inhouse.xlsx");
    private InhouseSheetModel inhouseSheetModel;

    @Test
    public void InhouseSheetModelTest() {
        InhouseSheet sheet = new ExcelImporter(inhouseFile.toString(), SheetType.Verlagsabrechnung)
                .Import()
                .asInhouse();

        Assert.assertNotNull(sheet);
        inhouseSheetModel = ExcelToEntityConverter.createFrom(sheet);
        Assert.assertNotNull(inhouseSheetModel);
    }

    @Test
    public void saveSheetModelTest() {
        if(inhouseSheetModel == null)
            InhouseSheetModelTest();

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
