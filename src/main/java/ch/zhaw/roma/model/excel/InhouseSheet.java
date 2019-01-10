package ch.zhaw.roma.model.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class InhouseSheet extends ExcelSheet{

    private InhouseSheet(HSSFWorkbook workbook) {
        super();
    }

    public static InhouseSheet Load(HSSFWorkbook workbook) {
        return new InhouseSheet(workbook);
    }
}
