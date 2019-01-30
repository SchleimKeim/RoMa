package ch.zhaw.roma.model.excel.inhouse;

import ch.zhaw.roma.model.excel.ExcelSheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class InhouseSheet extends ExcelSheet {

    //region Private Fields
    private static final int FIRST_INHOUSE_SHEET_ROW = 4;
    private InhouseRow[] rows = new InhouseRow[0];
    //endregion

    //region Construction
    protected InhouseSheet(XSSFWorkbook workbook, String fileName) {
        super(workbook, InhouseSheet.class, fileName);
        loadRows();
    }
    //endregion

    //region Public Members
    public static InhouseSheet load(String path) throws Exception {
        XSSFWorkbook workbook = getWorkbook(path);
        if(workbook == null)
            throw new Exception("Die Datei im parameter \'path\' konnte nicht geladen werden!");

        return new InhouseSheet(workbook, path);
    }

    public int getRowCount() {
        if(rows != null)
            return  rows.length;
        else
            return 0;
    }
    //endregion

    //region Getters And Setters
    public InhouseRow[] getRows() {
        return rows;
    }
    //endregion


    //region Private Helpers
    private static XSSFWorkbook getWorkbook(String path) {
        try {
            return new XSSFWorkbook(Paths.get(path).toFile());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidFormatException e) {
            e.printStackTrace();
            return null;
        }
    }
    //endregion

    //region Overrides
    protected void loadRows() {
        int rowCounter = 0;
        ArrayList<InhouseRow> result = new ArrayList<>();
        for (Sheet s : workbook) {
            for (Row row : s) {
                rowCounter++;
                if (rowCounter >= FIRST_INHOUSE_SHEET_ROW) {
                    result.add(new InhouseRow(row));
                }
            }
        }
        rows = result.toArray(new InhouseRow[0]);
    }
    //endregion
}
