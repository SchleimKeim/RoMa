package ch.zhaw.roma.model.excel.persistence;

import ch.zhaw.roma.helpers.ApplicationRepo;
import ch.zhaw.roma.model.excel.ExcelSheet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ExcelDbAdapter {

    //region Private Fields
    private static SessionFactory repository = new ApplicationRepo().getSessionFactory();
    //endregion

    //region Public Members

    /**
     * Returns weither or not the sheet was saved succesfully into
     * the database.
     *
     * @param sheet the ExcelSheet you want to save
     * @return boolean true if succesfull, otherwise false
     */
    public static boolean saveToDatabase(ExcelSheet sheet) {
        if (sheet.isBookWireSheet())
            return importBookWire(sheet);
        else if (sheet.isInhouseSheet())
            importInhouse(sheet);

        return false;
    }
    //endregion

    //region Private Helpers
    private static boolean importInhouse(ExcelSheet sheet) {
        InhouseSheetModel entity = InhouseSheetModel.createFrom(sheet.asInhouse());
        if (entity == null)
            return false;

        saveEntity(entity);

        return true;
    }

    private static boolean importBookWire(ExcelSheet sheet) {
        BookWireSheetModel entity = BookWireSheetModel.createFrom(sheet.asBookwire());
        if (entity == null)
            return false;

        saveEntity(entity);

        return true;
    }

    private static void saveEntity(SheetModel entity) {
        Session session = getSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }

    private static Session getSession() {
        return repository.isClosed()
                   ? repository.openSession()
                   : repository.getCurrentSession();
    }
    //endregion
}
