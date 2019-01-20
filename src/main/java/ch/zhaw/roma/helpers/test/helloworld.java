package ch.zhaw.roma.helpers.test;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;


import java.io.FileNotFoundException;
import java.io.IOException;


public class helloworld {

    private static final String DEST = "output/hello.pdf";

    private static PdfFont font1;

    static {
        try {
            font1 = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {


            PdfWriter writer = new PdfWriter(DEST);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            Paragraph p1 = new Paragraph();
            p1.add("ramba-zamba");
            p1.add("zamba-ramba").setFont(font1);
            document.add(p1);

        document.add(new Paragraph("John Geilo was here..."));
            document.add(new Paragraph("different font").setFont(font1));
            document.close();


    }


}
