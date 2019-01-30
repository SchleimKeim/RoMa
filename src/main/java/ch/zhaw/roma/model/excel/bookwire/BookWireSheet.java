package ch.zhaw.roma.model.excel.bookwire;

import ch.zhaw.roma.model.excel.ExcelSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.stream.IntStream;

public class BookWireSheet extends ExcelSheet {

    //region Private Fields
    private static final int TITLE_ROW_NUMBER = 0;
    private static final int FIRST_DATA_ROW_NUMBER = 5;
    private BookWireRow[] rows;
    private String title;
    //endregion

    //region Construction
    public BookWireSheet(XSSFWorkbook workbook, String fileName) {
        super(workbook, BookWireSheet.class, fileName);
        parse(workbook);
    }

    public static BookWireSheet load(String path) throws Exception {
        XSSFWorkbook workbook = getWorkbook(path);
        if (workbook == null)
            throw new Exception("Die Datei im parameter \'path\' konnte nicht geladen werden!");

        return new BookWireSheet(workbook, path);
    }
    //endregion

    //region Overrides
    @Override
    public int getRowCount() {
        return (rows != null)
                   ? rows.length
                   : 0;
    }
    //endregion

    //region Public Members
    public BookWireRow[] getRows() {
        return (rows != null)
                   ? rows
                   : new BookWireRow[0];
    }
    //endregion

    //region Private Helpers
    private static XSSFWorkbook getWorkbook(String path) {
        try {
            return new XSSFWorkbook(path);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void parse(XSSFWorkbook workbook) {
        if ((workbook == null) || (workbook.getNumberOfSheets() == 0))
            return;

        Sheet firstSheet = workbook.getSheetAt(0);
        Cell titleCell = firstSheet.getRow(TITLE_ROW_NUMBER).getCell(0);

        title = (titleCell != null) && (titleCell.getCellType() == CellType.STRING)
            ? titleCell.getStringCellValue()
            : "";

        loadRows(firstSheet);
    }

    private void loadRows(Sheet sheet) {
        rows = IntStream.rangeClosed(
            FIRST_DATA_ROW_NUMBER,
            (sheet.getLastRowNum() - 1) // -1 because the last Row is just a summary.
        )
        .mapToObj(i -> new BookWireRow(sheet.getRow(i)))
        .toArray(BookWireRow[]::new);
    }
    //endregion
}
