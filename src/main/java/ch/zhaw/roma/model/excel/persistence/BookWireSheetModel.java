package ch.zhaw.roma.model.excel.persistence;

import ch.zhaw.roma.interfaces.IBookWireSheetModel;

import javax.persistence.*;
import java.time.Instant;
import java.util.*;

@Entity
@Access(AccessType.FIELD)
public class BookWireSheetModel implements IBookWireSheetModel {

    //region Private Fields
    @Id
    @Column(name = "SHEET_ID")
    private Long id;
    private String fileName;
    private Date created = new Date();
    private Date begin;
    private Date end;

    @OneToMany(mappedBy = "sheet")
    private Collection<BookWireRowModel> rows = new HashSet<>();
    //endregion


    //region Construction
    public BookWireSheetModel() {

    }

    public BookWireSheetModel(List<BookWireRowModel> rows) {
        this.rows = rows;
    }
    //endregion


    //region Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<BookWireRowModel> getRows() {
        return rows;
    }

    public void setRows(Collection<BookWireRowModel> rows) {
        this.rows = rows;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }
    public void setEnd(Date end) {
        this.end = end;
    }

    //endregion
}
