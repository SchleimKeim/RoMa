package ch.zhaw.roma.model.excel.persistence;

import javax.persistence.*;

@Entity
@Access(AccessType.FIELD)
@Table(name = "BOOKWIRE_ROWS")
public class BookWireRowModel {

    //region Private Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROW_ID", nullable = false)
    private Long rowId;

    @ManyToOne
    @JoinColumn(name = "SHEET_ID", nullable = false)
    private BookWireSheetModel sheet;
    @Column(name = "ISBN_NUMBER")
    private String isbnNumber;
    @Column(name = "AUTHOR_AND_TITLE")
    private String authorAndTitle;
    @Column(name = "SOLDUNITS_JANUARY")
    private Integer soldUnitsJanuary;
    @Column(name = "AMOUNT_JANUARY")
    private Double amountJanuary;
    @Column(name = "SOLDUNITS_FEBRUARY")
    private Integer soldUnitsFebruary;
    @Column(name = "AMOUNT_FEBRUARY")
    private Double amountFebruary;
    @Column(name = "SOLDUNITS_MARCH")
    private Integer soldUnitsMarch;
    @Column(name = "AMOUN_TMARCH")
    private Double amountMarch;
    @Column(name = "SOLDUNITS_APRIL")
    private Integer soldUnitsApril;
    @Column(name = "AMOUNT_APRIL")
    private Double amountApril;
    @Column(name = "SOLDUNITS_MAY")
    private Integer soldUnitsMay;
    @Column(name = "AMOUNT_MAY")
    private Double amountMay;
    @Column(name = "SOLDUNITS_JUNE")
    private Integer soldUnitsJune;
    @Column(name = "AMOUNT_JUNE")
    private Double amountJune;
    @Column(name = "SOLDUNITS_JULY")
    private Integer soldUnitsJuly;
    @Column(name = "AMOUNT_JULY")
    private Double amountJuly;
    @Column(name = "SOLDUNITS_AUGUST")
    private Integer soldUnitsAugust;
    @Column(name = "AMOUNT_AUGUST")
    private Double amountAugust;
    @Column(name = "SOLDUNITS_SEPTEMBER")
    private Integer soldUnitsSeptember;
    @Column(name = "AMOUNT_SEPTEMBER")
    private Double amountSeptember;
    @Column(name = "SOLDUNITS_OCTOBER")
    private Integer soldUnitsOctober;
    @Column(name = "AMOUNT_OCTOBER")
    private Double amountOctober;
    @Column(name = "SOLDUNITS_NOVEMBER")
    private Integer soldUnitsNovember;
    @Column(name = "AMOUNT_NOVEMBER")
    private Double amountNovember;
    @Column(name = "SOLDUNITS_DECEMBER")
    private Integer soldUnitsDecember;
    @Column(name = "AMOUNT_DECEMBER")
    private Double amountDecember;
    //endregion

    //region Construction
    public BookWireRowModel() {

    }
    //endregion

    //region Getters and Setters
    public Long getRowId() {
        return rowId;
    }

