package ch.zhaw.roma.controller;

import ch.zhaw.roma.model.BookModel;
import ch.zhaw.roma.model.excel.persistence.BookWireRowModel;
import ch.zhaw.roma.model.excel.persistence.BookWireSheetModel;
import ch.zhaw.roma.model.excel.persistence.InhouseRowModel;
import ch.zhaw.roma.model.excel.persistence.InhouseSheetModel;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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

    //region Public Fields
    public ListView bookList;
    public TextField priceCHtext;
    public TextField priceGerAndAuText;
    public TextField priceEbookText;
    public TextField honoraryHardcoverText;
    public TextField honoraryEbookText;
    //endregion

    //region Private Fields
    private SimpleObjectProperty<BookModel> currentBook;
    private SessionFactory sessionFactory;
    private StandardServiceRegistry serviceRegistry;
    private ArrayList<BookModel> list = new ArrayList<>();
    private ObservableList<BookModel> books = FXCollections.observableList(list);
    //endregion

    //region Getters And Setters

    public ObservableList<BookModel> getBooks() {
        return books;
    }

    public void setBooks(ObservableList<BookModel> books) {
        this.books = books;
    }

    public BookModel getCurrentBook() {
        BookModel book = (currentBook != null) ? currentBook.get() : null;
        return (book == null)
                ? BookModel.empty()
                : book;
    }

    public void setCurrentBook(BookModel currentBook) {
        this.currentBook.set(currentBook);
    }

    public SimpleObjectProperty<BookModel> currentBookProperty() {
        return currentBook;
    }
    //endregion

    //region Action Handler
    public void onSaveCurrent(ActionEvent actionEvent) {

    }

    public void onSaveAll(ActionEvent actionEvent) {

    }

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
        for (InhouseSheetModel sheet : sheets) {
            for (InhouseRowModel row : sheet.getRows()) {
                BookModel book = row.generateBookModel();
                if (book != null)
                    books.add(book);
            }
        }
    }

    private void ImportBookWireSheets() {
        Session s = sessionFactory.openSession();
        s.beginTransaction();
        List<BookWireSheetModel> sheets = s.createQuery("FROM BookWireSheetModel").list();
        for (BookWireSheetModel sheet : sheets) {
            Set<BookWireRowModel> rows = sheet.getRows();
            for (BookWireRowModel row : rows) {
                BookModel book = row.generateBookModel();
                if (book != null)
                    books.add(book);
            }
        }
    }

    private void updateControls(BookModel newValue) {
        priceCHtext.setText(newValue.getPriceCH().toString());
        priceGerAndAuText.setText(newValue.getPriceDEandAT().toString());
        priceEbookText.setText(newValue.getPriceEbook().toString());
        honoraryHardcoverText.setText(newValue.getHonoraryHardcover().toString());
        honoraryEbookText.setText(newValue.getHonoraryEbook().toString());
    }
    //endregion

    //region Overrides
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initDb();
        bookList.getSelectionModel().selectedItemProperty().addListener((ChangeListener<BookModel>) (observable, oldValue, newValue) -> {
            if (oldValue != newValue) {
                setCurrentBook(newValue);
                updateControls(newValue);
            }
        });
    }
    //endregion
}
