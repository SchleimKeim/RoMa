package ch.zhaw.roma.model.excel.persistence;

import ch.zhaw.roma.model.BookModel;
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
    @Column(name = "FILE_NAME")
    private String fileName;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sheet")
    private Set<BookWireRowModel> rows;
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
        for (BookWireRowModel r : this.rows)
            r.setSheet(this);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    //endregion

    //region Construction
    public BookWireSheetModel() {

    }

    public BookWireSheetModel(Set<BookWireRowModel> rows, String fileName) {
        this.fileName = fileName;
        this.rows = rows;

        for (BookWireRowModel r : this.rows)
            r.setSheet(this);
    }
    //endregion

    //region Public Members
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

    public BookModel[] getBooks() {
        return rows.stream().map(r -> r.generateBookModel()).toArray(BookModel[]::new);
    }
    //endregion
}
