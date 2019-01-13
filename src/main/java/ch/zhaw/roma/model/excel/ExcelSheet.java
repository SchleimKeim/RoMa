package ch.zhaw.roma.model.excel;

import ch.zhaw.roma.model.excel.bookwire.BookWireSheet;
import ch.zhaw.roma.model.excel.inhouse.InhouseSheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.lang.reflect.Type;

public abstract class ExcelSheet {

    //region Fields
    protected Workbook _workbook;
    protected Type _type;
    //endregion

    //region Construction
    public ExcelSheet(Workbook workbook, Type type)
    {
        _workbook = workbook;
        _type = type;
    }
    //endregion

    //region Abstracts
    abstract public int getRowCount();
    //endregion

    //region Public Members
    public BookWireSheet asBookwire() {
        return (isBookWireSheet())
            ? (BookWireSheet)this
            : null;
    }

    public InhouseSheet asInhouse() {
        return (isInhouseSheet())
            ? (InhouseSheet)this
            : null;
    }
    //endregion


    //region Private Helpers
    private boolean isInhouseSheet() {
        return (_type.getTypeName() == InhouseSheet.class.getTypeName());
    }

    private boolean isBookWireSheet() {
        return (_type.getTypeName() == BookWireSheet.class.getTypeName());
    }
    //endregion
}
