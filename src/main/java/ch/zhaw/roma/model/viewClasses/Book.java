package ch.zhaw.roma.model.viewClasses;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Book {


    private final IntegerProperty id;
    private final StringProperty ISBN;
    private final StringProperty title;
    private final ObjectProperty<Author> author;
    private final FloatProperty priceHardcoverEUR;
    private final FloatProperty priceHardcoverCHF;
    private final FloatProperty priceEbookEUR;
    private final FloatProperty royalityQuote;

    private ObservableList<Settlement> settlementOverview = FXCollections.observableArrayList();
    private ObservableList<SoldBooksYearly> soldBooksOverview = FXCollections.observableArrayList();

    public Book() {
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

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
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

    public Author getAuthor() {
        return author.get();
    }

    public ObjectProperty<Author> authorProperty() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author.set(author);
    }

    public float getPriceHardcoverEUR() {
        return priceHardcoverEUR.get();
    }

    public FloatProperty priceHardcoverEURProperty() {
        return priceHardcoverEUR;
    }

    public void setPriceHardcoverEUR(float priceHardcoverEUR) {
        this.priceHardcoverEUR.set(priceHardcoverEUR);
    }

    public float getPriceHardcoverCHF() {
        return priceHardcoverCHF.get();
    }

    public FloatProperty priceHardcoverCHFProperty() {
        return priceHardcoverCHF;
    }

    public void setPriceHardcoverCHF(float priceHardcoverCHF) {
        this.priceHardcoverCHF.set(priceHardcoverCHF);
    }

    public float getPriceEbookEUR() {
        return priceEbookEUR.get();
    }

    public FloatProperty priceEbookEURProperty() {
        return priceEbookEUR;
    }

    public void setPriceEbookEUR(float priceEbookEUR) {
        this.priceEbookEUR.set(priceEbookEUR);
    }

    public float getRoyalityQuote() {
        return royalityQuote.get();
    }

    public FloatProperty royalityQuoteProperty() {
        return royalityQuote;
    }

    public void setRoyalityQuote(float royalityQuote) {
        this.royalityQuote.set(royalityQuote);
    }






}
