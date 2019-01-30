package ch.zhaw.roma.model.excel;

import ch.zhaw.roma.model.excel.bookwire.BookWireSheet;
import ch.zhaw.roma.model.excel.inhouse.InhouseSheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.lang.reflect.Type;

public abstract class ExcelSheet {

    //region Fields
    protected Workbook workbook;
    protected Type type;
    private String fileName;
    //endregion

    //region Construction
    public ExcelSheet(Workbook workbook, Type type, String fileName)
    {
        this.workbook = workbook;
        this.type = type;
        this.fileName = fileName;
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

    public boolean isInhouseSheet() {
        return (type.getTypeName() == InhouseSheet.class.getTypeName());
    }

    public boolean isBookWireSheet() {
        return (type.getTypeName() == BookWireSheet.class.getTypeName());
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String _fileName) {
        this.fileName = _fileName;
    }
    //endregion
}
