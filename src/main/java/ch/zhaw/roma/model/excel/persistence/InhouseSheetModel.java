package ch.zhaw.roma.model.excel.persistence;

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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sheet")
    private Set<InhouseRowModel> rows;
    //endregion

    //region Construction
    public InhouseSheetModel() {

    }

    public InhouseSheetModel(Set<InhouseRowModel> rows) {
        this.rows = rows;

        for(InhouseRowModel r : this.rows)
            r.setSheet(this);
    }
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
        if(rows == null)
            return;

        this.rows = rows;
        for(InhouseRowModel row : this.rows)
            row.setSheet(this);
    }

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
    //endregion
}
