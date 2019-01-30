package ch.zhaw.roma.model.excel.bookwire;

import ch.zhaw.roma.model.excel.EmptyCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import java.util.stream.IntStream;

public class BookWireRow {

    //region Private Fields
    private String isbnNumber;
    private String authorAndTitle;
    private String authorLastName;
    private String bookTitle;
    private int soldUnitsJanuary;
    private double amountJanuary;
    private int soldUnitsFebruary;
    private double amountFebruary;
    private int soldUnitsMarch;
    private double amountMarch;
    private int soldUnitsApril;
    private double amountApril;
    private int soldUnitsMay;
    private double amountMay;
    private int soldUnitsJune;
    private double amountJune;
    private int soldUnitsJuly;
    private double amountJuly;
    private int soldUnitsAugust;
    private double amountAugust;
    private int soldUnitsSeptember;
    private double amountSeptember;
    private int soldUnitsOctober;
    private double amountOctober;
    private int soldUnitsNovember;
    private double amountNovember;
    private int soldUnitsDecember;
    private double amountDecember;
    //endregion

    //region Construction
    public BookWireRow(Row row) {
        parse(row);
    }
    //endregion

    //region Private Helpers
    private void parse(Row row) {

        Cell[] cells = IntStream.range(0, row.getLastCellNum()).mapToObj(i -> {
            try {
                return row.getCell(i);
            } catch (Exception ex) {
                return new EmptyCell();
            }
        }).toArray(Cell[]::new);

        isbnNumber = asString(cells[BookWireIndexes.ISBN]);
        authorAndTitle = asString(cells[BookWireIndexes.AUTHOR_AND_TITLE]);
        setNameAndBookTitle(authorAndTitle);

        soldUnitsJanuary = asInt(cells[BookWireIndexes.SALES_JANUARY]);
        amountJanuary = asDouble(cells[BookWireIndexes.AMOUNT_JANUARY]);

        soldUnitsFebruary = asInt(cells[BookWireIndexes.SALES_FEBRUARY]);
        amountFebruary = asDouble(cells[BookWireIndexes.AMOUNT_FEBRUARY]);

        soldUnitsMarch = asInt(cells[BookWireIndexes.SALES_MARCH]);
        amountMarch = asDouble(cells[BookWireIndexes.AMOUNT_MARCH]);

        soldUnitsApril = asInt(cells[BookWireIndexes.SALES_APRIL]);
        amountApril = asDouble(cells[BookWireIndexes.AMOUNT_APRIL]);

        soldUnitsMay = asInt(cells[BookWireIndexes.SALES_MAY]);
        amountMay = asDouble(cells[BookWireIndexes.AMOUNT_MAY]);

        soldUnitsJune = asInt(cells[BookWireIndexes.SALES_JUNE]);
        amountJune = asDouble(cells[BookWireIndexes.AMOUNT_JUNE]);

        soldUnitsJuly = asInt(cells[BookWireIndexes.SALES_JULY]);
        amountJuly = asDouble(cells[BookWireIndexes.AMOUNT_JULY]);

        soldUnitsAugust = asInt(cells[BookWireIndexes.SALES_AUGUST]);
        amountAugust = asDouble(cells[BookWireIndexes.AMOUNT_AUGUST]);

        soldUnitsSeptember = asInt(cells[BookWireIndexes.SALES_SEPTEMBER]);
        amountSeptember = asDouble(cells[BookWireIndexes.AMOUNT_SEPTEMBER]);

        soldUnitsOctober = asInt(cells[BookWireIndexes.SALES_OCTOBER]);
        amountOctober = asDouble(cells[BookWireIndexes.AMOUNT_OCTOBER]);

        soldUnitsNovember = asInt(cells[BookWireIndexes.SALES_NOVEMBER]);
        amountNovember = asDouble(cells[BookWireIndexes.AMOUNT_NOVEMBER]);

        soldUnitsDecember = asInt(cells[BookWireIndexes.SALES_DECEMBER]);
        amountDecember = asDouble(cells[BookWireIndexes.AMOUNT_DECEMBER]);
    }

    private void setNameAndBookTitle(String authorAndTitle) {
        if(authorAndTitle == null || authorAndTitle.isEmpty() || !authorAndTitle.contains(",")) {
            setAuthorLastName("");
            setBookTitle("");
        }
        else {
            String[] split = authorAndTitle.split(",");
            setAuthorLastName(split[0]);
            setBookTitle(split[1]);
        }
    }

    private String asString(Cell cell) {
        CellType type = cell.getCellType();
        return ((type != CellType.BLANK)
                && (type == CellType.STRING))
                ? cell.getStringCellValue()
                : "";
    }


    private double asDouble(Cell cell) {
        final double error = -1d;
        try {
            CellType type = cell.getCellType();
            return ((type != CellType.BLANK)
                    && (type == CellType.NUMERIC))
                    ? cell.getNumericCellValue()
                    : error;
        } catch (NumberFormatException ex) {
            return error;
        }
    }

    private int asInt(Cell cell) {
        final int zero = 0;
        try {
            CellType type = cell.getCellType();

            if (type == CellType.BLANK)
                return zero;

            if (type == CellType.NUMERIC)
                return ((Double) cell.getNumericCellValue()).intValue();

            return zero;
        } catch (NumberFormatException ex) {
            return zero;
        }
    }
    //endregion

    //region Getters And Setters
    public String getIsbnNumber() {
        return isbnNumber;
    }

    public String getAuthorAndTitle() {
        return authorAndTitle;
    }

    public int getSoldUnitsJanuary() {
        return soldUnitsJanuary;
    }

    public double getAmountJanuary() {
        return amountJanuary;
    }

    public int getSoldUnitsFebruary() {
        return soldUnitsFebruary;
    }

    public double getAmountFebruary() {
        return amountFebruary;
    }

    public int getSoldUnitsMarch() {
        return soldUnitsMarch;
    }

    public double getAmountMarch() {
        return amountMarch;
    }

    public int getSoldUnitsApril() {
        return soldUnitsApril;
    }

    public double getAmountApril() {
        return amountApril;
    }

    public int getSoldUnitsMay() {
        return soldUnitsMay;
    }

    public double getAmountMay() {
        return amountMay;
    }

    public double getAmountJune() {
        return amountJune;
    }

    public int getSoldUnitsJune() {
        return soldUnitsJune;
    }

    public int getSoldUnitsJuly() {
        return soldUnitsJuly;
    }

    public double getAmountJuly() {
        return amountJuly;
    }

    public int getSoldUnitsAugust() {
        return soldUnitsAugust;
    }

    public double getAmountAugust() {
        return amountAugust;
    }

    public int getSoldUnitsSeptember() {
        return soldUnitsSeptember;
    }

    public double getAmountSeptember() {
        return amountSeptember;
    }

    public int getSoldUnitsOctober() {
        return soldUnitsOctober;
    }

    public double getAmountOctober() {
        return amountOctober;
    }

    public int getSoldUnitsNovember() {
        return soldUnitsNovember;
    }

    public double getAmountNovember() {
        return amountNovember;
    }

    public int getSoldUnitsDecember() {
        return soldUnitsDecember;
    }

    public double getAmountDecember() {
        return amountDecember;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    //endregion
}
