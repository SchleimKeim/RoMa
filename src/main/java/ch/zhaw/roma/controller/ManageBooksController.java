package ch.zhaw.roma.controller;

import ch.zhaw.roma.Main;
import ch.zhaw.roma.helpers.pdf.PdfExportData;
import ch.zhaw.roma.model.royaltycalculation.Author;
import ch.zhaw.roma.model.royaltycalculation.Book;
import ch.zhaw.roma.model.royaltycalculation.Settlement;
import ch.zhaw.roma.model.royaltycalculation.SoldBooksYearly;

import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageBooksController {

    @FXML
    private TableView<Book> bookTable;
    @FXML
    private TableColumn<Book, String> titleColumn;
    @FXML
    private TableColumn<Book, String> authorColumn;
    @FXML
    private TableColumn<Book, String> ISBNColumn;

    @FXML
    private TableView<SoldBooksYearly> soldTable;
    @FXML
    private TableColumn<SoldBooksYearly, Integer> soldYearColumn;
    @FXML
    private TableColumn<SoldBooksYearly, Integer> soldChColumn;
    @FXML
    private TableColumn<SoldBooksYearly, Integer> soldDeAuColumn;
    @FXML
    private TableColumn<SoldBooksYearly, Integer> soldEbookColumn;

    @FXML
    private TableView<Settlement> settlementsTable;
    @FXML
    private TableColumn<Settlement, Integer> settlementYearColumn;
    @FXML
    private TableColumn<Settlement, Float> settlementAmountColumn;

    @FXML
    private TableView<Author> authors;
    @FXML
    private TableColumn<Author, String> firstNameColumn;
    @FXML
    private TableColumn<Author, String>  lastNameColumn;


    @FXML
    private Label priceHardChfLabel;
    @FXML
    private Label priceHardEurLabel;
    @FXML
    private Label priceEbookEurLabel;
    @FXML
    private Label ISBNLabel;
    @FXML
    private Label titleLabel;
    @FXML
    private Label royalityQuoteLabel;

    private Main main;
    private

    @FXML
    private void initialize() {
        //initialization of the author table with two columns.
        titleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        authorColumn.setCellValueFactory((cellData -> {
            String fullName = (StringProperty) cellData.getValue().getAuthorsString();
            StringProperty authorFullName = new SimpleStringProperty(fullName);
            return authorFullName;
        }));
        ISBNColumn.setCellValueFactory((cellData -> cellData.getValue().ISBNProperty()));
        bookTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showBookDetails(newValue));
    }

    public void showBookDetails(Book book) {

        titleLabel.setText(book.getTitle());
        authorLabel.setText((book.getAuthor().getLastName() + "," +book.getAuthor().getFirstName()));
        ISBNLabel.setText(book.getISBN());
        priceEbookEurLabel.setText(Float.toString(book.getPriceEbookEUR()));
        priceHardChfLabel.setText(Float.toString(book.getPriceHardcoverCHF()));
        priceHardEurLabel.setText(Float.toString(book.getPriceHardcoverEUR()));
        royalityQuoteLabel.setText(Float.toString(book.getRoyalityQuote()));

        soldTable.setItems(book.getSoldBooksOverview());
        settlementsTable.setItems(book.getSettlementOverview());

        soldChColumn.setCellValueFactory(cellData -> cellData.getValue().amountCHProperty().asObject());
        soldDeAuColumn.setCellValueFactory(cellData -> cellData.getValue().amountDEAUProperty().asObject());
        soldEbookColumn.setCellValueFactory(cellData -> cellData.getValue().amountEbooksProperty().asObject());

        settlementYearColumn.setCellValueFactory(cellData -> cellData.getValue().yearProperty().asObject());
        settlementAmountColumn.setCellValueFactory(cellData -> cellData.getValue().amountProperty().asObject());
    }

    @FXML
    public void editSales() {
    }

    @FXML
    public void editSettlements() {
    }



    @FXML
    public void handleEdit() {
    }

    @FXML
    public void handleDelete() {
    }

    //access to main and the books-list
    public void setMain(Main main){
        this.main = main;
        bookTable.setItems(main.getBooks());
    }


    public void setTables(Author author) {
        bookTable.setItems(author.getBooks());
    }

    @FXML
    public void PrintHonoraryNote() {
        PdfExportData data = new PdfExportData();

    }





}
