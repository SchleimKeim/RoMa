package ch.zhaw.roma.model.excel.persistence;

import ch.zhaw.roma.model.excel.bookwire.BookWireRow;
import ch.zhaw.roma.model.excel.bookwire.BookWireSheet;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

@Entity
public class BookWireSheetModel extends SheetModel {

    //region Private Fields
    private Long id;
    @OneToMany(mappedBy = "sheet")
    private Set<BookWireRowModel> rows;
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

    public Set<BookWireRowModel> getRows() {
        return rows;
    }

    public void setRows(Set<BookWireRowModel> rows) {
        this.rows = rows;
    }
    //endregion


}
