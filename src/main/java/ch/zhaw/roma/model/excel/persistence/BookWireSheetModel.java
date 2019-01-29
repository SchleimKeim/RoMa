package ch.zhaw.roma.model.excel.persistence;

import org.hibernate.Session;

import javax.persistence.*;
import java.util.Set;

@Entity
@Access(AccessType.FIELD)
@Table(name = "BOOKWIRE_SHEETS")
public class BookWireSheetModel {

    //region Private Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SHEET_ID", nullable = false)
    private Long sheetId;
    private String fileName = "";

//    @Temporal(TemporalType.DATE)
//    private Date created;
//    @Temporal(TemporalType.DATE)
//    private Date begin;
//    @Temporal(TemporalType.DATE)
//    private Date end;


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

    public boolean save(Session session) {
         try {
            session.beginTransaction();
            session.save(this);
            for (BookWireRowModel row : getRows())
                session.save(row);

            session.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            return false;
        }
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
