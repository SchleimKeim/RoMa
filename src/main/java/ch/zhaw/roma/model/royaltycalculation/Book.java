package ch.zhaw.roma.model.royaltycalculation;

import javafx.beans.InvalidationListener;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;


public class Book {

    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty ISBN = new SimpleStringProperty();
    private StringProperty title = new SimpleStringProperty();
    private FloatProperty priceHardcoverEUR = new SimpleFloatProperty();
    private FloatProperty priceHardcoverCHF = new SimpleFloatProperty();
    private FloatProperty priceEbookEUR = new SimpleFloatProperty();
    private FloatProperty royalityQuote = new SimpleFloatProperty();



    private StringProperty authorsString = new SimpleStringProperty();

    private ObservableList<Author> authors = FXCollections.observableArrayList();
    private ObservableList<Settlement> settlementOverview = FXCollections.observableArrayList();
    private ObservableList<SoldBooksYearly> soldBooksOverview = FXCollections.observableArrayList();


    public Book() {
        authors.addListener(new ListChangeListener<Author>() {
            @Override
            public void onChanged(Change<? extends Author> c) {
                String tempString = new String();
                for(Author author : authors) {
                    tempString += author.getLastName() + ", " + author.getFirstName();
                    if (authors.size() > 1) {
                        tempString += "; ";
                    }
                }
            }
        });
    }

    public String getAuthorsString() {
        return authorsString.get();
    }

    public StringProperty authorsStringProperty() {
        return authorsString;
    }

    public void setAuthorsString(String authorsString) {
        this.authorsString.set(authorsString);
    }


    public void addSettlement(int year, float amount, Author author) {
        settlementOverview.add(new Settlement(year, amount, author));
    }

    public void removeSettlement(Settlement settlement) {
        settlementOverview.remove(settlement);
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void removeAuthor(Author author) {
        authors.remove(author);
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

    public ObservableList<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(ObservableList<Author> authors) {
        this.authors = authors;
    }






}
