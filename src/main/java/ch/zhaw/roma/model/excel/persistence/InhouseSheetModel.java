package ch.zhaw.roma.model.excel.persistence;

import ch.zhaw.roma.interfaces.IInhouseSheetModel;
import ch.zhaw.roma.model.excel.inhouse.InhouseSheet;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class InhouseSheetModel extends SheetModel implements IInhouseSheetModel {

    private Long id;
    private InhouseRowModel[] rows;

    public InhouseSheetModel() {

    }

    public static InhouseSheetModel createFrom(InhouseSheet asInhouse) {
        return null;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Collection<InhouseRowModel> getRows() {
        return Arrays.asList(rows);
    }

    @Override
    public void setRows(Collection<InhouseRowModel> rows) {
        this.rows = (InhouseRowModel[]) rows.toArray();
    }
}
