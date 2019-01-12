package ch.zhaw.roma.model.excel;

import ch.zhaw.roma.model.excel.bookwire.BookWireSheet;
import ch.zhaw.roma.model.excel.inhouse.InhouseSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheet {

    protected final HSSFWorkbook hssfWorkbook;
    protected final XSSFWorkbook xssfWorkbook;

    public ExcelSheet(XSSFWorkbook xssfWorkbook) {

        this.hssfWorkbook = null;
        this.xssfWorkbook = xssfWorkbook;
    }

    public ExcelSheet(HSSFWorkbook hssfWorkbook) {
        this.hssfWorkbook = hssfWorkbook;
        this.xssfWorkbook = null;
    }

    public BookWireSheet asBookwire() {
        return (this.getClass().getTypeName() == BookWireSheet.class.getTypeName())
                ?(BookWireSheet)this
                : null;
    }
    public InhouseSheet asInhouse() {
        return (this.getClass().getTypeName() == InhouseSheet.class.getTypeName())
                ? (InhouseSheet)this
                : null;
    }
}
