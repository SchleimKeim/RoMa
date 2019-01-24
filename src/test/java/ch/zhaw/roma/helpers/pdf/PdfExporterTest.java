package ch.zhaw.roma.helpers.pdf;

import ch.zhaw.roma.model.royaltycalculation.AccountEntry;
import ch.zhaw.roma.model.royaltycalculation.AuxRight;
import ch.zhaw.roma.model.royaltycalculation.LegacyEntry;
import org.junit.Before;
import org.junit.Test;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import static org.junit.Assert.*;



public class PdfExporterTest {

    private PdfExportData data;

    @Before
    public void before() {

        data = new PdfExportData();
        data.setPlaceAndDate("Zürich, 20.Januar 2019");
        data.setGreeting("Herr");
        data.setFirstName("Paul");
        data.setLastName("Pedeef");
        data.setStreet1("Bahnhofstrasse 42");
        data.setZipCode("8001");
        data.setCity("Zürich");
        data.setCountry("Schweiz");
        data.setISBN("978-3-86894-9188");
        data.setTitle("Meine grosse Liebe PDF");
        data.setAuthor("Paul Pedeef");
        data.setPriceHardCoverChf(29.55);
        data.setPriceHardCoverChfExMwSt(26.45);
        data.setPriceHardCoverEur(21.65);
        data.setPriceHardCoverEurExMwSt(18.95);
        data.setPriceEbookEur(14.40);
        data.setPriceEbookEurExMwSt(9.95);
        data.setPercentageNetRevEbook(25);
        data.setPeriodStart("1.1.2018");
        data.setPeriodEnd("31.12.2018");
        LegacyEntry l1 = new LegacyEntry(2015, 69);
        LegacyEntry l2 = new LegacyEntry(2016, 1700);
        LegacyEntry l3 = new LegacyEntry(2017, 5059);
        ArrayList<LegacyEntry> legacy = new ArrayList<>();
        legacy.add(l1);
        legacy.add(l2);
        legacy.add(l3);
        data.setLegacyEntries(legacy);
        data.setSoldCh(139);
        data.setSoldDeAu(598);
        data.setSoldEbooks(1090);
        data.setHonoraryRate(7);
        data.setHonoraryPerCopyCH(2.27);
        data.setHonoraryPerCopyDeAu(1.89);
        data.setSumChChf(453.80);
        data.setSumChEur(420.74);
        data.setSumDeAuEur(4021.34);
        data.setSumEbooksEur(598.32);
        data.setNetRevEbooks(230.87);
        ArrayList<AuxRight> auxL = new ArrayList<>();
        AuxRight auxR = new AuxRight();
        auxR.setTitle("Hörbuch 2018");
        auxR.setAmountExMwSt(333.33);
        auxR.setHonoraryRate(66);
        auxR.setNetRevEur(298.42); //may not needed
        auxR.setSumEur(298.42);
        auxL.add(auxR);
        data.setAuxRights(auxL);

        double auxTotal = 0;
        for (AuxRight auxRe : auxL) {
            auxTotal += auxRe.getSumEur();
        }
        data.setAuxRightsTotal(auxTotal);

        AccountEntry accountE = new AccountEntry("Remittendenrückstellung 15%", -424.21);
        ArrayList<AccountEntry> entries = new ArrayList<>();
        entries.add(accountE);
        data.setEntries(entries);
        data.setRoyalityCalculationTotal(data.getSumChEur() + data.getSumDeAuEur() + data.getSumEbooksEur() + data.getAuxRightsTotal());

        double accountEntryTotal = 0;
        for (AccountEntry entry : entries) {
            accountEntryTotal += entry.getAmount();
        }
        data.setAccountTotal(accountEntryTotal + data.getRoyalityCalculationTotal());
        data.setContactDetails("Tel +41 44 444 44 44\nFax +41 44 999 99 99\nwww.mb-verlag.ch\nverlag@mb-verlag.ch");
        data.setExRateEurChf(1.13);
    }

    @Test
    public void printTest() {
        String path = "output/TestPDF.pdf";
        try {
            PdfExporter exporter = new PdfExporter(path, data);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //File file = new File(this.getClass().getClassLoader().getResource(path).getFile());
        File file = new File(path);

        assertTrue(file.exists());
        assertTrue(file.getTotalSpace() > 15000);
    }
}