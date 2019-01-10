package ch.zhaw.roma.model.excel.bookwire;

import ch.zhaw.roma.model.excel.ExcelSheet;
import ch.zhaw.roma.model.excel.Indexes;
import ch.zhaw.roma.model.excel.bookwire.BookWireFinancialRow;
import ch.zhaw.roma.model.excel.bookwire.BookWireRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.util.ArrayList;

public class BookWireSheet extends ExcelSheet {

    private final ArrayList<BookWireRow> rows = new ArrayList<>();
    private String title;
    private String header1;
    private String header2;


    public BookWireSheet(HSSFWorkbook workbook) {
        Parse(workbook);
    }

    private void Parse(HSSFWorkbook workbook) {
        if (workbook == null)
            return;

        for (Row cells : workbook.getSheetAt(0)) {

            int rowNum = cells.getRowNum();
            if (rowNum == Indexes.TITLE.getValue())
                title = joinToString(cells);
            else if (rowNum == Indexes.HEADER1.getValue())
                header1 = joinToString(cells);
            else if (rowNum == Indexes.HEADER2.getValue())
                header2 = joinToString(cells);
            else
                rows.add(new BookWireFinancialRow(cells));
        }
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
}
