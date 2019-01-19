package ch.zhaw.roma.model.excel.persistence;

import ch.zhaw.roma.model.excel.inhouse.InhouseSheet;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class InhouseSheetModel extends SheetModel{

    //region Private Fields
    private Long id;
    private Set<InhouseRowModel> rows;
    //endregion

    //region Construction
    public InhouseSheetModel() {

    }
    //endregion

    //region Public Members
    public static InhouseSheetModel createFrom(InhouseSheet asInhouse) {
        return null;
    }
    //endregion

    //region Getters and Setters
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "sheet")
    public Set<InhouseRowModel> getRows() {
        return rows;
    }

    public void setRows(Set<InhouseRowModel> rows) {
        this.rows = rows;
    }
    //endregion
}
