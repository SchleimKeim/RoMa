package ch.zhaw.roma.interfaces;

import ch.zhaw.roma.model.excel.persistence.BookWireRowModel;

import java.util.Set;

public interface IBookWireSheetModel {
    Set<BookWireRowModel> getRows();
    void setRows(Set<BookWireRowModel> rows);
}
