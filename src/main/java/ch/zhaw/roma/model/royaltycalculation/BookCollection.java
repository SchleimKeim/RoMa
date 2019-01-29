package ch.zhaw.roma.model.royaltycalculation;

import javafx.beans.property.BooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Iterator;

public class BookCollection {


    private ObservableList<Author> bookList;

    //Constructor without input
    public BookCollection(){
        bookList = FXCollections.observableArrayList();
    }

    //Constructor with input
        public BookCollection(ArrayList<Author> list) {
        bookList = FXCollections.observableArrayList(list);
    }

    public ObservableList<Author> getBookList() {
        return bookList;
    }

    public void setBookList(ObservableList<Author> bookList) {
        this.bookList = bookList;
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public void removeAuthor(Book book) {
        for (Iterator i = bookList.iterator(); i.hasNext();) {
            Book b = (Book) i.next();
            if(b.getId() == b.getId()) {

            }
        }
    }
}
