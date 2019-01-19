package ch.zhaw.roma.model.excel.persistence;
import ch.zhaw.roma.interfaces.IBookWireRowModel;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BookWireRowModel implements IBookWireRowModel {

    //region Private Fields
    private Long id;
    private BookWireSheetModel sheet;

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
    public BookWireRowModel() {

    }
    //endregion

    //region Getters and Setters
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public String getAuthorAndTitle() {
        return authorAndTitle;
    }

    public void setAuthorAndTitle(String authorAndTitle) {
        this.authorAndTitle = authorAndTitle;
    }

    public int getSoldUnitsJanuary() {
        return soldUnitsJanuary;
    }

    public void setSoldUnitsJanuary(int soldUnitsJanuary) {
        this.soldUnitsJanuary = soldUnitsJanuary;
    }

    public double getAmountJanuary() {
        return amountJanuary;
    }

    public void setAmountJanuary(double amountJanuary) {
        this.amountJanuary = amountJanuary;
    }

    public int getSoldUnitsFebruary() {
        return soldUnitsFebruary;
    }

    public void setSoldUnitsFebruary(int soldUnitsFebruary) {
        this.soldUnitsFebruary = soldUnitsFebruary;
    }

    public double getAmountFebruary() {
        return amountFebruary;
    }

    public void setAmountFebruary(double amountFebruary) {
        this.amountFebruary = amountFebruary;
    }

    public int getSoldUnitsMarch() {
        return soldUnitsMarch;
    }

    public void setSoldUnitsMarch(int soldUnitsMarch) {
        this.soldUnitsMarch = soldUnitsMarch;
    }

    public double getAmountMarch() {
        return amountMarch;
    }

    public void setAmountMarch(double amountMarch) {
        this.amountMarch = amountMarch;
    }

    public int getSoldUnitsApril() {
        return soldUnitsApril;
    }

    public void setSoldUnitsApril(int soldUnitsApril) {
        this.soldUnitsApril = soldUnitsApril;
    }

    public double getAmountApril() {
        return amountApril;
    }

    public void setAmountApril(double amountApril) {
        this.amountApril = amountApril;
    }

    public int getSoldUnitsMay() {
        return soldUnitsMay;
    }

    public void setSoldUnitsMay(int soldUnitsMay) {
        this.soldUnitsMay = soldUnitsMay;
    }

    public double getAmountMay() {
        return amountMay;
    }

    public void setAmountMay(double amountMay) {
        this.amountMay = amountMay;
    }

    public int getSoldUnitsJune() {
        return soldUnitsJune;
    }

    public void setSoldUnitsJune(int soldUnitsJune) {
        this.soldUnitsJune = soldUnitsJune;
    }

    public double getAmountJune() {
        return amountJune;
    }

    public void setAmountJune(double amountJune) {
        this.amountJune = amountJune;
    }

    public int getSoldUnitsJuly() {
        return soldUnitsJuly;
    }

    public void setSoldUnitsJuly(int soldUnitsJuly) {
        this.soldUnitsJuly = soldUnitsJuly;
    }

    public double getAmountJuly() {
        return amountJuly;
    }

    public void setAmountJuly(double amountJuly) {
        this.amountJuly = amountJuly;
    }

    public int getSoldUnitsAugust() {
        return soldUnitsAugust;
    }

    public void setSoldUnitsAugust(int soldUnitsAugust) {
        this.soldUnitsAugust = soldUnitsAugust;
    }

    public double getAmountAugust() {
        return amountAugust;
    }

    public void setAmountAugust(double amountAugust) {
        this.amountAugust = amountAugust;
    }

    public int getSoldUnitsSeptembre() {
        return soldUnitsSeptembre;
    }

    public void setSoldUnitsSeptembre(int soldUnitsSeptembre) {
        this.soldUnitsSeptembre = soldUnitsSeptembre;
    }

    public double getAmountSeptembre() {
        return amountSeptembre;
    }

    public void setAmountSeptembre(double amountSeptembre) {
        this.amountSeptembre = amountSeptembre;
    }

    public int getSoldUnitsOctobre() {
        return soldUnitsOctobre;
    }

    public void setSoldUnitsOctobre(int soldUnitsOctobre) {
        this.soldUnitsOctobre = soldUnitsOctobre;
    }

    public double getAmountOctobre() {
        return amountOctobre;
    }

    public void setAmountOctobre(double amountOctobre) {
        this.amountOctobre = amountOctobre;
    }

    public int getSoldUnitsNovember() {
        return soldUnitsNovember;
    }

    public void setSoldUnitsNovember(int soldUnitsNovember) {
        this.soldUnitsNovember = soldUnitsNovember;
    }

    public double getAmountNovember() {
        return amountNovember;
    }

    public void setAmountNovember(double amountNovember) {
        this.amountNovember = amountNovember;
    }

    public int getSoldUnitsDecember() {
        return soldUnitsDecember;
    }

    public void setSoldUnitsDecember(int soldUnitsDecember) {
        this.soldUnitsDecember = soldUnitsDecember;
    }

    public double getAmountDecember() {
        return amountDecember;
    }

    public void setAmountDecember(double amountDecember) {
        this.amountDecember = amountDecember;
    }

    public int getSoldUnitsTotal() {
        return soldUnitsTotal;
    }

    public void setSoldUnitsTotal(int soldUnitsTotal) {
        this.soldUnitsTotal = soldUnitsTotal;
    }

    public double getAmountTotal() {
        return amountTotal;
    }

    public void setAmountTotal(double amountTotal) {
        this.amountTotal = amountTotal;
    }

    public BookWireSheetModel getSheet() {
        return sheet;
    }

    public void setSheet(BookWireSheetModel sheet) {
        this.sheet = sheet;
    }
    //endregion
}