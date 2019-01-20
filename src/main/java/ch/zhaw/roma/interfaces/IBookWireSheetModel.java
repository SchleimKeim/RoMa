package ch.zhaw.roma.interfaces;

import ch.zhaw.roma.model.excel.persistence.BookWireRowModel;

import java.util.Collection;

public interface IBookWireSheetModel {
    Collection<BookWireRowModel> getRows();
    void setRows(Collection<BookWireRowModel> rows);
}
