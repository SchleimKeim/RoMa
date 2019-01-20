package ch.zhaw.roma.model.excel.persistence;

import ch.zhaw.roma.interfaces.IInhouseSheetModel;
import ch.zhaw.roma.model.excel.inhouse.InhouseSheet;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Access(AccessType.FIELD)
public class InhouseSheetModel implements IInhouseSheetModel {

    //region Private Fields
    @Id
    private Long id;

    @ElementCollection(targetClass = InhouseRowModel.class)
    private Collection<InhouseRowModel> rows = new HashSet<>();
    //endregion

    //region Construction
    public InhouseSheetModel() {

    }

    public InhouseSheetModel(InhouseSheet sheet, Collection<InhouseRowModel> rows) {


    }
    //endregion

    //region Setters and Getters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<InhouseRowModel> getRows() {
        return rows;
    }

    public void setRows(Collection<InhouseRowModel> rows) {
        this.rows = rows;
    }
    //endregion
}
