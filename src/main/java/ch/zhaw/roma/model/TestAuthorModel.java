package ch.zhaw.roma.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Access(AccessType.FIELD)
public class TestAuthorModel {
    @Id
    @Column(name = "AUTHOR_ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "MIDDLE_NAME")
    private String middleName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private AddressModel address;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "AUTHOR_BOOK",
        joinColumns = { @JoinColumn(name = "BOOK_ID") },
        inverseJoinColumns = { @JoinColumn(name = "ADDRESS_ID") }
    )
    private Set<TestBookModel> books;

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
    }

    public Set<TestBookModel> getBooks() {
        return books;
    }

    public void setBooks(Set<TestBookModel> books) {
        this.books = books;
    }
}
