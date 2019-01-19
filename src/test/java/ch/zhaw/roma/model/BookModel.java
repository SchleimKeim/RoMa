package ch.zhaw.roma.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class BookModel {

    private Long id;
    private String isbnNumber;
    private String title;
    private Long authodId;

    public BookModel() {

    }

    public BookModel(String isbnNumber, String title) {
        this.isbnNumber = isbnNumber;
        this.title = title;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public Long getAuthodId() {
        return authodId;
    }

    public void setAuthodId(Long authodId) {
        this.authodId = authodId;
    }
}


