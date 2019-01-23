package ch.zhaw.roma.controller;

import ch.zhaw.roma.model.royaltycalculation.Settlement;
import ch.zhaw.roma.model.royaltycalculation.SoldBooksYearly;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class EditRoMaNoteController {

    //Labels for book
    @FXML
    private Label ISBN;
    @FXML
    private Label title;
    @FXML
    private Label priceHardCoverEUR;
    @FXML
    private Label priceHardCoverCHF;
    @FXML
    private Label priceEbook;
    @FXML
    private Label royalityQote;

    //Table for overview of sold books
    @FXML
    private TableView<SoldBooksYearly> soldBooks;
    @FXML
    private TableColumn<SoldBooksYearly, Integer> yearColumnSB;
    @FXML
    private TableColumn<SoldBooksYearly, Integer> amountColumnSB;

    //Table for overview of past settlements
    @FXML
    private TableView<Settlement> settlementOverview;
    @FXML
    private TableColumn<Settlement, Integer> yearColumnSM;
    @FXML
    private TableColumn<Settlement, Float> amountColumnSM;

    @FXML
    private Label greeting;
    @FXML
    private Label firstName;
    @FXML
    private Label lastName;
    @FXML
    private Label street1;
    @FXML
    private Label street2;
    @FXML
    private Label zipCode;
    @FXML
    private Label city;
    @FXML
    private Label country;


    public EditRoMaNoteController() {

    }

    private void initialize() {

    }
}


