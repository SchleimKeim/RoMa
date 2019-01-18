package ch.zhaw.roma.model.royaltycalculation;

public class SoldBooksYearly {

    private int year;
    private int amountCH;
    private int amountDEAU;
    private int amountEbooks;
    private boolean settled; // Check if royalities were payed for year

    public SoldBooksYearly(int year, boolean settled, int amountCH, int amountDEAU, int amountEbooks) {
        this.year = year;
        this.amountCH = amountCH;
        this.amountDEAU = amountDEAU;
        this.amountEbooks = amountEbooks;
    }

    public boolean isSettled() {
        return settled;
    }

    public void setSettled(boolean settled) {
        this.settled = settled;
    }

    public int getAmountCH() {
        return amountCH;
    }

    public void setAmountCH(int amountCH) {
        this.amountCH = amountCH;
    }

    public int getAmountDEAU() {
        return amountDEAU;
    }

    public void setAmountDEAU(int amountDEAU) {
        this.amountDEAU = amountDEAU;
    }

    public int getAmountEbooks() {
        return amountEbooks;
    }

    public void setAmountEbooks(int amountEbooks) {
        this.amountEbooks = amountEbooks;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
















}
