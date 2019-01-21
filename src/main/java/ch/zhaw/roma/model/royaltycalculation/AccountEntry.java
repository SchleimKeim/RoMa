package ch.zhaw.roma.model.royaltycalculation;

public class AccountEntry {

    private String title;

    public AccountEntry(String title, double amount) {
        this.title = title;
        this.amount = amount;
    }

    private double amount;

    public AccountEntry() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
