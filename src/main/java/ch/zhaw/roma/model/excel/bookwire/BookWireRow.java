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
    private int soldUnitsSeptembre;
    private double amountSeptembre;
    private int soldUnitsOctobre;
    private double amountOctobre;
    private int soldUnitsNovember;
    private double amountNovember;
    private int soldUnitsDecember;
    private double amountDecember;
    private int soldUnitsTotal;
    private double amountTotal;
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
            }
            catch (Exception ex) {
                return new EmptyCell();
            }
        }).toArray(Cell[]::new);

        isbnNumber = asString(cells[BookWireIndexes.ISBN]);
        authorAndTitle = asString(cells[BookWireIndexes.AUTHOR_AND_TITLE]);
        soldUnitsJanuary = asInt(cells[BookWireIndexes.SALES_JANUARY]);
        amountJanuary = asDouble(cells[BookWireIndexes.AMOUNT_JANUARY]);
        soldUnitsFebruary = asInt(cells[BookWireIndexes.SALES_FEBRUARY]);
        amountFebruary = asDouble(cells[BookWireIndexes.AMOUNT_JANUARY]);
        soldUnitsMarch = asInt(cells[BookWireIndexes.SALES_FEBRUARY]);
        amountMarch = asDouble(cells[BookWireIndexes.AMOUNT_JANUARY]);
        soldUnitsApril = asInt(cells[BookWireIndexes.SALES_FEBRUARY]);
        amountApril = asDouble(cells[BookWireIndexes.AMOUNT_JANUARY]);
        soldUnitsMay = asInt(cells[BookWireIndexes.SALES_FEBRUARY]);
        amountMay = asDouble(cells[BookWireIndexes.AMOUNT_JANUARY]);
        amountJune = asDouble(cells[BookWireIndexes.AMOUNT_JANUARY]);
        soldUnitsJuly = asInt(cells[BookWireIndexes.SALES_FEBRUARY]);
        amountJuly = asDouble(cells[BookWireIndexes.AMOUNT_JANUARY]);
        soldUnitsAugust = asInt(cells[BookWireIndexes.SALES_FEBRUARY]);
        amountAugust = asDouble(cells[BookWireIndexes.AMOUNT_JANUARY]);
        soldUnitsSeptembre = asInt(cells[BookWireIndexes.SALES_FEBRUARY]);
        amountSeptembre = asDouble(cells[BookWireIndexes.AMOUNT_JANUARY]);
        soldUnitsOctobre = asInt(cells[BookWireIndexes.SALES_FEBRUARY]);
        amountOctobre = asDouble(cells[BookWireIndexes.AMOUNT_JANUARY]);
        soldUnitsNovember = asInt(cells[BookWireIndexes.SALES_FEBRUARY]);
        amountNovember = asDouble(cells[BookWireIndexes.AMOUNT_JANUARY]);
        soldUnitsDecember = asInt(cells[BookWireIndexes.SALES_FEBRUARY]);
        amountDecember = asDouble(cells[BookWireIndexes.AMOUNT_JANUARY]);

        soldUnitsTotal = calculateTotalUnitsSold();
        amountTotal = calculateTotalAmount();
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
        }
        catch (NumberFormatException ex) {
            return error;
        }
    }

    private int asInt(Cell cell) {
        final int error = -1;
        try {
        CellType type = cell.getCellType();
        return ((type != CellType.BLANK)
            && (type == CellType.NUMERIC))
                ? Integer.parseInt(Double.toString(cell.getNumericCellValue()))
                : error;
        }
        catch (NumberFormatException ex) {
            return error;
        }
    }
    //endregion

    //region Public Members
    public double calculateTotalAmount() {
        return amountTotal = amountJanuary
            + amountFebruary
            + amountMarch
            + amountApril
            + amountMay
            + amountJune
            + amountJuly
            + amountAugust
            + amountSeptembre
            + amountOctobre
            + amountNovember
            + amountDecember;
    }

    public int calculateTotalUnitsSold() {
        return soldUnitsTotal = soldUnitsJanuary
            + soldUnitsFebruary
            + soldUnitsMarch
            + soldUnitsApril
            + soldUnitsMay
            + soldUnitsJune
            + soldUnitsJuly
            + soldUnitsAugust
            + soldUnitsSeptembre
            + soldUnitsOctobre
            + soldUnitsNovember
            + soldUnitsDecember;
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

    public int getSoldUnitsJune() {
        return soldUnitsJune;
    }

    public double getAmountJune() {
        return amountJune;
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

    public int getSoldUnitsSeptembre() {
        return soldUnitsSeptembre;
    }

    public double getAmountSeptembre() {
        return amountSeptembre;
    }

    public int getSoldUnitsOctobre() {
        return soldUnitsOctobre;
    }

    public double getAmountOctobre() {
        return amountOctobre;
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

    public int getSoldUnitsTotal() {
        return soldUnitsTotal;
    }

    public double getAmountTotal() {
        return amountTotal;
    }
    //endregion

}
