package ch.zhaw.roma.model.viewClasses;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GenericGenerator(name = "incrementBooks", strategy="increment")
    @GeneratedValue(generator = "incrementBooks")
    private int book_id;



    @ManyToOne
    @JoinColumn
    private Author author;

    @Column(name = "ISBN")
    private StringPropSerty ISBN;
    @Column(name = "title")
    private StringProperty title;
    @Column(name = "priceHardcoverEUR")
    private DoubleProperty priceHardcoverEUR;
    @Column(name = "priceHardcoverCHF")
    private DoubleProperty priceHardcoverCHF;
    @Column(name = "priceEbookEUR")
    private DoubleProperty priceEbookEUR;
    @Column(name = "royalityQuote")
    private DoubleProperty royalityQuote;

    //TODO: @OneToMany(mappedBy = "books", cascade = CascadeType.ALL)
    private ObservableList<Settlement> settlementOverview = FXCollections.observableArrayList();
    //TODO: @OneToMany(mappedBy = "books", cascade = CascadeType.ALL)
    private ObservableList<SoldBooksYearly> soldBooksOverview = FXCollections.observableArrayList();

    public Book() {
    }


    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }



    public ObservableList<Settlement> getSettlementOverview() {
        return settlementOverview;
    }

    public void setSettlementOverview(ObservableList<Settlement> settlementOverview) {
        this.settlementOverview = settlementOverview;
    }

    public void addSettlement(Settlement settlement) {
        settlementOverview.add(settlement);
    }

    public ObservableList<SoldBooksYearly> getSoldBooksOverview() {
        return soldBooksOverview;
    }

    public void setSoldBooksOverview(ObservableList<SoldBooksYearly> soldBooksOverview) {
        this.soldBooksOverview = soldBooksOverview;
    }

    public void addSoldBook(SoldBooksYearly soldBooksYearly) {
        soldBooksOverview.add(soldBooksYearly);
    }









    public String getISBN() {
        return ISBN.get();
    }

    public StringProperty ISBNProperty() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN.set(ISBN);
    }

    public int getBook_id() {
        return book_id.get();
    }

    public IntegerProperty book_idProperty() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id.set(book_id);
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public double getPriceHardcoverEUR() {
        return priceHardcoverEUR.get();
    }

    public DoubleProperty priceHardcoverEURProperty() {
        return priceHardcoverEUR;
    }

    public void setPriceHardcoverEUR(double priceHardcoverEUR) {
        this.priceHardcoverEUR.set(priceHardcoverEUR);
    }

    public double getPriceHardcoverCHF() {
        return priceHardcoverCHF.get();
    }

    public DoubleProperty priceHardcoverCHFProperty() {
        return priceHardcoverCHF;
    }

    public void setPriceHardcoverCHF(double priceHardcoverCHF) {
        this.priceHardcoverCHF.set(priceHardcoverCHF);
    }

    public double getPriceEbookEUR() {
        return priceEbookEUR.get();
    }

    public DoubleProperty priceEbookEURProperty() {
        return priceEbookEUR;
    }

    public void setPriceEbookEUR(double priceEbookEUR) {
        this.priceEbookEUR.set(priceEbookEUR);
    }

    public double getRoyalityQuote() {
        return royalityQuote.get();
    }

    public DoubleProperty royalityQuoteProperty() {
        return royalityQuote;
    }

    public void setRoyalityQuote(double royalityQuote) {
        this.royalityQuote.set(royalityQuote);
    }

}

