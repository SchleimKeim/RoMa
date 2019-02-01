package ch.zhaw.roma.controller;

import ch.zhaw.roma.helpers.pdf.PdfExportData;
import ch.zhaw.roma.helpers.pdf.PdfExporter;
import ch.zhaw.roma.model.BookModel;
import ch.zhaw.roma.model.PersonModel;
import ch.zhaw.roma.model.royaltycalculation.AccountEntry;
import ch.zhaw.roma.model.royaltycalculation.AuxRight;
import ch.zhaw.roma.model.royaltycalculation.LegacyEntry;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CreateCalculationController implements Initializable {

    public Button closeButton;
    public ListView authorList;
    public ListView bookList;
    public Button importButton;

    //TODO: set date
    private String date = "01.02.2019";
    private String periodStart = "01.01.2018";
    private String periodEnd = "31.12.2018";

    private double mwstCh = 1.025;
    private double mwstDeAu = 1.07;
    private double mwstEbook = 1.07;

    private int soldCh = 82;
    private int soldDeAu = 263;
    private int soldEbooks = 61;

    private double eurChfRate = 1.11;

    private String path = "output/TestPDF.pdf";
    private SimpleBooleanProperty isImportButtonDisabled = new SimpleBooleanProperty(true);
    private PersonModel selectedPerson;
    private BookModel selectedBook;
    private StandardServiceRegistry serviceRegistry;
    private SessionFactory sessionFactory;
    private ArrayList<BookModel> bookModels = new ArrayList<>();
    private ArrayList<PersonModel> personModels = new ArrayList<>();
    private ObservableList<PersonModel> authors = FXCollections.observableArrayList(personModels);
    private ObservableList<BookModel> books = FXCollections.observableList(bookModels);

    public boolean getIsImportButtonDisabled() {
        return isImportButtonDisabled.get();
    }

    public void setIsImportButtonDisabled(boolean isImportButtonDisabled) {
        this.isImportButtonDisabled.set(isImportButtonDisabled);
    }

    public SimpleBooleanProperty isImportButtonDisabledProperty() {
        return isImportButtonDisabled;
    }

    public ObservableList<PersonModel> getAuthors() {
        return authors;
    }

    public void setAuthors(ObservableList<PersonModel> authors) {
        this.authors = authors;
    }

    public ObservableList<BookModel> getBooks() {
        return books;
    }

    public void setBooks(ObservableList<BookModel> books) {
        this.books = books;
    }

    private void initDb() {
        serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        sessionFactory = new MetadataSources(serviceRegistry)
                .buildMetadata()
                .buildSessionFactory();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initDb();
        setIsImportButtonDisabled(true);

        bookList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue != newValue) {
                if (newValue != null)
                    selectedBook = (BookModel) newValue;
            }
        });

        authorList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue != newValue) {
                if (newValue != null)
                    selectedPerson = (PersonModel) newValue;
            }
        });

        loadBooks();
        loadPeople();
    }

    private void loadPeople() {
        Session s = sessionFactory.openSession();
        s.beginTransaction();

        List<PersonModel> result = s.createQuery("FROM PersonModel").list();
        for (PersonModel p : result) {
            authors.add(p);
        }
    }

    private void loadBooks() {
        Session s = sessionFactory.openSession();
        s.beginTransaction();

        List<BookModel> result = s.createQuery("FROM BookModel").list();
        for (BookModel b : result) {
            books.add(b);
        }
    }

    public void onCreatePdf(ActionEvent actionEvent) {

        PdfExportData data = new PdfExportData();
        PersonModel person = selectedPerson;
        BookModel book = selectedBook;


        data.setPlaceAndDate(date);
        data.setGreeting(person.getGreeting());
        data.setFirstName(person.getFirstName());
        data.setLastName(person.getLastName());
        data.setStreet1(person.getStreet1());
        data.setZipCode(person.getZipCode());
        data.setCity(person.getCity());
        data.setCountry(person.getCountry());
        data.setISBN(book.getIsbnNumber());
        data.setTitle(book.getTitle());
        String fullname = person.getLastName() + ", " + person.getFirstName();
        data.setAuthor(fullname);

        data.setPriceHardCoverChf(book.getPriceCH().doubleValue());
        data.setPriceHardCoverChfExMwSt((book.getPriceCH().doubleValue() / mwstCh));
        data.setPriceHardCoverEur(book.getPriceDEandAT().doubleValue());
        data.setPriceHardCoverEurExMwSt(book.getPriceDEandAT().doubleValue() / mwstDeAu);
        data.setPriceEbookEur(book.getPriceEbook().doubleValue());
        data.setPriceEbookEurExMwSt(book.getPriceEbook().doubleValue() / mwstEbook);
        data.setPercentageNetRevEbook(25);
        data.setPeriodStart(periodStart);
        data.setPeriodEnd(periodEnd);
        LegacyEntry l1 = new LegacyEntry(2015, 51);
        LegacyEntry l2 = new LegacyEntry(2016, 221);
        LegacyEntry l3 = new LegacyEntry(2017, 174);
        ArrayList<LegacyEntry> legacy = new ArrayList<>();
        legacy.add(l1);
        legacy.add(l2);
        legacy.add(l3);
        data.setLegacyEntries(legacy);
        data.setSoldCh(soldCh);
        data.setSoldDeAu(soldDeAu);
        data.setSoldEbooks(soldEbooks);

        double honPerCopyCH = ((book.getPriceCH().doubleValue() / mwstCh) / 100) * book.getHonoraryHardcover();
        double honPerCopyDeAu = ((book.getPriceDEandAT().doubleValue() / mwstDeAu) / 100 * book.getHonoraryHardcover());
        double sumCH = soldCh * honPerCopyDeAu / eurChfRate;
        double sumDeAu = soldDeAu * honPerCopyDeAu;

        double sumEbook = (book.getHonoraryEbook() * (book.getPriceEbook().doubleValue() / mwstEbook)) * soldEbooks;

        data.setHonoraryRate(book.getHonoraryHardcover());
        data.setHonoraryPerCopyCH(honPerCopyCH);
        data.setHonoraryPerCopyDeAu(honPerCopyDeAu);
        data.setSumChChf(soldCh * honPerCopyCH);
        data.setSumChEur(sumCH);
        data.setSumDeAuEur(sumDeAu);
        data.setSumEbooksEur(soldEbooks * book.getPriceEbook().doubleValue());
        data.setNetRevEbooks(sumEbook);
        ArrayList<AuxRight> auxL = new ArrayList<>();
        AuxRight auxR = new AuxRight();
        auxR.setTitle("Keine");
        auxR.setAmountExMwSt(0.00);
        auxR.setHonoraryRate(0);
        auxR.setNetRevEur(0.00); //may not needed
        auxR.setSumEur(0.00);
        auxL.add(auxR);
        data.setAuxRights(auxL);

        double auxTotal = 0;
        for (AuxRight auxRe : auxL) {
            auxTotal += auxRe.getSumEur();
        }
        data.setAuxRightsTotal(auxTotal);

        //AccountEntry accountE = new AccountEntry("Remittendenrückstellung 15%", -424.21);
        ArrayList<AccountEntry> entries = new ArrayList<>();
        //entries.add(accountE);
        data.setEntries(entries);
        data.setRoyalityCalculationTotal(data.getSumChEur() + data.getSumDeAuEur() + data.getSumEbooksEur() + data.getAuxRightsTotal());

        double accountEntryTotal = 0;
        for (AccountEntry entry : entries) {
            accountEntryTotal += entry.getAmount();
        }
        data.setAccountTotal(accountEntryTotal + data.getRoyalityCalculationTotal());
        data.setContactDetails("Tel +41 44 444 44 44\nFax +41 44 999 99 99\nwww.mb-verlag.ch\nverlag@mb-verlag.ch");
        data.setExRateEurChf(eurChfRate);


        try {
            PdfExporter exporter = new PdfExporter(path, data);
            Desktop.getDesktop().open(new File(path));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean canSave() {

        return false;
    }

    public void onClose() {
        Stage stage = ((Stage) closeButton.getScene().getWindow());
        if (stage != null)
            stage.close();
    }
}
