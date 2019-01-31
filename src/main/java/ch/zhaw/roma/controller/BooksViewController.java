package ch.zhaw.roma.controller;

import ch.zhaw.roma.model.BookModel;
import ch.zhaw.roma.model.excel.persistence.BookWireRowModel;
import ch.zhaw.roma.model.excel.persistence.BookWireSheetModel;
import ch.zhaw.roma.model.excel.persistence.InhouseRowModel;
import ch.zhaw.roma.model.excel.persistence.InhouseSheetModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

public class BooksViewController implements Initializable {
    //region Private Fields
    private SessionFactory sessionFactory;
    private StandardServiceRegistry serviceRegistry;
    private ArrayList<BookModel> list = new ArrayList<>();
    private ObservableList<BookModel> books = FXCollections.observableList(list);
    private BookModel currentBook;
    //endregion

    //region Getters And Setters
    public ObservableList<BookModel> getBooks() {
        return books;
    }

    public void setBooks(ObservableList<BookModel> books) {
        this.books = books;
    }

    public BookModel getCurrentBook() {
        return currentBook;
    }

    public void setCurrentBook(BookModel currentBook) {
        this.currentBook = currentBook;
    }
    //endregion

    //region Construction
    //endregion

    //region Public Members
    public void setDbConnection(SessionFactory factory, StandardServiceRegistry registry) {
        if(sessionFactory == null)
            sessionFactory = factory;
        if(registry == null)
            serviceRegistry = registry;
    }
    //endregion



    //region Action Handler
    public void onImportBooks(ActionEvent actionEvent) {
        ImportBookWireSheets();
        ImportInhouseSheets();
    }
    //endregion


    //region Private Helpers
    private void initDb() {
        serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        sessionFactory = new MetadataSources(serviceRegistry)
                .buildMetadata()
                .buildSessionFactory();
    }

    private void ImportInhouseSheets() {
        Session s = sessionFactory.openSession();
        s.beginTransaction();
        List<InhouseSheetModel> sheets = s.createQuery("FROM InhouseSheetModel").list();
        for(InhouseSheetModel sheet : sheets) {
            for(InhouseRowModel row : sheet.getRows()) {
                BookModel book = row.generateBookModel();
                if(book != null)
                    books.add(book);
            }
        }
        sessionFactory.close();
    }

    private void ImportBookWireSheets() {
        Session s = sessionFactory.openSession();
        s.beginTransaction();
        List<BookWireSheetModel> sheets = s.createQuery("FROM BookWireSheetModel").list();
        for(BookWireSheetModel sheet : sheets) {
            Set<BookWireRowModel> rows = sheet.getRows();
            for(BookWireRowModel row : rows) {
                BookModel book = row.generateBookModel();
                if(book != null)
                    books.add(book);
            }
        }
        sessionFactory.close();
    }
    //endregion

    //region Overrides
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initDb();
    }
    //endregion
}
