package ch.zhaw.roma.model.excel.inhouse;

import ch.zhaw.roma.model.excel.ExcelSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;

public class InhouseSheet extends ExcelSheet {

    private static final int FIRST_INHOUSE_SHEET_ROW = 4;
    private InhouseRow[] rows;

    protected InhouseSheet(HSSFWorkbook workbook) {
        super(workbook);
        rows = GetRows();
    }

    public static InhouseSheet Load(HSSFWorkbook workbook) {
        return new InhouseSheet(workbook);
    }

    private InhouseRow[] GetRows() {

        int rowCounter = 0;
        ArrayList<InhouseRow> result = new ArrayList<>();

        for (Sheet sheet: workbook) {
            for(Row row: sheet) {
                rowCounter++;
                if(rowCounter == FIRST_INHOUSE_SHEET_ROW) {
                    result.add(new InhouseRow(row));
                }
            }
        }
        return (InhouseRow[]) result.toArray();
    }
}
