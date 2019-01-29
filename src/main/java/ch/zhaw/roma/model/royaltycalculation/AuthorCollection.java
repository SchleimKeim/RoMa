package ch.zhaw.roma.model.royaltycalculation;

import ch.zhaw.roma.model.royaltycalculation.Author;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Iterator;

public class AuthorCollection {


    private ObservableList<Author> authorList;

    //Constructor without input
    public AuthorCollection(){
        authorList = FXCollections.observableArrayList();
    }

    //Constructor with input
        public AuthorCollection(ArrayList<Author> list) {
        authorList = FXCollections.observableArrayList(list);
    }

    public ObservableList<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(ObservableList<Author> authorList) {
        this.authorList = authorList;
    }

    public void addAuthor(Author author) {
        authorList.add(author);
    }

    public void removeAuthor(Author author) {
        for (Iterator i = authorList.iterator(); i.hasNext();) {
            Author auth = (Author) i.next();
            if(auth.getId() == author.getId()) {

            }
        }
    }
}
