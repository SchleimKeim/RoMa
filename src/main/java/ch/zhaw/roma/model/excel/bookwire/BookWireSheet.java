package ch.zhaw.roma.model.excel.bookwire;

import ch.zhaw.roma.model.excel.ExcelSheet;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.util.stream.IntStream;

public class BookWireSheet extends ExcelSheet {

    //region Private Fields
    private static final int TITLE_ROW_INDEX = 0;
    private static final int HEADER1_ROW_INDEX = 1;
    private static final int HEADER2_ROW_INDEX = 3;
    private BookWireRow[] rows;
    private String title;
    private String header1;
    private String header2;
    //endregion

    //region Constructon
    public BookWireSheet(HSSFWorkbook workbook) {
        super(workbook);
        parse(workbook);
    }
    //endregion

    //region Overrides
    @Override
    public int getRowCount() {
        return rows.length;
    }
    //endregion

    //region Public Members
    public BookWireRow[] getRows() {
        return  (rows != null)
            ? rows
            : new BookWireRow[0];
    }
    //endregion

    //region Private Helpers
    private void parse(HSSFWorkbook workbook) {
        if (workbook == null)
            return;

        HSSFSheet firstSheet = workbook.getSheetAt(0);
        for (Row row : firstSheet) {

            int i = row.getRowNum();
            if (i == TITLE_ROW_INDEX) {
                title = joinToString(row);
            } else if (i == HEADER1_ROW_INDEX) {
                header1 = joinToString(row);
            } else if (i == HEADER2_ROW_INDEX) {
                header2 = joinToString(row);
            } else {
                loadRows(firstSheet, row.getRowNum());
                return;
            }
        }
    }

    private void loadRows(HSSFSheet sheet, int rowNum) {
        rows = (BookWireRow[]) IntStream.rangeClosed(rowNum, sheet.getPhysicalNumberOfRows())
                                   .mapToObj(i -> new BookWireRow(sheet.getRow(i)))
                                   .toArray();
    }

    private String joinToString(Row cells) {
        StringBuilder sb = new StringBuilder();
        for (Cell cell : cells) {
            String content = cell.getStringCellValue();
            if (!content.isEmpty())
                sb.append(content);
        }

        return sb.toString();
    }
    //endregion
}
