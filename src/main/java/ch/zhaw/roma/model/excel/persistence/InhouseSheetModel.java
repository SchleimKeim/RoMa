package ch.zhaw.roma.model.excel.persistence;

import ch.zhaw.roma.interfaces.IInhouseSheetModel;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;
import java.util.UUID;

//@Entity
public class InhouseSheetModel extends SheetModel implements IInhouseSheetModel {

    //region Private Fields
//    @Id
    private UUID id;

//    @ElementCollection(targetClass = InhouseRowModel.class)
    private List<InhouseRowModel> rows;
    //endregion

    //region Construction
    public InhouseSheetModel() {

    }
    //endregion

    //region Setters and Getters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public List<InhouseRowModel> getRows() {
        return rows;
    }

    @Override
    public void setRows(List<InhouseRowModel> rows) {
        this.rows = rows;
    }
    //endregion
}
