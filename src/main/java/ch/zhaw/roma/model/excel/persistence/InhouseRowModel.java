package ch.zhaw.roma.model.excel.persistence;

import ch.zhaw.roma.interfaces.IInhouseRowModel;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Access(AccessType.FIELD)
public class InhouseRowModel implements IInhouseRowModel {
    //region Private Fields
    @Id
    private Long id;
    private InhouseSheetModel sheet;
    private String articleNr;
    private String title;
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
    //endregion

    //region Construction
    public InhouseRowModel() {

    }
    //endregion

    //region Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    //endregion
}
