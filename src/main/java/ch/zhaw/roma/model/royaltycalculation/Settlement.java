package ch.zhaw.roma.model.royaltycalculation;

public class Settlement {

    private int year;
    private float amount;


    public Settlement(int year, float amount) {
        this.year = year;
        this.amount = amount;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }



}
