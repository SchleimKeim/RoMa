package ch.zhaw.roma.model.excel;

import ch.zhaw.roma.model.excel.bookwire.BookWireSheet;
import ch.zhaw.roma.model.excel.inhouse.InhouseSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.lang.reflect.Type;

public abstract class ExcelSheet {

    //region Fields
    protected Workbook _workbook;
    protected Type _type;
    //endregion

    //region Construction
    protected ExcelSheet(Workbook workbook, Type type)
    {
        _workbook = workbook;
        _type = type;
    }

    protected ExcelSheet(HSSFWorkbook hssfWorkbook) {
        this(hssfWorkbook, HSSFWorkbook.class);
    }

    protected ExcelSheet(XSSFWorkbook xssfWorkbook) {
        this(xssfWorkbook, XSSFWorkbook.class);
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
        return _type.getTypeName().contains("XSSF");
    }

    private boolean isBookWireSheet() {
        return _type.getTypeName().contains("HSSF");
    }
    //endregion
}
