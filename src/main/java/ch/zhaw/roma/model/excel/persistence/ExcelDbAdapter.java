package ch.zhaw.roma.model.excel.persistence;

import ch.zhaw.roma.helpers.ApplicationRepo;
import ch.zhaw.roma.model.excel.ExcelSheet;
import org.hibernate.Session;

public class ExcelDbAdapter {

    private static Session repository = new ApplicationRepo().getSessionFactory().openSession();

    /**
     * Returns weither or not the sheet was saved succesfully into
     * the database.
     *
     * @param  sheet  the ExcelSheet you want to save
     * @return boolean true if succesfull, otherwise false
     */
    public static boolean saveToDatabase(ExcelSheet sheet) {


        return false;
    }
}
