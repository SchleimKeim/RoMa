package ch.zhaw.roma.model.excel.bookwire;

import ch.zhaw.roma.model.excel.EmptyCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import java.util.stream.IntStream;

public class BookWireRow {

    //region Private Fields
    private String IsbnNumber;
    private String AuthorAndTitle;
    private int SoldUnitsJanuary;
    private double AmountJanuary;
    private int SoldUnitsFebruary;
    private double AmountFebruary;
    private int SoldUnitsMarch;
    private double AmountMarch;
    private int SoldUnitsApril;
    private double AmountApril;
    private int SoldUnitsMay;
    private double AmountMay;
    private int SoldUnitsJune;
    private double AmountJune;
    private int SoldUnitsJuly;
    private double AmountJuly;
    private int SoldUnitsAugust;
    private double AmountAugust;
    private int SoldUnitsSeptembre;
    private double AmountSeptembre;
    private int SoldUnitsOctobre;
    private double AmountOctobre;
    private int SoldUnitsNovember;
    private double AmountNovember;
    private int SoldUnitsDecember;
    private double AmountDecember;
    private int SoldUnitsTotal;
    private double AmountTotal;
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

        IsbnNumber = asString(cells[BookWireIndexes.ISBN]);
        AuthorAndTitle = asString(cells[BookWireIndexes.AUTHOR_AND_TITLE]);
        SoldUnitsJanuary = asInt(cells[BookWireIndexes.SALES_JANUARY]);
        AmountJanuary = asDouble(cells[BookWireIndexes.AMOUNT_JANUARY]);
        SoldUnitsFebruary = asInt(cells[BookWireIndexes.SALES_FEBRUARY]);
        AmountFebruary = asDouble(cells[BookWireIndexes.AMOUNT_JANUARY]);
        SoldUnitsMarch = asInt(cells[BookWireIndexes.SALES_FEBRUARY]);
        AmountMarch = asDouble(cells[BookWireIndexes.AMOUNT_JANUARY]);
        SoldUnitsApril = asInt(cells[BookWireIndexes.SALES_FEBRUARY]);
        AmountApril = asDouble(cells[BookWireIndexes.AMOUNT_JANUARY]);
        SoldUnitsMay = asInt(cells[BookWireIndexes.SALES_FEBRUARY]);
        AmountMay = asDouble(cells[BookWireIndexes.AMOUNT_JANUARY]);
        AmountJune = asDouble(cells[BookWireIndexes.AMOUNT_JANUARY]);
        SoldUnitsJuly = asInt(cells[BookWireIndexes.SALES_FEBRUARY]);
        AmountJuly = asDouble(cells[BookWireIndexes.AMOUNT_JANUARY]);
        SoldUnitsAugust = asInt(cells[BookWireIndexes.SALES_FEBRUARY]);
        AmountAugust = asDouble(cells[BookWireIndexes.AMOUNT_JANUARY]);
        SoldUnitsSeptembre = asInt(cells[BookWireIndexes.SALES_FEBRUARY]);
        AmountSeptembre = asDouble(cells[BookWireIndexes.AMOUNT_JANUARY]);
        SoldUnitsOctobre = asInt(cells[BookWireIndexes.SALES_FEBRUARY]);
        AmountOctobre = asDouble(cells[BookWireIndexes.AMOUNT_JANUARY]);
        SoldUnitsNovember = asInt(cells[BookWireIndexes.SALES_FEBRUARY]);
        AmountNovember = asDouble(cells[BookWireIndexes.AMOUNT_JANUARY]);
        SoldUnitsDecember = asInt(cells[BookWireIndexes.SALES_FEBRUARY]);
        AmountDecember = asDouble(cells[BookWireIndexes.AMOUNT_JANUARY]);

        SoldUnitsTotal = calculateTotalUnitsSold();
        AmountTotal = calculateTotalAmount();
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
        return AmountTotal = AmountJanuary
            + AmountFebruary
            + AmountMarch
            + AmountApril
            + AmountMay
            + AmountJune
            + AmountJuly
            + AmountAugust
            + AmountSeptembre
            + AmountOctobre
            + AmountNovember
            + AmountDecember;
    }

    public int calculateTotalUnitsSold() {
        return SoldUnitsTotal = SoldUnitsJanuary
            + SoldUnitsFebruary
            + SoldUnitsMarch
            + SoldUnitsApril
            + SoldUnitsMay
            + SoldUnitsJune
            + SoldUnitsJuly
            + SoldUnitsAugust
            + SoldUnitsSeptembre
            + SoldUnitsOctobre
            + SoldUnitsNovember
            + SoldUnitsDecember;
    }
    //endregion

    //region Getters And Setters
    public String getIsbnNumber() {
        return IsbnNumber;
    }

    public String getAuthorAndTitle() {
        return AuthorAndTitle;
    }

    public int getSoldUnitsJanuary() {
        return SoldUnitsJanuary;
    }

    public double getAmountJanuary() {
        return AmountJanuary;
    }

    public int getSoldUnitsFebruary() {
        return SoldUnitsFebruary;
    }

    public double getAmountFebruary() {
        return AmountFebruary;
    }

    public int getSoldUnitsMarch() {
        return SoldUnitsMarch;
    }

    public double getAmountMarch() {
        return AmountMarch;
    }

    public int getSoldUnitsApril() {
        return SoldUnitsApril;
    }

    public double getAmountApril() {
        return AmountApril;
    }

    public int getSoldUnitsMay() {
        return SoldUnitsMay;
    }

    public double getAmountMay() {
        return AmountMay;
    }

    public int getSoldUnitsJune() {
        return SoldUnitsJune;
    }

    public double getAmountJune() {
        return AmountJune;
    }

    public int getSoldUnitsJuly() {
        return SoldUnitsJuly;
    }

    public double getAmountJuly() {
        return AmountJuly;
    }

    public int getSoldUnitsAugust() {
        return SoldUnitsAugust;
    }

    public double getAmountAugust() {
        return AmountAugust;
    }

    public int getSoldUnitsSeptembre() {
        return SoldUnitsSeptembre;
    }

    public double getAmountSeptembre() {
        return AmountSeptembre;
    }

    public int getSoldUnitsOctobre() {
        return SoldUnitsOctobre;
    }

    public double getAmountOctobre() {
        return AmountOctobre;
    }

    public int getSoldUnitsNovember() {
        return SoldUnitsNovember;
    }

    public double getAmountNovember() {
        return AmountNovember;
    }

    public int getSoldUnitsDecember() {
        return SoldUnitsDecember;
    }

    public double getAmountDecember() {
        return AmountDecember;
    }

    public int getSoldUnitsTotal() {
        return SoldUnitsTotal;
    }

    public double getAmountTotal() {
        return AmountTotal;
    }
    //endregion

}
