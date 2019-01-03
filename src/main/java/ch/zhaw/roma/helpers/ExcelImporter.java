package ch.zhaw.roma.helpers;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExcelImporter {

    //region Private Fields
    private Path file;
    //endregion

    //region Construction
    public ExcelImporter(String path) {

        if ((path == null) || path.isEmpty()) {
            throw new IllegalArgumentException("The argument \'path\' can't be empty!");
        }

        file = Paths.get(path);
        if (!file.toFile().isFile())
            throw new IllegalArgumentException("The argument \'path\' must be a valid file!");
    }
    //endregion

    //region Public Members
    public Object Import() {

        try (HSSFWorkbook workbook = new HSSFWorkbook(
            new POIFSFileSystem(
                new FileInputStream(file.toFile().getPath())))) {





        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }
    //endregion
}
