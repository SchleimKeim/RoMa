package ch.zhaw.roma.model.royaltycalculation;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;

public class Settlement {

    private IntegerProperty year;



    private FloatProperty amount;


    public Settlement(int year, float amount) {
        this.year.setValue(year);
        this.amount.setValue(amount);
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

}
