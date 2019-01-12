package ch.zhaw.roma.model.excel.inhouse;

import ch.zhaw.roma.model.excel.ExcelSheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;

public class InhouseSheet extends ExcelSheet {

    //region Private Fields
    private static final int FIRST_INHOUSE_SHEET_ROW = 4;
    private InhouseRow[] rows = new InhouseRow[0];
    //endregion

    //region Construction
    protected InhouseSheet(XSSFWorkbook workbook) {
        super(workbook);
        loadRows();
    }
    //endregion

    //region Public Members
    public static InhouseSheet Load(XSSFWorkbook workbook) {
        return new InhouseSheet(workbook);
    }

    public int getRowCount() {
        if(rows != null)
            return  rows.length;
        else
            return 0;
    }
    //endregion

    //region Private Helpers
    private void loadRows() {

        int rowCounter = 0;
        ArrayList<InhouseRow> result = new ArrayList<>();
        for (Sheet sheet : xssfWorkbook) {
            for (Row row : sheet) {
                rowCounter++;
                if (rowCounter >= FIRST_INHOUSE_SHEET_ROW) {
                    result.add(new InhouseRow(row));
                }
            }
        }
        rows = result.toArray(new InhouseRow[0]);
    }
    //endregion

    //region Getters And Setters
    public InhouseRow[] getRows() {
        return rows;
    }
    //endregion
}
