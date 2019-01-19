package ch.zhaw.roma.model.excel.persistence;

import ch.zhaw.roma.model.excel.bookwire.BookWireSheet;

public class BookWireSheetModel extends SheetModel{

    //region Private Fields
    private Long id;
    private BookWireRowModel[] rows;
    //endregion


    //region Construction
    public BookWireSheetModel() {

    }

    public static BookWireSheetModel createFrom(BookWireSheet asBookwire) {
        return null;
    }
    //endregion
}
