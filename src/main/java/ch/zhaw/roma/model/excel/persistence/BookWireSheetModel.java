package ch.zhaw.roma.model.excel.persistence;

import ch.zhaw.roma.interfaces.IBookWireRowModel;
import ch.zhaw.roma.interfaces.IBookWireSheetModel;
import ch.zhaw.roma.model.excel.bookwire.BookWireSheet;

import javax.persistence.*;
import java.util.*;

@Entity
@Access(AccessType.FIELD)
@Table(name = "BOOK_WIRE_SHEETS")
public class BookWireSheetModel implements IBookWireSheetModel {

    //region Private Fields
    @Id
    private Long id;


    @ElementCollection(targetClass = BookWireRowModel.class)
    private Collection<BookWireRowModel> rows = new HashSet<>();
    //endregion


    //region Construction
    public BookWireSheetModel() {

    }

    public BookWireSheetModel(BookWireSheet bookWireSheet, List<BookWireRowModel> rows) {
        this.rows = rows;
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
