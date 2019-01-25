package ch.zhaw.roma.model.form;

import ch.zhaw.roma.helpers.AuthorCollection;
import ch.zhaw.roma.model.royaltycalculation.Author;
import ch.zhaw.roma.model.royaltycalculation.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CreateData {

    private AuthorCollection authorCollection;

    public CreateData() {
        authorCollection = new AuthorCollection();

        Greeting greeting1 = new Greeting("Frau");
        Country country1 = new Country("Schweiz");
        ObservableList<Book> list1 = FXCollections.observableArrayList();
        Book book1 = new Book();
        book1.setTitle("Test");
       // book1.setTitle("Der ganz normale GUI-Wahnsinn");
        list1.add(book1);
        Author author1 = new Author(1, greeting1, "Christa", "Chrom", "Kurzestrasse 9", "", "", 4111, "Hinterpfupfikon", country1, "chrom-books.ch", "christa@chrom.ch", "044555555", "06666666666", "077 251 81 56",list1);

        Greeting greeting2 = new Greeting("Herr");
        Country country2= new Country("Schweiz");
        ObservableList<Book> list2 = FXCollections.observableArrayList();
        Book book2 = new Book();
        book2.setTitle("Das grosse Taschenbuch");
        list2.add(book2);
        Author author2 = new Author(1, greeting2, "Hans", "Dampf", "Bahnhofstrasse 77", "", "", 8001, "Zürich", country2, "hansdampf.ch", "hans@dampf.ch", "044444444", "05555555", "079797979", list2);



        authorCollection.addAuthor(author1);
        authorCollection.addAuthor(author2);
    }

    public AuthorCollection getAuthorCollection() {
        return authorCollection;
    }


}
