package ch.zhaw.roma.model.excel.persistence;

import ch.zhaw.roma.interfaces.IBookWireSheetModel;

import javax.persistence.*;
import java.util.Set;

@Entity
@Access(AccessType.FIELD)
@Table(name = "BOOKWIRE_SHEETS")
public class BookWireSheetModel implements IBookWireSheetModel {

    //region Private Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SHEET_ID", nullable = false)
    private Long sheetId;
    private String fileName = "";
//    private Date created = Calendar.getInstance().getTime();
//    private Date begin = Calendar.getInstance().getTime();      // TODO: !!
//    private Date end = Calendar.getInstance().getTime();        // TODO: !!


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sheet")
    private Set<BookWireRowModel> rows;
    //endregion


    //region Construction
    public BookWireSheetModel() {

    }

    public BookWireSheetModel(Set<BookWireRowModel> rows) {

        this.rows = rows;

        for(BookWireRowModel r : this.rows)
            r.setSheet(this);
    }
    //endregion


    //region Getters and Setters
    public Long getSheetId() {
        return sheetId;
    }

    public void setSheetId(Long sheetId) {
        this.sheetId = sheetId;
    }

    public Set<BookWireRowModel> getRows() {
        return rows;
    }

   public void setRows(Set<BookWireRowModel> rows) {
        this.rows = rows;
        for(BookWireRowModel r : this.rows)
            r.setSheet(this);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

//    public Date getCreated() {
//        return created;
//    }
//
//    public void setCreated(Date created) {
//        this.created = created;
//    }
//
//    public Date getBegin() {
//        return begin;
//    }
//
//    public void setBegin(Date begin) {
//        this.begin = begin;
//    }
//
//    public Date getEnd() {
//        return end;
//    }
//    public void setEnd(Date end) {
//        this.end = end;
//    }

    //endregion
}
