package ch.zhaw.roma.model.excel;

import javafx.beans.property.SimpleObjectProperty;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelSheet {

    protected final HSSFWorkbook workbook;

    public ExcelSheet(HSSFWorkbook workbook) {

        this.workbook = workbook;
    }
}
