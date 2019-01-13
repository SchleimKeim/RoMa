package ch.zhaw.roma.model.excel.bookwire;

import ch.zhaw.roma.model.excel.ExcelSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
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

    //region Construction
    public BookWireSheet(XSSFWorkbook workbook) {
        super(workbook, BookWireSheet.class);
        parse(workbook);
    }

    public static BookWireSheet load(String path) throws Exception {
        XSSFWorkbook workbook = getWorkbook(path);
        if (workbook == null)
            throw new Exception("Die Datei im parameter \'path\' konnte nicht geladen werden!");

        return new BookWireSheet(workbook);
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
            //return new XSSFWorkbook(POIFSFileSystem.create(Paths.get(path).toFile()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void parse(XSSFWorkbook workbook) {
        if ((workbook == null) || (workbook.getNumberOfSheets() == 0))
            return;

        XSSFSheet firstSheet = workbook.getSheetAt(0);

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

    private void loadRows(XSSFSheet sheet, int rowNum) {
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
