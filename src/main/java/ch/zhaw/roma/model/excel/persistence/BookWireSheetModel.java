package ch.zhaw.roma.model.excel.persistence;

import org.hibernate.cfg.AccessType;

import javax.persistence.Access;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Access()
public class BookWireSheetModel extends SheetModel {

    //region Private Fields
    @Id
    private UUID id;
    @ElementCollection(targetClass = BookWireRowModel.class)
    private Set<BookWireRowModel> rows = new HashSet<>();
    //endregion


    //region Construction
    public BookWireSheetModel() {

    }
    //endregion


    //region Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Set<BookWireRowModel> getRows() {
        return rows;
    }

    public void setRows(Set<BookWireRowModel> rows) {
        this.rows = rows;
    }
    //endregion


}
