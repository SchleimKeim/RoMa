package ch.zhaw.roma.model;

import javax.persistence.*;
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
    private String firstName;
    private String lastName;
    private String street1;
    private String street2;
    private String street3;
    private String zipCode;
    private String city;
    private String country;
    private String email;
    private String website;
    private String mobilePhone;
    private String officePhone;
    private String privatePhone;
    private String greeting;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "PERSON_BOOK",
        joinColumns = { @JoinColumn(name = "BOOK_ID") },
        inverseJoinColumns = { @JoinColumn(name = "PERSON_ID") }
    )

    private Set<TestBookModel> books;
    //endregion

    //region Public Fields
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

    public Set<TestBookModel> getBooks() {
        return books;
    }

    public void setBooks(Set<TestBookModel> books) {
        this.books = books;
    }
    //endregion

    //region Construction
    //endregion

    //region Public Members
    //endregion

    //region Private Helpers
    //endregion

    //region Overrides
    //endregion

}
