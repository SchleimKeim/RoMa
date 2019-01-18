package ch.zhaw.roma.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BookModel {

    private long id;
    private String isbnNumber;
    private String title;
    private long authodId;

    public BookModel(String isbnNumber, String title) {
        this.isbnNumber = isbnNumber;
        this.title = title;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public long getId() {
        return id;
    }

    private void setId(long id) {
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

    public long getAuthodId() {
        return authodId;
    }

    public void setAuthodId(int authodId) {
        this.authodId = authodId;
    }
}


