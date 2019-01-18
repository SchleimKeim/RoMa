package ch.zhaw.roma.model.viewClasses;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GenericGenerator(name = "incrementAuthor", strategy = "increment")
    @GeneratedValue(generator = "incrementAuthor")
    @Column(name = "author_id")
    private IntegerProperty author_id;

    @Column(name = "greeting")
    private StringProperty greeting;
    @Column(name = "firstName")
    private StringProperty firstName;
    @Column(name = "lastName")
    private StringProperty lastName;
    @Column(name = "street1")
    private StringProperty street1;
    @Column(name = "street2")
    private StringProperty street2;
    @Column(name = "street3")
    private StringProperty street3;
    @Column
    private IntegerProperty zipCode;
    @Column(name = "city")
    private StringProperty city;
    @Column(name = "country")
    private StringProperty country;
    @Column(name = "countryISO")
    private StringProperty countryISO;
    @Column(name = "website")
    private StringProperty website;
    @Column(name = "email")
    private StringProperty email;
    @Column(name = "phoneHome")
    private StringProperty phoneHome;
    @Column(name = "phoneWork")
    private StringProperty phoneWork;
    @Column(name = "phoneMobile")
    private StringProperty phoneMobile;



    @OneToMany(mappedBy = "authors", cascade = CascadeType.ALL)
    private List<Book> bookList = new ArrayList<>();

    private ObservableList<Book> books;

    public Author() {

    }

    //For Hibernate Test
    public List<Book> getBookList() {
        return bookList;
    }
    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
    public void addToBookList(Book book) {
        bookList.add(book);
    }



    public ObservableList<Book> getBooks() {
        return books;
    }

    public void setBooks(ObservableList<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
    }


    public int getAuthor_id() {
        return author_id.get();
    }

    public IntegerProperty author_idProperty() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id.set(author_id);
    }

    public String getGreeting() {
        return greeting.get();
    }

    public StringProperty greetingProperty() {
        return greeting;
    }

    public void setGreeting(String greeting) {
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

    public String getCountry() {
        return country.get();
    }

    public StringProperty countryProperty() {
        return country;
    }

    public void setCountry(String country) {
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



}
