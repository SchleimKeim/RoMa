package ch.zhaw.roma.helpers.excel;

import ch.zhaw.roma.model.excel.ExcelSheet;
import ch.zhaw.roma.model.excel.ExcelSheetType;
import ch.zhaw.roma.model.excel.SheetType;
import ch.zhaw.roma.model.excel.bookwire.BookWireSheet;
import ch.zhaw.roma.model.excel.inhouse.InhouseSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExcelImporter {

    //region Private Fields
    private Path file;
    private ExcelSheetType type;
    private ExcelSheet sheet;
    //endregion

    //region Getters and Setters
    public Path getFile() {
        return file;
    }

    public ExcelSheetType getType() {
        return type;
    }
    //endregion


    //region Construction
    public ExcelImporter(String path, SheetType type) {

        if ((path == null) || path.isEmpty()) {
            throw new IllegalArgumentException("The argument \'path\' can't be empty!");
        }

        file = Paths.get(path);
        if (!file.toFile().isFile())
            throw new IllegalArgumentException("The argument \'path\' must be a valid file!");

        this.type = new ExcelSheetType(type);
    }
    //endregion

    //region Public Members
    public ExcelSheet Import() {
        switch (type.getType()) {
            case Bookwire:
                return LoadBookwire();
            case Verlagsabrechnung:
                return LoadInhouse();
            default:
                return null;
        }
    }
    //endregion


    //region Private Helpers
    private InhouseSheet LoadInhouse() {
        return InhouseSheet.Load(getWorkbook());
    }

    private XSSFWorkbook getWorkbook() {
        try {
            return new XSSFWorkbook(new java.io.File(String.valueOf(file.toAbsolutePath())));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    private BookWireSheet LoadBookwire() {
        HSSFWorkbook workbook = null;
        return new BookWireSheet(workbook);
    }
    //endregion
}
