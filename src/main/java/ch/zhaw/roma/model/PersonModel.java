package ch.zhaw.roma.model;

import org.hibernate.Session;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Access(AccessType.FIELD)
@Table(name = "PERSONS")
public class PersonModel {

    //region Private Fields
    @Id
    @Column(name = "PERSON_ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "STREET1")
    private String street1;
    @Column(name = "STREET2")
    private String street2;
    @Column(name = "STREET3")
    private String street3;
    @Column(name = "ZIP_CODE")
    private String zipCode;
    @Column(name = "CITY")
    private String city;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "WEBSITE")
    private String website;
    @Column(name = "MOBILE_PHON")
    private String mobilePhone;
    @Column(name = "OFFICE_PHONE")
    private String officePhone;
    @Column(name = "PRIVATE_PHONE")
    private String privatePhone;
    @Column(name = "GREETING")
    private String greeting;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "PERSON_BOOK",
        joinColumns = { @JoinColumn(name = "BOOK_ID") },
        inverseJoinColumns = { @JoinColumn(name = "PERSON_ID") }
    )
    private Set<BookModel> books;
    //endregion

    //region Getters And Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getStreet3() {
        return street3;
    }

    public void setStreet3(String street3) {
        this.street3 = street3;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getPrivatePhone() {
        return privatePhone;
    }

    public void setPrivatePhone(String privatePhone) {
        this.privatePhone = privatePhone;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Set<BookModel> getBooks() {
        return books;
    }

    public void setBooks(Set<BookModel> books) {
        this.books = books;
    }
    //endregion

    //region Construction
    public PersonModel() {

    }

    public PersonModel(String author, BookModel bookModel) {
        setLastName(author);
        if(books == null)
            books = new HashSet<>();

        books.add(bookModel);
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
