package ch.zhaw.roma.customcontrols;

import ch.zhaw.roma.model.BookModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class BooksView extends AnchorPane {

    //region Fields
    private List<BookModel> list = new ArrayList<>();
    private ObservableList<BookModel> books = FXCollections.observableList(list);
    //endregion

    //region Construction
    public BooksView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/BooksView.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    //endregion

    //region Getters And Setters
    public ObservableList<BookModel> getBooks() {
        return books;
    }

    public void setBooks(ObservableList<BookModel> value) {
        books = value;
    }
    //endregion
}
