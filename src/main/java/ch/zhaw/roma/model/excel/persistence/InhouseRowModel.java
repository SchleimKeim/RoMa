package ch.zhaw.roma.model.excel.persistence;

import ch.zhaw.roma.model.BookModel;

import javax.persistence.*;

@Entity
@Access(AccessType.FIELD)
@Table(name = "INHOUSE_ROWS")
public class InhouseRowModel {

    //region Private Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROW_ID", nullable = false)
    private Long rowId;

    @ManyToOne
    @JoinColumn(name = "SHEET_ID", nullable = false)
    private InhouseSheetModel sheet;

    @Column(name = "ARTICLE_NR")
    private String articleNr;
    @Column(name = "ISBN_NUMBER")
    private String isbnNumber;
    @Column(name = "BOOK_TITLE")
    private String title;
    @Column(name = "AUTHOR_LASTNAME")
    private String authorLastName;
    @Column(name = "PROLIT_SALES")
    private Integer prolitSales;
    @Column(name = "AVA_SALES")
    private Integer avaSales;
    @Column(name = "PUBLISHER_SALES")
    private Integer publisherSales;
    @Column(name = "TOTAL_SALES")
    private Integer totalSales;
    @Column(name = "DISPOSITION")
    private Integer disposition;
    @Column(name = "LAST_YEAR_SALES")
    private Integer lastYearSales;
    @Column(name = "CUMULATED_SALES")
    private Integer cumulatedSales;
    @Column(name = "CUMULATED_DISPOSITION")
    private Integer cumulatedDisposition;
    @Column(name = "PROLIT_INVENTORY")
    private Integer prolitInventory;
    @Column(name = "AVA_INVENTORY")
    private Integer avaInventory;
    @Column(name = "AMAZON_INVENTORY")
    private Integer amazonInventory;
    @Column(name = "PUBLISHER_INVENTORY")
    private Integer publisherInventory;
    @Column(name = "TOTAL_INVENTORY")
    private Integer totalInventory;
    //endregion

    //region Construction
    public InhouseRowModel() {

    }
    //endregion

    //region Getters and Setters
    public Long getRowId() {
        return rowId;
    }

    public void setRowId(Long rowId) {
        this.rowId = rowId;
    }

    public InhouseSheetModel getSheet() {
        return sheet;
    }

    public void setSheet(InhouseSheetModel sheet) {
        this.sheet = sheet;
    }

    public String getArticleNr() {
        return articleNr;
    }

    public void setArticleNr(String articleNr) {
        this.articleNr = articleNr;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getProlitSales() {
        return prolitSales;
    }

    public void setProlitSales(Integer prolitSales) {
        this.prolitSales = prolitSales;
    }

    public Integer getAvaSales() {
        return avaSales;
    }

    public void setAvaSales(Integer avaSales) {
        this.avaSales = avaSales;
    }

    public Integer getPublisherSales() {
        return publisherSales;
    }

    public void setPublisherSales(Integer publisherSales) {
        this.publisherSales = publisherSales;
    }

    public Integer getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Integer totalSales) {
        this.totalSales = totalSales;
    }

    public Integer getDisposition() {
        return disposition;
    }

    public void setDisposition(Integer disposition) {
        this.disposition = disposition;
    }

    public Integer getLastYearSales() {
        return lastYearSales;
    }

    public void setLastYearSales(Integer lastYearSales) {
        this.lastYearSales = lastYearSales;
    }

    public Integer getCumulatedSales() {
        return cumulatedSales;
    }

    public void setCumulatedSales(Integer cumulatedSales) {
        this.cumulatedSales = cumulatedSales;
    }

    public Integer getCumulatedDisposition() {
        return cumulatedDisposition;
    }

    public void setCumulatedDisposition(Integer cumulatedDisposition) {
        this.cumulatedDisposition = cumulatedDisposition;
    }

    public Integer getProlitInventory() {
        return prolitInventory;
    }

    public void setProlitInventory(Integer prolitInventory) {
        this.prolitInventory = prolitInventory;
    }

    public Integer getAvaInventory() {
        return avaInventory;
    }

    public void setAvaInventory(Integer avaInventory) {
        this.avaInventory = avaInventory;
    }

    public Integer getAmazonInventory() {
        return amazonInventory;
    }

    public void setAmazonInventory(Integer amazonInventory) {
        this.amazonInventory = amazonInventory;
    }

    public Integer getPublisherInventory() {
        return publisherInventory;
    }

    public void setPublisherInventory(Integer publisherInventory) {
        this.publisherInventory = publisherInventory;
    }

    public Integer getTotalInventory() {
        return totalInventory;
    }

    public void setTotalInventory(Integer totalInventory) {
        this.totalInventory = totalInventory;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }
    //endregion

    //region Public Members
    public BookModel generateBookModel() {
        return new BookModel(getIsbnNumber(), getArticleNr(), getTitle(), getAuthorLastName());
    }
    //endregion
}
