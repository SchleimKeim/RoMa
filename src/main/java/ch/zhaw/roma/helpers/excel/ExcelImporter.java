package ch.zhaw.roma.helpers.excel;

import ch.zhaw.roma.model.excel.ExcelSheet;
import ch.zhaw.roma.model.excel.ExcelSheetType;
import ch.zhaw.roma.model.excel.SheetType;
import ch.zhaw.roma.model.excel.bookwire.BookWireSheet;
import ch.zhaw.roma.model.excel.inhouse.InhouseSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

class ExcelImporter {

    //region Private Fields
    private File file;
    private ExcelSheetType type;
    private ExcelSheet sheet;
    //endregion

    //region Getters and Setters
    public Path getFile() {
        return file.toPath();
    }

    public ExcelSheetType getType() {
        return type;
    }
    //endregion


    //region Construction
    public ExcelImporter(String path, SheetType type) {

        if ((path == null) || path.isEmpty())
            throw new IllegalArgumentException("The argument \'path\' can't be empty!");

        file = Paths.get(path).toFile();
        if(file.exists() || file.exists())
            this.type = new ExcelSheetType(type);
        else
            throw new IllegalArgumentException("The argument \'path\' must be a valid file!");
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
    private XSSFWorkbook getWorkbook() {
        try {
            return new XSSFWorkbook(new java.io.File(file.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    private InhouseSheet LoadInhouse() {
        return InhouseSheet.Load(getWorkbook());
    }

    private BookWireSheet LoadBookwire() {
        return new BookWireSheet(new HSSFWorkbook());
    }
    //endregion
}
