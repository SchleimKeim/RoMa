package ch.zhaw.roma.model;

import org.hibernate.Session;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Access(AccessType.FIELD)
@Table(name = "BOOKS")
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

    @Column(name = "PRICE_CH")
    private BigDecimal priceCH;
    @Column(name = "PRICE_DE_AT")
    private BigDecimal priceDEandAT;
    @Column(name = "PRICE_EBOOK")
    private BigDecimal priceEbook;
    @Column(name = "HONORARY_HARDCOVER_PERCENTAGE")
    private Double honoraryHardcover;
    @Column(name = "HONORARY_EBOOK_PERCENTAGE")
    private Double honoraryEbook;


    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "books")
    private Set<PersonModel> persons;
    //endregion

    //region Public Fields
    //endregion

    //region Getters And Setters
    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<PersonModel> getPersons() {
        return persons;
    }

    public void setPersons(Set<PersonModel> persons) {
        this.persons = persons;
    }

    public BigDecimal getPriceCH() {
        return priceCH;
    }

    public void setPriceCH(BigDecimal priceCH) {
        this.priceCH = priceCH;
    }

    public BigDecimal getPriceDEandAT() {
        return priceDEandAT;
    }

    public void setPriceDEandAT(BigDecimal priceDEandAT) {
        this.priceDEandAT = priceDEandAT;
    }

    public BigDecimal getPriceEbook() {
        return priceEbook;
    }

    public void setPriceEbook(BigDecimal priceEbook) {
        this.priceEbook = priceEbook;
    }

    public Double getHonoraryHardcover() {
        return honoraryHardcover;
    }

    public void setHonoraryHardcover(Double honoraryHardcover) {
        this.honoraryHardcover = honoraryHardcover;
    }

    public Double getHonoraryEbook() {
        return honoraryEbook;
    }

    public void setHonoraryEbook(Double honoraryEbook) {
        this.honoraryEbook = honoraryEbook;
    }
    //endregion

    //region Construction
    public BookModel() {
    }
    //endregion

    //region Public Members
    public boolean save(Session session) {
        if(session == null)
            return false;
        try {
            session.beginTransaction();
            session.save(this);
            session.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    //endregion

    //region Private Helpers
    //endregion

    //region Overrides
    //endregion
}
