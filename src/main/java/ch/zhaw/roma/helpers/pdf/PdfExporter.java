package ch.zhaw.roma.helpers.pdf;

import ch.zhaw.roma.model.royaltycalculation.AccountEntry;
import ch.zhaw.roma.model.royaltycalculation.AuxRight;
import ch.zhaw.roma.model.royaltycalculation.LegacyEntry;
import com.itextpdf.io.IOException;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.UnitValue;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class PdfExporter {
    
    private final String path;
    private final PdfExportData data;
    private PdfFont normal;
    private PdfFont bold;
    private PdfFont italic;
    private PdfFont boldItalic;


    private DecimalFormat formatter;
    
    
    public PdfExporter(String path, PdfExportData data) throws IOException, MalformedURLException, FileNotFoundException {
        
        this.path = path;
        this.data = data;

        DecimalFormat formatter = new DecimalFormat("#0.00"); //formatter.format(d));
        
        setFonts();
        createPdf();


    }

    private void createPdf() throws MalformedURLException, FileNotFoundException {

            PdfWriter writer = new PdfWriter(path);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(createHeader());
            document.add(createAddress());
            document.add(new Paragraph(data.getPlaceAndDate()));
            document.add(new Paragraph("HONORARABRECHNUNG").setFont(bold)); //TODO: Font-Size needs to be bigger
            document.add(createOverview());
            //TODO: Insert Line-Break
            document.add(new Paragraph("Bereits abgerechnet").setFont(bold));
            document.add(createLegacy());
            document.add(new Paragraph("1. Honorare aus Verkäufen").setFont(bold));
            document.add(createBookSales());
            document.add(new Paragraph("2. Honorare aus Nebenverkäufen").setFont(bold));
            document.add(createAuxiliary());
            document.add(new Paragraph("3. Honorare eBook-Verkäufe (inkl. Skoobe)").setFont(bold));
            document.add(createEbooks());
            document.add(createTotal());
            document.add(createAccountOverview());


            document.close();
    }

    private Table createAccountOverview() {
        Table table = new Table(new float[] {1,1});
        table.setWidth(UnitValue.createPercentValue(33));
        table.addCell(new Cell().add(new Paragraph("Kontoübersicht:").setFont(bold)));
        setEmptyCells(table, 1);
        for(AccountEntry entry : data.getEntries()) {
            table.addCell(new Cell().add(new Paragraph(entry.getTitle()).setFont(normal)));
            table.addCell(new Cell().add(new Paragraph("€ " + formatter.format(entry.getAmount())).setFont(normal)));
        }
        table.addCell(new Cell().add(new Paragraph("Abrechnung per " + data.getPeriodEnd()).setFont(bold)));
        table.addCell(new Cell().add(new Paragraph("€ " + formatter.format(data.getRoyalityCalculationTotal())).setFont(bold)));
        table.addCell(new Cell().add(new Paragraph("Total zu Ihren Gunsten").setFont(bold)));
        table.addCell(new Cell().add(new Paragraph("€ " + formatter.format(data.getAccountTotal())).setFont(bold)));
        return table;
    }

    private Table createTotal() {
        //TODO: Format Boarders
        Table table = createTable();
        table.addCell(new Cell().add(new Paragraph("Ihr Guthaben").setFont(bold)));
        setEmptyCells(table, 5);
        table.addCell(new Cell().add(new Paragraph("€").setFont(bold)));
        table.addCell(new Cell().add(new Paragraph(formatter.format(data.getRoyalityCalculationTotal())).setFont(bold)));
        return table;
    }

    private Table createTable() {
        Table table = new Table((new float[] {4,1,3,3,3,1,2,2}));
        table.setWidth(UnitValue.createPercentValue(100));
        return table;
    }

    private Table createEbooks() {

        Table table = createTable();
        //1. Line
        table.addCell(new Cell().add(new Paragraph("D/A/CH").setFont(bold)));
        setEmptyCells(table, 2);
        table.addCell(new Cell().add(new Paragraph("% v. Nettoerlös").setFont(normal)));
        setEmptyCells(table, 2);
        table.addCell(new Cell().add(new Paragraph("Nettoerlös").setFont(normal)));
        setEmptyCells(table, 1);
        //2. Line
        table.addCell(new Cell().add(new Paragraph("Exemplare").setFont(normal)));
        table.addCell(new Cell().add(new Paragraph(Integer.toString(data.getSoldEbooks())).setFont(normal)));
        setEmptyCells(table, 1);
        table.addCell(new Cell().add(new Paragraph(formatter.format(data.getPercentageNetRevEbook())).setFont(normal)));
        setEmptyCells(table, 2);
        table.addCell(new Cell().add(new Paragraph(formatter.format(data.getNetRevEbooks())).setFont(normal)));
        table.addCell(new Cell().add(new Paragraph(formatter.format(data.getSumEbooksEur())).setFont(normal)));

        return table;
    }

    private Table createAuxiliary() {
        Table table = createTable();

        ArrayList<AuxRight> auxRights = data.getAuxRights();
        for(AuxRight a : auxRights) {
            table.addCell(new Cell().add(new Paragraph(a.getTitle())));
            setEmptyCells(table, 1);
            table.addCell(new Cell().add(new Paragraph(formatter.format(a.getAmountExMwSt())).setFont(normal)));
            table.addCell(new Cell().add(new Paragraph(formatter.format(a.getHonoraryRate())).setFont(normal)));
            setEmptyCells(table, 1);
            table.addCell(new Cell().add(new Paragraph("€").setFont(normal)));
            table.addCell(new Cell().add(new Paragraph(formatter.format(a.getSumEur())).setFont(normal)));
            table.addCell(new Cell().add(new Paragraph(formatter.format(a.getSumEur())).setFont(normal)));
        }
        return table;
    }

    private Table createBookSales() {
        Table table = createTable();
        //1. Line
        table.addCell(new Cell().add(new Paragraph("CH").setFont(bold)));
        table.addCell(new Cell()); //empty cell
        table.addCell(new Cell().add(new Paragraph("LP exkl. MwSt.").setFont(normal)));
        table.addCell(new Cell().add(new Paragraph("Honorar-Satz").setFont(normal)));
        table.addCell(new Cell().add(new Paragraph("Honorar/Ex.").setFont(normal)));
        table.addCell(new Cell()); //empty cell
        table.addCell(new Cell().add(new Paragraph("Summe").setFont(normal)));
        table.addCell(new Cell().add(new Paragraph("Summe in €").setFont(normal)));
        //2. Line
        table.addCell(new Cell().add(new Paragraph("Exemplare").setFont(normal)));
        table.addCell(new Cell().add(new Paragraph(Integer.toString(data.getSoldCh()))));
        table.addCell(new Cell().add(new Paragraph(formatter.format(data.getPriceHardCoverChfExMwSt())).setFont(normal)));
        table.addCell(new Cell().add(new Paragraph(formatter.format(data.getHonoraryRate()) + "%").setFont(normal)));
        table.addCell(new Cell().add(new Paragraph(formatter.format(data.getHonoraryPerCopyCH())).setFont(normal)));
        table.addCell(new Cell().add(new Paragraph("CHF").setFont(normal)));
        table.addCell(new Cell().add(new Paragraph(formatter.format(data.getSumChChf())).setFont(normal)));
        table.addCell(new Cell().add(new Paragraph(formatter.format(data.getSumChEur())).setFont(normal)));
        //3. Line
        table.addCell(new Cell().add(new Paragraph("D/A").setFont(bold)));
        setEmptyCells(table, 7);

        //4. Line
        table.addCell(new Cell().add(new Paragraph("Exemplare").setFont(normal)));
        table.addCell(new Cell().add(new Paragraph(Integer.toString(data.getSoldDeAu()))));
        table.addCell(new Cell().add(new Paragraph(formatter.format(data.getPriceHardCoverEurExMwSt())).setFont(normal)));
        table.addCell(new Cell().add(new Paragraph(formatter.format(data.getHonoraryRate()) + "%").setFont(normal)));
        table.addCell(new Cell().add(new Paragraph(formatter.format(data.getHonoraryPerCopyDeAu())).setFont(normal)));
        table.addCell(new Cell().add(new Paragraph("€").setFont(normal)));
        table.addCell(new Cell().add(new Paragraph(formatter.format(data.getSumDeAuEur())).setFont(normal)));
        table.addCell(new Cell().add(new Paragraph(formatter.format(data.getSumDeAuEur())).setFont(normal)));
        //5. Line
        table.addCell(new Cell().add(new Paragraph("Total").setFont(normal)));
        table.addCell(new Cell().add(new Paragraph(Integer.toString(data.getSoldCh() + data.getSoldDeAu())).setFont(normal)));
        setEmptyCells(table, 5);
        table.addCell(new Cell().add(new Paragraph(formatter.format(data.getSumChEur() + data.getSumDeAuEur()))));

        return table;
    }


    public void setEmptyCells(Table table, int columns) {
        for (int i = 0; i < columns; i++) {
            table.addCell(new Cell());
        }
    }

    private Table createLegacy() {
        //TODO: create TreeMap for sorting entries from ArrayList

        Table table = new Table(new float[] {1, 1});
        table.setWidth(UnitValue.createPercentValue(20));

        ArrayList<LegacyEntry> legacyEntries = data.getLegacyEntries();

        for(LegacyEntry i: legacyEntries) {
            table.addCell(new Cell().add(new Paragraph(Integer.toString(i.getYear()))));
            table.addCell(new Cell().add((new Paragraph(Integer.toString(i.getAmount())))));
        }
        return table;
    }



    private Table createOverview() {
        Table table = new Table(new float[]{1,4,2,2});
        table.setWidth((UnitValue.createPercentValue(100)));

        table.addCell(new Cell().add(new Paragraph("Titel").setFont(normal)));

        Text author = new Text(data.getAuthor()).setFont(bold);
        Text title = new Text(data.getTitle()).setFont(boldItalic);
        table.addCell(new Cell().add(new Paragraph(author + ", " + title)));

        table.addCell(new Cell().add(new Paragraph("Buch Hardcover").setFont(bold)));

        table.addCell(new Cell().add(new Paragraph("ebook").setFont(bold)));

        table.addCell(new Cell().add(new Paragraph("ISBN").setFont(normal)));

        table.addCell(new Cell().add(new Paragraph(data.getISBN()).setFont(normal)));

        table.addCell(new Cell().add(new Paragraph("LP CHF " + formatter.format(data.getPriceHardCoverChf()))).setFont(normal));

        table.addCell(new Cell().add(new Paragraph(""))); // no CHF Price for eBook

        table.addCell(new Cell().add(new Paragraph("Periode").setFont(normal)));

        table.addCell(new Cell().add(new Paragraph(data.getPeriodStart() + " - " + data.getPeriodEnd()).setFont(normal)));

        table.addCell(new Cell().add(new Paragraph("LP D €" + formatter.format(data.getPriceHardCoverEur())).setFont(normal)));

        table.addCell(new Cell().add(new Paragraph("LP D €" + formatter.format(data.getPriceEbookEur())).setFont(normal)));

        return table;
    }

    private Paragraph createHeader() throws MalformedURLException {
        //TODO: Change font
        Image logo = new Image(ImageDataFactory.create(data.getLogoPath()));
        return new Paragraph(logo + data.getHeader()).setFont(normal);
    }

    private Paragraph createAddress() {
    String address = new String();

    if(data.getGreeting() != null) address += data.getGreeting() + "%n";
    if(data.getFirstName() != null) address += data.getFirstName() + "%n";
    if(data.getLastName()!= null) address += data.getLastName() + "%n";
    if(data.getStreet1() != null) address += data.getStreet1() + "%n";
    if(data.getStreet2() != null) address += data.getStreet2() + "%n";
    if(data.getStreet3() != null) address += data.getStreet3() + "%n";
    if(data.getZipCode() != null) address += data.getZipCode() + " ";
    if(data.getCity() != null) address += data.getCity() + "%n";

    if(data.getCountry() != null) address += data.getCountry();

    return(new Paragraph(address));
    }


    private void setFonts() {
        try {
            normal = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
            bold = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
            italic = PdfFontFactory.createFont(FontConstants.HELVETICA_OBLIQUE);
            boldItalic = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLDOBLIQUE);

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
