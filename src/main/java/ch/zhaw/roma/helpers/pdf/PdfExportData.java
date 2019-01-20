package ch.zhaw.roma.helpers.pdf;

import ch.zhaw.roma.model.royaltycalculation.AccountEntry;
import ch.zhaw.roma.model.royaltycalculation.AuxRight;
import ch.zhaw.roma.model.royaltycalculation.LegacyEntry;

import java.util.ArrayList;

public class PdfExportData {

    //header
    private String logoPath = new String("src/main/resources/logo/verlag_logo.png");
    private String header = new String("MadBol Verlag AG   Javastrasse 42    CH-8000 Zürich");
    private String placeAndDate;



    //address
    private String greeting;
    private String firstName;
    private String lastName;
    private String street1;
    private String street2;
    private String street3;
    private String zipCode;
    private String city;
    private String country;

    //book
    private String ISBN;
    private String title;
    private String author;
    private double priceHardCoverEurExMwSt;
    private double priceHardCoverChfExMwSt;
    private double priceEbookEurExMwSt;
    private double priceHardCoverEur;
    private double priceHardCoverChf;
    private double priceEbookEur;
    private double percentageNetRevEbook;

    //Honorary calculation
    private String periodStart;
    private String periodEnd;
    private ArrayList<LegacyEntry> legacyEntries;

    private int soldCh;
    private int soldDeAu;
    private int soldEbooks;

    private double honoraryRate;
    private double honoraryPerCopyCH;
    private double honoraryPerCopyDeAu;

    private double sumChChf;
    private double sumChEur;
    private double sumDeAuEur;
    private double sumEbooksEur;
    private double netRevEbooks;

    private ArrayList<AuxRight> auxRights;
    private double auxRightsTotal;

    private ArrayList<AccountEntry> entries;



    private double royalityCalculationTotal; // could also be calculated: sumChEur + sumDeAuEur + sumEbooksEur + auxRightsTotal
    private double accountTotal;  //could also be calculated from entries + royalityCalculationTotal

    private double exRateEurChf;

    public PdfExportData() {

    }

    public String getPlaceAndDate() {
        return placeAndDate;
    }

