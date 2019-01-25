package ch.zhaw.roma.model.royaltycalculation;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;

public class SoldBooksYearly {

    private IntegerProperty year;
    private IntegerProperty amountCH;
    private IntegerProperty amountDEAU;
    private IntegerProperty amountEbooks;

    private BooleanProperty settled; // Check if royalities were payed for year


    public SoldBooksYearly(int year, boolean settled, int amountCH, int amountDEAU, int amountEbooks) {
        this.year.set(year);
        this.amountCH.set(amountCH);
        this.amountDEAU.set(amountDEAU);
        this.amountEbooks.set(amountEbooks);
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

    public int getAmountCH() {
        return amountCH.get();
    }

    public IntegerProperty amountCHProperty() {
        return amountCH;
    }

    public void setAmountCH(int amountCH) {
        this.amountCH.set(amountCH);
    }

    public int getAmountDEAU() {
        return amountDEAU.get();
    }

    public IntegerProperty amountDEAUProperty() {
        return amountDEAU;
    }

    public void setAmountDEAU(int amountDEAU) {
        this.amountDEAU.set(amountDEAU);
    }

    public int getAmountEbooks() {
        return amountEbooks.get();
    }

    public IntegerProperty amountEbooksProperty() {
        return amountEbooks;
    }

    public void setAmountEbooks(int amountEbooks) {
        this.amountEbooks.set(amountEbooks);
    }

    public boolean isSettled() {
        return settled.get();
    }

    public BooleanProperty settledProperty() {
        return settled;
    }

    public void setSettled(boolean settled) {
        this.settled.set(settled);
    }




















}
