package ch.zhaw.roma.helpers.excel;

import ch.zhaw.roma.model.excel.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

        try (HSSFWorkbook workbook = new HSSFWorkbook(
            new POIFSFileSystem(
                new FileInputStream(file.toFile().getPath())))) {
            switch (type.getType()) {
                case Bookwire: return LoadBookwire(workbook);
                case Verlagsabrechnung: return LoadInhouse(workbook);
                default: return null;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private InhouseSheet LoadInhouse(HSSFWorkbook workbook) {
        return new InhouseSheet(workbook);
    }

    private BookWireSheet LoadBookwire(HSSFWorkbook workbook) {
        return new BookWireSheet(workbook);
    }
    //endregion
}