    public void setPlaceAndDate(String placeAndDate) {
        this.placeAndDate = placeAndDate;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getStreet3() {
        return street3;
    }

    public void setStreet3(String street3) {
        this.street3 = street3;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPriceHardCoverEurExMwSt() {
        return priceHardCoverEurExMwSt;
    }

    public void setPriceHardCoverEurExMwSt(double priceHardCoverEurExMwSt) {
        this.priceHardCoverEurExMwSt = priceHardCoverEurExMwSt;
    }

    public double getPriceHardCoverChfExMwSt() {
        return priceHardCoverChfExMwSt;
    }

    public void setPriceHardCoverChfExMwSt(double priceHardCoverChfExMwSt) {
        this.priceHardCoverChfExMwSt = priceHardCoverChfExMwSt;
    }

    public double getPriceEbookEurExMwSt() {
        return priceEbookEurExMwSt;
    }

    public void setPriceEbookEurExMwSt(double priceEbookEurExMwSt) {
        this.priceEbookEurExMwSt = priceEbookEurExMwSt;
    }

    public double getPriceHardCoverEur() {
        return priceHardCoverEur;
    }

    public void setPriceHardCoverEur(double priceHardCoverEur) {
        this.priceHardCoverEur = priceHardCoverEur;
    }

    public double getPriceHardCoverChf() {
        return priceHardCoverChf;
    }

    public void setPriceHardCoverChf(double priceHardCoverChf) {
        this.priceHardCoverChf = priceHardCoverChf;
    }

    public double getPriceEbookEur() {
        return priceEbookEur;
    }

    public void setPriceEbookEur(double priceEbookEur) {
        this.priceEbookEur = priceEbookEur;
    }

    public double getPercentageNetRevEbook() {
        return percentageNetRevEbook;
    }

    public void setPercentageNetRevEbook(double percentageNetRevEbook) {
        this.percentageNetRevEbook = percentageNetRevEbook;
    }

    public String getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(String periodStart) {
        this.periodStart = periodStart;
    }

    public ArrayList<LegacyEntry> getLegacyEntries() {
        return legacyEntries;
    }

    public void setLegacyEntries(ArrayList<LegacyEntry> legacyEntries) {
        this.legacyEntries = legacyEntries;
    }

    public int getSoldCh() {
        return soldCh;
    }

    public void setSoldCh(int soldCh) {
        this.soldCh = soldCh;
    }

    public int getSoldDeAu() {
        return soldDeAu;
    }

    public void setSoldDeAu(int soldDeAu) {
        this.soldDeAu = soldDeAu;
    }

    public int getSoldEbooks() {
        return soldEbooks;
    }

    public void setSoldEbooks(int soldEbooks) {
        this.soldEbooks = soldEbooks;
    }

    public double getHonoraryRate() {
        return honoraryRate;
    }

    public void setHonoraryRate(double honoraryRate) {
        this.honoraryRate = honoraryRate;
    }

    public double getHonoraryPerCopyCH() {
        return honoraryPerCopyCH;
    }

    public void setHonoraryPerCopyCH(double honoraryPerCopyCH) {
        this.honoraryPerCopyCH = honoraryPerCopyCH;
    }

    public double getHonoraryPerCopyDeAu() {
        return honoraryPerCopyDeAu;
    }

    public void setHonoraryPerCopyDeAu(double honoraryPerCopyDeAu) {
        this.honoraryPerCopyDeAu = honoraryPerCopyDeAu;
    }

    public double getSumChChf() {
        return sumChChf;
    }

    public void setSumChChf(double sumChChf) {
        this.sumChChf = sumChChf;
    }

    public double getSumChEur() {
        return sumChEur;
    }

    public void setSumChEur(double sumChEur) {
        this.sumChEur = sumChEur;
    }

    public double getSumDeAuEur() {
        return sumDeAuEur;
    }

    public void setSumDeAuEur(double sumDeAuEur) {
        this.sumDeAuEur = sumDeAuEur;
    }

    public double getSumEbooksEur() {
        return sumEbooksEur;
    }

    public void setSumEbooksEur(double sumEbooksEur) {
        this.sumEbooksEur = sumEbooksEur;
    }

    public double getNetRevEbooks() {
        return netRevEbooks;
    }

    public void setNetRevEbooks(double netRevEbooks) {
        this.netRevEbooks = netRevEbooks;
    }

    public ArrayList<AuxRight> getAuxRights() {
        return auxRights;
    }

    public void setAuxRights(ArrayList<AuxRight> auxRights) {
        this.auxRights = auxRights;
    }

    public double getAuxRightsTotal() {
        return auxRightsTotal;
    }

    public void setAuxRightsTotal(double auxRightsTotal) {
        this.auxRightsTotal = auxRightsTotal;
    }

    public ArrayList<AccountEntry> getEntries() {
        return entries;
    }

    public void setEntries(ArrayList<AccountEntry> entries) {
        this.entries = entries;
    }

    public double getRoyalityCalculationTotal() {
        return royalityCalculationTotal;
    }

    public void setRoyalityCalculationTotal(double royalityCalculationTotal) {
        this.royalityCalculationTotal = royalityCalculationTotal;
    }

    public double getAccountTotal() {
        return accountTotal;
    }

    public void setAccountTotal(double accountTotal) {
        this.accountTotal = accountTotal;
    }

    public double getExRateEurChf() {
        return exRateEurChf;
    }

    public void setExRateEurChf(double exRateEurChf) {
        this.exRateEurChf = exRateEurChf;
    }

    public String getPeriodEnd() {
            return periodEnd;
    }

    public void setPeriodEnd(String periodEnd) {
        this.periodEnd = periodEnd;
    }

    }

}
