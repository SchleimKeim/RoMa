package ch.zhaw.roma.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Access(AccessType.FIELD)
@Table(name = "TESTBOOKS")
public class TestBookModel {

    //region Private Fields
    @Id
    @Column(name = "BOOK_ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(name = "ISBN")
    private String isbnNumber;
    @Column(name = "BOOK_TITLE")
    private String title;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "books")
    private Set<TestAuthorModel> authors;
    //endregion

    //region Construction
    public TestBookModel() {

    }

    public TestBookModel(String isbnNumber, String title) {
        this.isbnNumber = isbnNumber;
        this.title = title;
    }
    //endregion

    //region Getters and Setters
    public Long getBookId() {
        return bookId;
    }

    private void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public Set<TestAuthorModel> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<TestAuthorModel> authors) {
        this.authors = authors;
    }
    //endregion
}


