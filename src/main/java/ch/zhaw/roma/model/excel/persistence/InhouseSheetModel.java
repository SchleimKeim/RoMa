package ch.zhaw.roma.model.excel.persistence;

import ch.zhaw.roma.model.BookModel;
import org.hibernate.Session;

import javax.persistence.*;
import java.util.Set;

@Entity
@Access(AccessType.FIELD)
@Table(name = "INHOUSE_SHEETS")
public class InhouseSheetModel {

    //region Private Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SHEET_ID", nullable = false)
    private Long sheetId;
    @Column(name = "FILE_NAME")
    private String fileName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sheet")
    private Set<InhouseRowModel> rows;
    //endregion

    //region Setters and Getters
    public Long getSheetId() {
        return sheetId;
    }

    public void setSheetId(Long sheetId) {
        this.sheetId = sheetId;
    }

    public Set<InhouseRowModel> getRows() {
        return rows;
    }

    public void setRows(Set<InhouseRowModel> rows) {
        if (rows == null)
            return;

        this.rows = rows;
        for (InhouseRowModel row : this.rows)
            row.setSheet(this);
    }
    //endregion

    //region Construction
    public InhouseSheetModel() {

    }

    public InhouseSheetModel(Set<InhouseRowModel> rows, String fileName) {
        this.rows = rows;
        this.fileName = fileName;
        for (InhouseRowModel r : this.rows)
            r.setSheet(this);
    }
    //endregion

    //region Public Members
    public boolean save(Session session) {
        try {
            session.beginTransaction();
            session.save(this);
            for (InhouseRowModel row : getRows())
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
