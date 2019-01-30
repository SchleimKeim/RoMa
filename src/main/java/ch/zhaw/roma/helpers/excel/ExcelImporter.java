package ch.zhaw.roma.helpers.excel;

import ch.zhaw.roma.model.excel.ExcelSheet;
import ch.zhaw.roma.model.excel.ExcelSheetType;
import ch.zhaw.roma.model.excel.SheetType;
import ch.zhaw.roma.model.excel.bookwire.BookWireSheet;
import ch.zhaw.roma.model.excel.inhouse.InhouseSheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExcelImporter {

    //region Private Fields
    private File file;
    private ExcelSheetType type;
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
    public ExcelSheet importSheet() {
        switch (type.getType()) {
            case Bookwire:
                return loadBookwire();
            case Verlagsabrechnung:
                return loadInhouse();
            default:
                return null;
        }
    }
    //endregion


    //region Private Helpers

    private InhouseSheet loadInhouse() {
        try {
            return InhouseSheet.load(file.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private BookWireSheet loadBookwire() {
        try {
            return BookWireSheet.load(file.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    //endregion
}