    public void setRowId(Long rowId) {
        this.rowId = rowId;
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

    public Integer getSoldUnitsJanuary() {
        return soldUnitsJanuary;
    }

    public void setSoldUnitsJanuary(Integer soldUnitsJanuary) {
        this.soldUnitsJanuary = soldUnitsJanuary;
    }

    public Double getAmountJanuary() {
        return amountJanuary;
    }

    public void setAmountJanuary(Double amountJanuary) {
        this.amountJanuary = amountJanuary;
    }

    public Integer getSoldUnitsFebruary() {
        return soldUnitsFebruary;
    }

    public void setSoldUnitsFebruary(Integer soldUnitsFebruary) {
        this.soldUnitsFebruary = soldUnitsFebruary;
    }

    public Double getAmountFebruary() {
        return amountFebruary;
    }

    public void setAmountFebruary(Double amountFebruary) {
        this.amountFebruary = amountFebruary;
    }

    public Integer getSoldUnitsMarch() {
        return soldUnitsMarch;
    }

    public void setSoldUnitsMarch(Integer soldUnitsMarch) {
        this.soldUnitsMarch = soldUnitsMarch;
    }

    public Double getAmountMarch() {
        return amountMarch;
    }

    public void setAmountMarch(Double amountMarch) {
        this.amountMarch = amountMarch;
    }

    public Integer getSoldUnitsApril() {
        return soldUnitsApril;
    }

    public void setSoldUnitsApril(Integer soldUnitsApril) {
        this.soldUnitsApril = soldUnitsApril;
    }

    public Double getAmountApril() {
        return amountApril;
    }

    public void setAmountApril(Double amountApril) {
        this.amountApril = amountApril;
    }

    public Integer getSoldUnitsMay() {
        return soldUnitsMay;
    }

    public void setSoldUnitsMay(Integer soldUnitsMay) {
        this.soldUnitsMay = soldUnitsMay;
    }

    public Double getAmountMay() {
        return amountMay;
    }

    public void setAmountMay(Double amountMay) {
        this.amountMay = amountMay;
    }

    public Integer getSoldUnitsJune() {
        return soldUnitsJune;
    }

    public void setSoldUnitsJune(Integer soldUnitsJune) {
        this.soldUnitsJune = soldUnitsJune;
    }

    public Double getAmountJune() {
        return amountJune;
    }

    public void setAmountJune(Double amountJune) {
        this.amountJune = amountJune;
    }

    public Integer getSoldUnitsJuly() {
        return soldUnitsJuly;
    }

    public void setSoldUnitsJuly(Integer soldUnitsJuly) {
        this.soldUnitsJuly = soldUnitsJuly;
    }

    public Double getAmountJuly() {
        return amountJuly;
    }

    public void setAmountJuly(Double amountJuly) {
        this.amountJuly = amountJuly;
    }

    public Integer getSoldUnitsAugust() {
        return soldUnitsAugust;
    }

    public void setSoldUnitsAugust(Integer soldUnitsAugust) {
        this.soldUnitsAugust = soldUnitsAugust;
    }

    public Double getAmountAugust() {
        return amountAugust;
    }

    public void setAmountAugust(Double amountAugust) {
        this.amountAugust = amountAugust;
    }

    public Integer getSoldUnitsSeptember() {
        return soldUnitsSeptember;
    }

    public void setSoldUnitsSeptember(Integer soldUnitsSeptember) {
        this.soldUnitsSeptember = soldUnitsSeptember;
    }

    public Double getAmountSeptember() {
        return amountSeptember;
    }

    public void setAmountSeptember(Double amountSeptember) {
        this.amountSeptember = amountSeptember;
    }

    public Integer getSoldUnitsOctober() {
        return soldUnitsOctober;
    }

    public void setSoldUnitsOctober(Integer soldUnitsOctober) {
        this.soldUnitsOctober = soldUnitsOctober;
    }

    public Double getAmountOctober() {
        return amountOctober;
    }

    public void setAmountOctober(Double amountOctober) {
        this.amountOctober = amountOctober;
    }

    public Integer getSoldUnitsNovember() {
        return soldUnitsNovember;
    }

    public void setSoldUnitsNovember(Integer soldUnitsNovember) {
        this.soldUnitsNovember = soldUnitsNovember;
    }

    public Double getAmountNovember() {
        return amountNovember;
    }

    public void setAmountNovember(Double amountNovember) {
        this.amountNovember = amountNovember;
    }

    public Integer getSoldUnitsDecember() {
        return soldUnitsDecember;
    }

    public void setSoldUnitsDecember(Integer soldUnitsDecember) {
        this.soldUnitsDecember = soldUnitsDecember;
    }

    public Double getAmountDecember() {
        return amountDecember;
    }

    public void setAmountDecember(Double amountDecember) {
        this.amountDecember = amountDecember;
    }

    public Double calculateAmountTotal() {
        return (amountJanuary * soldUnitsJanuary)
            + (amountFebruary * soldUnitsFebruary)
            + (amountMarch * soldUnitsMarch)
            + (amountApril * soldUnitsApril)
            + (amountMay * soldUnitsMay)
            + (amountJune * soldUnitsJune)
            + (amountJuly * soldUnitsJuly)
            + (amountAugust * soldUnitsAugust)
            + (amountSeptember * soldUnitsSeptember)
            + (amountOctober * soldUnitsOctober)
            + (amountNovember * soldUnitsNovember)
            + (amountDecember * soldUnitsDecember);
    }

    public BookWireSheetModel getSheet() {
        return sheet;
    }

    public void setSheet(BookWireSheetModel sheet) {
        this.sheet = sheet;
    }
    //endregion
}
