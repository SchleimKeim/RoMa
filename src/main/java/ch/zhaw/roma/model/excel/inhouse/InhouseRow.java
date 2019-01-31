package ch.zhaw.roma.model.excel.inhouse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;



public class InhouseRow {

    //region Private Fields
    private String articleNr;
    private String title;
    private String author;
    private Integer prolitSales;
    private Integer avaSales;
    private Integer publisherSales;
    private Integer totalSales;
    private Integer disposition;
    private Integer lastYearSales;
    private Integer cumulatedSales;
    private Integer cumulatedDisposition;
    private Integer prolitInventory;
    private Integer avaInventory;
    private Integer amazonInventory;
    private Integer publisherInventory;
    private Integer totalInventory;
    private String authorAndTitle;
    //endregion

    //region Construction
    public InhouseRow(Row row) {
        if (row == null)
            return;

        articleNr = toString(row.getCell(RowIndexes.ARTICLENR));
        author = extractAuthor(loadAuthorAndTitle(row));
        title = extractTitle(loadAuthorAndTitle(row));
        prolitSales = toInt(row.getCell(RowIndexes.PROLITSALES));
        avaSales = toInt(row.getCell(RowIndexes.AVASALES));
        publisherSales = toInt(row.getCell(RowIndexes.PUBLISHERSALES));
        totalSales = toInt(row.getCell(RowIndexes.TOTALSALES));
        disposition = toInt(row.getCell(RowIndexes.DISPOSITION));
        lastYearSales = toInt(row.getCell(RowIndexes.LASTYEARSALES));
        cumulatedSales = toInt(row.getCell(RowIndexes.CUMULATEDSALES));
        cumulatedDisposition = toInt(row.getCell(RowIndexes.CUMULATEDDISPOSITION));
        prolitInventory = toInt(row.getCell(RowIndexes.PROLITINVENTORY));
        avaInventory = toInt(row.getCell(RowIndexes.AVAINVENTORY));
        amazonInventory = toInt(row.getCell(RowIndexes.AMAZONINVENTORY));
        publisherInventory = toInt(row.getCell(RowIndexes.PUBLISHERINVENTORY));
        totalInventory = toInt(row.getCell(RowIndexes.TOTALINVENTORY));
    }
    //endregion

    //region Getters And Setters
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
    //endregion

    //region Private Helpers
    private String loadAuthorAndTitle(Row row) {
        if (authorAndTitle == null) {
            Cell cell = row.getCell(RowIndexes.AUTHOR_AND_TITLE);
            authorAndTitle = toString(cell);
        }
        return authorAndTitle;
    }

    private String extractTitle(String authorAndTitle) {
        if (authorAndTitle == null)
            return "";
        else if (!authorAndTitle.contains(","))
            return authorAndTitle;

        String bookTitle = authorAndTitle.split(",")[1];
        if (bookTitle.endsWith("*"))
            return bookTitle.substring(0, (bookTitle.length() - 1));

        return bookTitle;
    }

    private String extractAuthor(String authorAndTitle) {
        if (authorAndTitle == null)
            return "";
        else if (!authorAndTitle.contains(","))
            return authorAndTitle;

        return authorAndTitle.split(",")[0];
    }

    private String toString(Cell cell) {
        if (cell != null)
            return cell.getStringCellValue();
        else
            return "";
    }

    private Integer toInt(Cell cell) {
        return (cell != null) && (cell.getCellType() == CellType.NUMERIC)
                ? ((Double) cell.getNumericCellValue()).intValue()
                : 0;
    }
    //endregion

    //region Public Members
    public boolean isEmpty() {
        if ((author == null || author.isEmpty())
                || (title == null || title.isEmpty())
                || (articleNr == null || articleNr.isEmpty())
        )
            return true;

        return false;
    }
    //endregion
}
