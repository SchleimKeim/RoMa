package ch.zhaw.roma.model.royaltycalculation;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;

public class Settlement {

    private IntegerProperty year;
    private ObjectProperty<Author> author;
    private FloatProperty amount;


    public Settlement(int year, float amount, Author author) {
        this.year.setValue(year);
        this.amount.setValue(amount);
        this.author.set(author);
    }

    public int getYear() {
        return year.get();
    }

    public IntegerProperty yearProperty() {
        return year;
    }

    public void setYear(int year) {
        this.year.set(year);
    }

    public float getAmount() {
        return amount.get();
    }

    public FloatProperty amountProperty() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount.set(amount);
    }

    public Author getAuthor() {
        return author.get();
    }

    public void setAuthor(Author author) {
        this.author.set(author);
    }

    public ObjectProperty<Author> authorProperty() {
        return author;
    }


}
