package ch.zhaw.roma.model.excel.bookwire;

import org.apache.poi.ss.usermodel.Row;

public class BookWireRow {

    //region Private Fields
    private String IsbnNumber;
    private String AuthorAndTitle;
    private int SoldUnitsJanuary;
    private Double AmountJanuary;
    private int SoldUnitsFebruary;
    private Double AmountFebruary;
    private int SoldUnitsMarch;
    private Double AmountMarch;
    private int SoldUnitsApril;
    private Double AmountApril;
    private int SoldUnitsMay;
    private Double AmountMay;
    private int SoldUnitsJune;
    private Double AmountJune;
    private int SoldUnitsJuly;
    private Double AmountJuly;
    private int SoldUnitsAugust;
    private Double AmountAugust;
    private int SoldUnitsSeptembre;
    private Double AmountSeptembre;
    private int SoldUnitsOctobre;
    private Double AmountOctobre;
    private int SoldUnitsNovember;
    private Double AmountNovember;
    private int SoldUnitsDecember;
    private Double AmountDecember;
    private int SoldUnitsTotal;
    private Double AmountTotal;
    //endregion

    //region Construction
    public BookWireRow(Row row) {
        parse(row);
    }
    //endregion

    //region Private Helpers
    private void parse(Row row) {
        IsbnNumber = row.getCell(BookWireIndexes.ISBN).getStringCellValue();
        AuthorAndTitle = row.getCell(BookWireIndexes.AUTHOR_AND_TITLE).getStringCellValue();
        SoldUnitsJanuary = toInt(row.getCell(BookWireIndexes.SALES_JANUARY).getStringCellValue());
        AmountJanuary = toDouble(row.getCell(BookWireIndexes.AMOUNT_JANUARY).getStringCellValue());
        SoldUnitsFebruary = toInt(row.getCell(BookWireIndexes.SALES_FEBRUARY).getStringCellValue());
        AmountFebruary = toDouble(row.getCell(BookWireIndexes.AMOUNT_JANUARY).getStringCellValue());
        SoldUnitsMarch = toInt(row.getCell(BookWireIndexes.SALES_FEBRUARY).getStringCellValue());
        AmountMarch = toDouble(row.getCell(BookWireIndexes.AMOUNT_JANUARY).getStringCellValue());
        SoldUnitsApril = toInt(row.getCell(BookWireIndexes.SALES_FEBRUARY).getStringCellValue());
        AmountApril = toDouble(row.getCell(BookWireIndexes.AMOUNT_JANUARY).getStringCellValue());
        SoldUnitsMay = toInt(row.getCell(BookWireIndexes.SALES_FEBRUARY).getStringCellValue());
        AmountMay = toDouble(row.getCell(BookWireIndexes.AMOUNT_JANUARY).getStringCellValue());
        SoldUnitsJune = toInt(row.getCell(BookWireIndexes.SALES_FEBRUARY).getStringCellValue());
        AmountJune = toDouble(row.getCell(BookWireIndexes.AMOUNT_JANUARY).getStringCellValue());
        SoldUnitsJuly = toInt(row.getCell(BookWireIndexes.SALES_FEBRUARY).getStringCellValue());
        AmountJuly = toDouble(row.getCell(BookWireIndexes.AMOUNT_JANUARY).getStringCellValue());
        SoldUnitsAugust = toInt(row.getCell(BookWireIndexes.SALES_FEBRUARY).getStringCellValue());
        AmountAugust = toDouble(row.getCell(BookWireIndexes.AMOUNT_JANUARY).getStringCellValue());
        SoldUnitsSeptembre = toInt(row.getCell(BookWireIndexes.SALES_FEBRUARY).getStringCellValue());
        AmountSeptembre = toDouble(row.getCell(BookWireIndexes.AMOUNT_JANUARY).getStringCellValue());
        SoldUnitsOctobre = toInt(row.getCell(BookWireIndexes.SALES_FEBRUARY).getStringCellValue());
        AmountOctobre = toDouble(row.getCell(BookWireIndexes.AMOUNT_JANUARY).getStringCellValue());
        SoldUnitsNovember = toInt(row.getCell(BookWireIndexes.SALES_FEBRUARY).getStringCellValue());
        AmountNovember = toDouble(row.getCell(BookWireIndexes.AMOUNT_JANUARY).getStringCellValue());
        SoldUnitsDecember = toInt(row.getCell(BookWireIndexes.SALES_FEBRUARY).getStringCellValue());
        AmountDecember = toDouble(row.getCell(BookWireIndexes.AMOUNT_JANUARY).getStringCellValue());
        SoldUnitsTotal = calculateTotalUnitsSold();
        AmountTotal = calculateTotalAmount();
    }


    private Double toDouble(String stringCellValue) {
        try {
            return Double.parseDouble(stringCellValue);
        }
        catch (NumberFormatException ex) {
            return 0d;
        }
    }

    private int toInt(String stringCellValue) {
        try {
            return Integer.parseInt(stringCellValue);
        }
        catch (NumberFormatException ex) {
            return -1;
        }
    }

    //endregion

    //region Public Members
    public Double calculateTotalAmount() {
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
    //

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

    public Double getAmountJanuary() {
        return AmountJanuary;
    }

    public int getSoldUnitsFebruary() {
        return SoldUnitsFebruary;
    }

    public Double getAmountFebruary() {
        return AmountFebruary;
    }

    public int getSoldUnitsMarch() {
        return SoldUnitsMarch;
    }

    public Double getAmountMarch() {
        return AmountMarch;
    }

    public int getSoldUnitsApril() {
        return SoldUnitsApril;
    }

    public Double getAmountApril() {
        return AmountApril;
    }

    public int getSoldUnitsMay() {
        return SoldUnitsMay;
    }

    public Double getAmountMay() {
        return AmountMay;
    }

    public int getSoldUnitsJune() {
        return SoldUnitsJune;
    }

    public Double getAmountJune() {
        return AmountJune;
    }

    public int getSoldUnitsJuly() {
        return SoldUnitsJuly;
    }

    public Double getAmountJuly() {
        return AmountJuly;
    }

    public int getSoldUnitsAugust() {
        return SoldUnitsAugust;
    }

    public Double getAmountAugust() {
        return AmountAugust;
    }

    public int getSoldUnitsSeptembre() {
        return SoldUnitsSeptembre;
    }

    public Double getAmountSeptembre() {
        return AmountSeptembre;
    }

    public int getSoldUnitsOctobre() {
        return SoldUnitsOctobre;
    }

    public Double getAmountOctobre() {
        return AmountOctobre;
    }

    public int getSoldUnitsNovember() {
        return SoldUnitsNovember;
    }

    public Double getAmountNovember() {
        return AmountNovember;
    }

    public int getSoldUnitsDecember() {
        return SoldUnitsDecember;
    }

    public Double getAmountDecember() {
        return AmountDecember;
    }

    public int getSoldUnitsTotal() {
        return SoldUnitsTotal;
    }

    public Double getAmountTotal() {
        return AmountTotal;
    }
    //endregion

}
