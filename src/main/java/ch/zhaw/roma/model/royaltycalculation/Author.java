package ch.zhaw.roma.model.royaltycalculation;

import ch.zhaw.roma.model.form.Country;
import ch.zhaw.roma.model.form.Greeting;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Author {

    private IntegerProperty id = new SimpleIntegerProperty();

    private ObjectProperty<Greeting> greeting = new SimpleObjectProperty<>();
    private StringProperty firstName = new SimpleStringProperty();
    private StringProperty lastName = new SimpleStringProperty();
    private StringProperty street1 = new SimpleStringProperty();
    private StringProperty street2 = new SimpleStringProperty();
    private StringProperty street3 = new SimpleStringProperty();
    private IntegerProperty zipCode = new SimpleIntegerProperty();
    private StringProperty city = new SimpleStringProperty();
    private ObjectProperty<Country> country = new SimpleObjectProperty<>();
    private StringProperty countryISO = new SimpleStringProperty();
    private StringProperty website = new SimpleStringProperty();
    private StringProperty email = new SimpleStringProperty();
    private StringProperty phoneHome = new SimpleStringProperty();
    private StringProperty phoneWork = new SimpleStringProperty();
    private StringProperty phoneMobile = new SimpleStringProperty();

    private ObservableList<Book> books = FXCollections.observableArrayList();

    public Author() {
        Greeting greet = new Greeting("");
        greeting.setValue(greet);
        firstName.set("");
        lastName.set("");
        street1.set("");
        street2.set("");
        street3.set("");
        zipCode.set(0);
        city.set("");
        Country count = new Country("");
        country.setValue(count);
        website.set("");
        email.set("");
        phoneHome.set("");
        phoneMobile.set("");
        phoneWork.set("");



    }

    public ObservableList<Book> getBooks() {
        return books;
    }

    public void setBooks(ObservableList<Book> books) {
        this.books = books;
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

    public Greeting getGreeting() {
        return greeting.get();
    }

    public ObjectProperty greetingProperty() {
        return greeting;
    }

    public void setGreeting(Greeting greeting) {
        this.greeting.set(greeting);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getStreet1() {
        return street1.get();
    }

    public StringProperty street1Property() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1.set(street1);
    }

    public String getStreet2() {
        return street2.get();
    }

    public StringProperty street2Property() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2.set(street2);
    }

    public String getStreet3() {
        return street3.get();
    }

    public StringProperty street3Property() {
        return street3;
    }

    public void setStreet3(String street3) {
        this.street3.set(street3);
    }

    public int getZipCode() {
        return zipCode.get();
    }

    public IntegerProperty zipCodeProperty() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode.set(zipCode);
    }

    public String getCity() {
        return city.get();
    }

    public StringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public Country getCountry() {
        return country.get();
    }

    public ObjectProperty<Country> countryProperty() {
        return country;
    }

    public void setCountry(Country country) {
        this.country.set(country);
    }


    public String getCountryISO() {
        return countryISO.get();
    }

    public StringProperty countryISOProperty() {
        return countryISO;
    }

    public void setCountryISO(String countryISO) {
        this.countryISO.set(countryISO);
    }

    public String getWebsite() {
        return website.get();
    }

    public StringProperty websiteProperty() {
        return website;
    }

    public void setWebsite(String website) {
        this.website.set(website);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPhoneHome() {
        return phoneHome.get();
    }

    public StringProperty phoneHomeProperty() {
        return phoneHome;
    }

    public void setPhoneHome(String phoneHome) {
        this.phoneHome.set(phoneHome);
    }

    public String getPhoneWork() {
        return phoneWork.get();
    }

    public StringProperty phoneWorkProperty() {
        return phoneWork;
    }

    public void setPhoneWork(String phoneWork) {
        this.phoneWork.set(phoneWork);
    }

    public String getPhoneMobile() {
        return phoneMobile.get();
    }

    public StringProperty phoneMobileProperty() {
        return phoneMobile;
    }

    public void setPhoneMobile(String phoneMobile) {
        this.phoneMobile.set(phoneMobile);
    }

    public Author(int id, Greeting greeting, String firstName, String lastName, String street1, String street2, String street3, int zipCode, String city, Country country, String website, String email, String phoneHome, String phoneWork, String phoneMobile, ObservableList<Book> books) {

        this.id.set(id);

        this.greeting.setValue(greeting);
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.street1.set(street1);
        this.street2.set(street2);
        this.street3.set(street3);
        this.zipCode.set(zipCode);
        this.city.set(city);
        this.country.setValue(country);
        this.website.set(website);
        this.email.set(email);
        this.phoneHome.set(phoneHome);
        this.phoneWork.set(phoneWork);
        this.phoneMobile.set(phoneMobile);
        this.books = books;
    }

}
