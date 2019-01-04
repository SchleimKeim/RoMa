package ch.zhaw.roma.model.excel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Row;

public class BookWireFinancialRow extends BookWireRow{

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

    public BookWireFinancialRow(Row row) {

    }

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
}
