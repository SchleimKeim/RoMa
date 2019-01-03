package ch.zhaw.roma.model.excel;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.Vector;

public class BookWireSheet extends ExcelSheet {

    private final static int MAX_COLUMNS = 29;
    private final static int START_ROW = 4;

    private final HSSFWorkbook workbook;
    private final Vector<BookWireRow> rows = new Vector<>();


    public BookWireSheet(HSSFWorkbook workbook) {
        this.workbook = workbook;
        Parse(workbook);
    }

    private void Parse(HSSFWorkbook workbook) {

        HSSFSheet defaultSheet = workbook.getSheetAt(0);

        int bottomRow = defaultSheet.getLastRowNum();
        int startRow = START_ROW;

        for(int column = defaultSheet.getLeftCol(); column < MAX_COLUMNS; column++) {
            for(int row = START_ROW; row < bottomRow; row++) {
                BookWireRow bookWireRow = new BookWireRow(defaultSheet.getRow(row));
                if(bookWireRow != null) {
                    rows.add(bookWireRow);
                }
            }
        }
    }
}
