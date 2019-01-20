package ch.zhaw.roma.model.royaltycalculation;

public class LegacyEntry {



    private int year;
    private int amount;

    public LegacyEntry() {
    }

    public LegacyEntry(int year, int amount) {
        this.year = year;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
