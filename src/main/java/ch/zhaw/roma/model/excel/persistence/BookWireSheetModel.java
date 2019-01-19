package ch.zhaw.roma.model.excel.persistence;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class BookWireSheetModel extends SheetModel {

    //region Private Fields
    private Long id;
    @OneToMany(mappedBy = "sheet")
    private List<BookWireRowModel> rows;
    //endregion


    //region Construction
    public BookWireSheetModel() {

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

    public List<BookWireRowModel> getRows() {
        return rows;
    }

    public void setRows(List<BookWireRowModel> rows) {
        this.rows = rows;
    }
    //endregion


}