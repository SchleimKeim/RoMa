package ch.zhaw.roma.model;

import javax.persistence.*;

@Entity
@Access(AccessType.FIELD)
public class BookModel {

    //region Private Fields
    @Id
    @Column(name = "BOOK_ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(name = "ISBN")
    private String isbnNumber;
    @Column(name = "BOOK_TITLE")
    private String title;

    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = AuthorModel.class)
    //private Set<AuthorModel> authors;
    //endregion

    //region Construction
    public BookModel() {

    }

    public BookModel(String isbnNumber, String title) {
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
    //endregion
}


