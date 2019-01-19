package ch.zhaw.roma.model.excel.persistence;

import javax.persistence.*;
import java.util.*;

@Entity
@Access(AccessType.FIELD)
public class BookWireSheetModel extends SheetModel {

    //region Private Fields
    @Id
    private Long id;


    @ElementCollection(targetClass = BookWireRowModel.class)
    private Collection<BookWireRowModel> rows = new HashSet<>();
    //endregion


    //region Construction
    public BookWireSheetModel() {

    }
    //endregion


    //region Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<BookWireRowModel> getRows() {
        return rows;
    }

    public void setRows(Collection<BookWireRowModel> rows) {
        this.rows = rows;
    }
    //endregion
}
