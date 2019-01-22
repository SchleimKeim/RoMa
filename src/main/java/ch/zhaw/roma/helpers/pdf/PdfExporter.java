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
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.DoubleBorder;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
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
    
    
    public PdfExporter(String path, PdfExportData data) throws IOException, java.io.IOException {
        this.path = path;
        this.data = data;
        formatter = new DecimalFormat("#0.00"); //formatter.format(d));
        setFonts();
        createPdf();
    }

    private void createPdf() throws MalformedURLException, FileNotFoundException {
        PdfWriter writer = new PdfWriter(path);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);
        document.add(createDocHeader().setFont(bold).setFontSize(12));
        document.add(createAddress().setFont(normal).setFontSize(8));
        document.add(new Paragraph("\n"));

        document.add(new Paragraph(data.getPlaceAndDate()).setFontSize(8));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("HONORARABRECHNUNG").setFont(bold).setFontSize(12).setCharacterSpacing(3));
        document.add(new Paragraph("\n"));
        document.add(createOverview().setFontSize(8));
        document.add(new Paragraph(""));
        document.add(createLegacy().setFontSize(8));
        document.add(new Paragraph(" "));
        //document.add(new Paragraph("1. Honorare aus Verkäufen").setFont(bold).setFontSize(8));
        document.add(new Table(new float[]{1}).setWidth(UnitValue.createPercentValue(100)).addCell(newCellNoBorderBold("1. Honorare aus Verkäufen")).setFontSize(8));
        document.add(createBookSales().setFontSize(8));
        document.add(new Paragraph(" "));
        //document.add(new Paragraph("2. Honorare aus Nebenverkäufen").setFont(bold).setFontSize(8));
        document.add(new Table(new float[]{1}).setWidth(UnitValue.createPercentValue(100)).addCell(newCellNoBorderBold("2. Honorare aus Nebenverkäufen")).setFontSize(8));
        document.add(createAuxiliary().setFontSize(8));
        document.add(new Paragraph(" "));
        //document.add(new Paragraph("3. Honorare eBook-Verkäufe (inkl. Skoobe)").setFont(bold).setFontSize(8));
        document.add(new Table(new float[]{1}).setWidth(UnitValue.createPercentValue(100)).addCell(newCellNoBorderBold("3. Honorare eBook-Verkäufe (inkl. Skoobe)")).setFontSize(8));
        document.add(createEbooks().setFontSize(8));
        document.add(new Paragraph(" "));
        document.add(createTotal().setFontSize(8));
        document.add(new Paragraph(" "));
        document.add(createAccountOverview().setFontSize(8));
        document.add(createExRateEurCHF().setFontSize(8).setHorizontalAlignment(HorizontalAlignment.RIGHT));
        document.add(new Paragraph("\n\n"));
        document.add(new Paragraph(data.getContactDetails()).setFontSize(8));
        document.close();
    }

    private void setFonts() throws java.io.IOException {
        normal = PdfFontFactory.createFont(FontConstants.HELVETICA);
        bold = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
        italic = PdfFontFactory.createFont(FontConstants.HELVETICA_OBLIQUE);
        boldItalic = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLDOBLIQUE);
    }

    //New cell with no boarder and normal font
    private Cell newCellNoBorderNormal(String text) {
        return new Cell().add(new Paragraph(text)).setBorder(Border.NO_BORDER).setFont(normal);
    }
    //New cell with no boarder and bold font
    private Cell newCellNoBorderBold(String text) {
        return new Cell().add(new Paragraph(text)).setBorder(Border.NO_BORDER).setFont(bold);
    }
    //New cell with no boarder and italic font
    private Cell newCellNoBorderItalic(String text) {
        return new Cell().add(new Paragraph(text)).setBorder(Border.NO_BORDER).setFont(italic);
    }
    //New cell with no boarder and italic font
    private Cell newCellNoBorderBoldItalic(String text) {
        return new Cell().add(new Paragraph(text)).setBorder(Border.NO_BORDER).setFont(boldItalic);
    }

    //New cell with no boarder and no font set
    private Cell newCellNoBorderNoFont(String text) {
        return new Cell().add(new Paragraph(text)).setBorder(Border.NO_BORDER);
    }

    private Table createTable() {
        Table table = new Table(new float[] {4,1,3,3,3,1,2,2});
        table.setWidth(UnitValue.createPercentValue(100));
        return table;
    }

    public void createEmptyCellNoBorder(Table table, int columns) {
        for (int i = 0; i < columns; i++) {
            table.addCell(new Cell().setBorder(Border.NO_BORDER));
        }
    }

    public void createEmptyCellWithBorder(Table table, int columns) {
        for (int i = 0; i < columns; i++) {
            table.addCell(new Cell());
        }
    }

    private Paragraph createDocHeader() throws MalformedURLException {
        Image logo = new Image(ImageDataFactory.create(data.getLogoPath()));
        Paragraph p = new Paragraph()
                .add(logo)
                .addTabStops(new TabStop(100))
                .add(data.getHeader())
                .setFont(normal)
                .setFontSize(10);
        return p;
    }

    private Paragraph createAddress() {
        String address = new String();
        if(data.getGreeting() != null) address += data.getGreeting() + "\n";
        if(data.getFirstName() != null) address += data.getFirstName() + " ";
        if(data.getLastName()!= null) address += data.getLastName() + "\n";
        if(data.getStreet1() != null) address += data.getStreet1() + "\n";
        if(data.getStreet2() != null) address += data.getStreet2() + "\n";
        if(data.getStreet3() != null) address += data.getStreet3() + "\n";
        if(data.getZipCode() != null) address += data.getZipCode() + " ";
        if(data.getCity() != null) address += data.getCity() + "\n";
        if(data.getCountry() != null) address += data.getCountry();
        return(new Paragraph(address));
    }

    private Table createOverview() {
        Table table = new Table(new float[]{1,5,2,2});
        table.setWidth((UnitValue.createPercentValue(100)));
        table.addCell(newCellNoBorderNormal("Titel"));
        Text author = new Text(data.getAuthor()).setFont(bold);
        Text bookTitle = new Text(data.getTitle()).setFont(boldItalic);
        table.addCell(new Cell().add(new Paragraph().add(author).add(", ").add(bookTitle)).setBorder(Border.NO_BORDER));
        table.addCell(newCellNoBorderBold("Buch Hardcover"));
        table.addCell(newCellNoBorderBold("eBook"));
        table.addCell(newCellNoBorderNormal("ISBN"));
        table.addCell(newCellNoBorderNormal(data.getISBN()));
        table.addCell(newCellNoBorderNormal("LP CHF " + formatter.format(data.getPriceHardCoverChf())));
        table.addCell(newCellNoBorderNoFont("")); // no CHF Price for eBook
        table.addCell(newCellNoBorderNormal("Periode"));
        table.addCell(newCellNoBorderNormal(data.getPeriodStart() + " - " + data.getPeriodEnd()));
        table.addCell(newCellNoBorderNormal("LP D € " + formatter.format(data.getPriceHardCoverEur())));
        table.addCell(newCellNoBorderNormal("LP D € " + formatter.format(data.getPriceEbookEur())));
        createEmptyCellNoBorder(table, 4);
        table.setBorderBottom(new SolidBorder(1));

        return table;
    }

    private Table createLegacy() {
        //TODO: create TreeMap for sorting entries from ArrayList
        int legacyTotal = 0;
        for(LegacyEntry lEntry : data.getLegacyEntries()) {
            legacyTotal += lEntry.getAmount();
        }
        Table table = new Table(new float[] {3,1,2});
        table.setWidth(UnitValue.createPercentValue(35));

        table.addCell(newCellNoBorderBold("Bereits abgerechnet:"));
        table.addCell(newCellNoBorderBold(Integer.toString(legacyTotal)).setTextAlignment(TextAlignment.RIGHT));
        table.addCell(newCellNoBorderBold("Exemplare"));
        ArrayList<LegacyEntry> legacyEntries = data.getLegacyEntries();
        for(LegacyEntry i: legacyEntries) {
            table.addCell(newCellNoBorderNormal(Integer.toString(i.getYear())));
            table.addCell(newCellNoBorderNormal(Integer.toString(i.getAmount())).setTextAlignment(TextAlignment.RIGHT));
            createEmptyCellNoBorder(table, 1);
        }
        return table;
    }

    private Table createBookSales() {
        Table table = createTable();
        //1. Line
        table.addCell(newCellNoBorderBold("CH"));
        createEmptyCellNoBorder(table, 1); //empty cell
        table.addCell(newCellNoBorderNormal("LP exkl. MwSt.").setTextAlignment(TextAlignment.RIGHT));
        table.addCell(newCellNoBorderNormal("Honorar-Satz").setTextAlignment(TextAlignment.RIGHT));
        table.addCell(newCellNoBorderNormal("Honorar/Ex.").setTextAlignment(TextAlignment.RIGHT));
        createEmptyCellNoBorder(table, 1); //empty cell
        table.addCell(newCellNoBorderNormal("Summe").setTextAlignment(TextAlignment.RIGHT));
        table.addCell(newCellNoBorderNormal("Summe in €").setTextAlignment(TextAlignment.RIGHT));
        //2. Line
        table.addCell(newCellNoBorderNormal("Exemplare"));
        table.addCell(newCellNoBorderNormal(Integer.toString(data.getSoldCh())).setTextAlignment(TextAlignment.RIGHT));
        table.addCell(newCellNoBorderNormal(formatter.format(data.getPriceHardCoverChfExMwSt())).setTextAlignment(TextAlignment.RIGHT));
        table.addCell(newCellNoBorderNormal(formatter.format(data.getHonoraryRate()) + "%").setTextAlignment(TextAlignment.RIGHT));
        table.addCell(newCellNoBorderNormal(formatter.format(data.getHonoraryPerCopyCH())).setTextAlignment(TextAlignment.RIGHT));
        table.addCell(newCellNoBorderNormal("CHF").setTextAlignment(TextAlignment.RIGHT));
        table.addCell(newCellNoBorderNormal(formatter.format(data.getSumChChf())).setTextAlignment(TextAlignment.RIGHT));
        table.addCell(newCellNoBorderNormal(formatter.format(data.getSumChEur())).setTextAlignment(TextAlignment.RIGHT));
        //3. Line
        table.addCell(newCellNoBorderBold("D/A"));
        createEmptyCellNoBorder(table, 7);
        //4. Line
        table.addCell(newCellNoBorderNormal("Exemplare"));
        table.addCell(newCellNoBorderNormal(Integer.toString(data.getSoldDeAu())).setTextAlignment(TextAlignment.RIGHT));
        table.addCell(newCellNoBorderNormal(formatter.format(data.getPriceHardCoverEurExMwSt())).setTextAlignment(TextAlignment.RIGHT));
        table.addCell(newCellNoBorderNormal(formatter.format(data.getHonoraryRate()) + "%").setTextAlignment(TextAlignment.RIGHT));
        table.addCell(newCellNoBorderNormal(formatter.format(data.getHonoraryPerCopyDeAu())).setTextAlignment(TextAlignment.RIGHT));
        table.addCell(newCellNoBorderNormal("€").setTextAlignment(TextAlignment.RIGHT));
        table.addCell(newCellNoBorderNormal(formatter.format(data.getSumDeAuEur())).setTextAlignment(TextAlignment.RIGHT));
        table.addCell(newCellNoBorderNormal(formatter.format(data.getSumDeAuEur())).setTextAlignment(TextAlignment.RIGHT));
        //5. Line
        table.addCell(newCellNoBorderNormal("Total"));
        table.addCell(newCellNoBorderNormal(Integer.toString(data.getSoldCh() + data.getSoldDeAu())).setTextAlignment(TextAlignment.RIGHT));
        createEmptyCellNoBorder(table, 5);
        table.addCell(newCellNoBorderNormal(formatter.format(data.getSumChEur() + data.getSumDeAuEur())).setTextAlignment(TextAlignment.RIGHT));
        return table;
    }

    private Table createAuxiliary() {
        Table table = createTable();
        ArrayList<AuxRight> auxRights = data.getAuxRights();
        for(AuxRight a : auxRights) {
            table.addCell(newCellNoBorderNormal(a.getTitle()));
            createEmptyCellNoBorder(table, 1);
            table.addCell(newCellNoBorderNormal(formatter.format(a.getAmountExMwSt())).setTextAlignment(TextAlignment.RIGHT));
            table.addCell(newCellNoBorderNormal(formatter.format(a.getHonoraryRate())).setTextAlignment(TextAlignment.RIGHT));
            createEmptyCellNoBorder(table, 1);
            table.addCell(newCellNoBorderNormal("€").setTextAlignment(TextAlignment.RIGHT));
            table.addCell(newCellNoBorderNormal(formatter.format(a.getSumEur())).setTextAlignment(TextAlignment.RIGHT));
            table.addCell(newCellNoBorderNormal(formatter.format(a.getSumEur())).setTextAlignment(TextAlignment.RIGHT));
        }
        return table;
    }

    private Table createEbooks() {

        Table table = createTable();
        //1. Line
        table.addCell(newCellNoBorderBold("D/A/CH"));
        createEmptyCellNoBorder(table, 2);
        table.addCell(newCellNoBorderNormal("% v. Nettoerlös").setTextAlignment(TextAlignment.RIGHT));
        createEmptyCellNoBorder(table, 2);
        table.addCell(newCellNoBorderNormal("Nettoerlös").setTextAlignment(TextAlignment.RIGHT));
        createEmptyCellNoBorder(table, 1);
        //2. Line
        table.addCell(newCellNoBorderBold("Exemplare"));
        table.addCell(newCellNoBorderNormal(Integer.toString(data.getSoldEbooks())).setTextAlignment(TextAlignment.RIGHT));
        createEmptyCellNoBorder(table, 1);
        table.addCell(newCellNoBorderNormal(formatter.format(data.getPercentageNetRevEbook())).setTextAlignment(TextAlignment.RIGHT));
        createEmptyCellNoBorder(table, 2);
        table.addCell(newCellNoBorderNormal(formatter.format(data.getNetRevEbooks())).setTextAlignment(TextAlignment.RIGHT));
        table.addCell(newCellNoBorderNormal(formatter.format(data.getSumEbooksEur())).setTextAlignment(TextAlignment.RIGHT));
        return table;
    }

    private Table createTotal() {
        Table table = createTable();
        table.addCell(newCellNoBorderBold("Ihr Guthaben"));
        for(int i = 0; i < 5; i++) {
            table.addCell(newCellNoBorderBold(""));
        }
        table.addCell(newCellNoBorderBold("€").setTextAlignment(TextAlignment.RIGHT));
        table.addCell(newCellNoBorderBold(formatter.format(data.getRoyalityCalculationTotal())).setTextAlignment(TextAlignment.RIGHT));
        table.setBorderTop(new SolidBorder(1)).setBorderBottom(new DoubleBorder(2));
        return table;
    }

    private Table createAccountOverview() {
        Table table = new Table(new float[] {2,1});
        table.setWidth(UnitValue.createPercentValue(40));
        table.addCell(newCellNoBorderBoldItalic("Kontoübersicht:"));
        createEmptyCellNoBorder(table, 1);
        for(AccountEntry entry : data.getEntries()) {
            table.addCell(newCellNoBorderItalic(entry.getTitle()));
            table.addCell(newCellNoBorderItalic("€ " + formatter.format(entry.getAmount())).setTextAlignment(TextAlignment.RIGHT));
        }
        table.addCell(newCellNoBorderItalic("Abrechnung per " + data.getPeriodEnd()));
        table.addCell(newCellNoBorderItalic("€ " + formatter.format(data.getRoyalityCalculationTotal())).setTextAlignment(TextAlignment.RIGHT));
        table.addCell(newCellNoBorderBoldItalic("Total zu Ihren Gunsten").setBorderTop(new SolidBorder(1)).setBorderBottom(new DoubleBorder(2)));
        table.addCell(newCellNoBorderBoldItalic("€ " + formatter.format(data.getAccountTotal())).setTextAlignment(TextAlignment.RIGHT).setBorderTop(new SolidBorder(1)).setBorderBottom(new DoubleBorder(2)));
        return table;
    }

    private Table createExRateEurCHF() {
        Table table = new Table(new float[] {3,1});
        table.setWidth(UnitValue.createPercentValue(25));
        table.addCell(newCellNoBorderNormal("Umrechnungskurs €/CHF"));
        table.addCell(newCellNoBorderNormal(formatter.format(data.getExRateEurChf())).setTextAlignment(TextAlignment.RIGHT));
        return table;
    }
}
