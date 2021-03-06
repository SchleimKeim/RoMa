package ch.zhaw.roma.model.excel.persistence;

import ch.zhaw.roma.model.excel.bookwire.BookWireRow;
import ch.zhaw.roma.model.excel.bookwire.BookWireSheet;
import ch.zhaw.roma.model.excel.inhouse.InhouseRow;
import ch.zhaw.roma.model.excel.inhouse.InhouseSheet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ExcelToEntityConverter {

    //region Public Members
    public static InhouseSheetModel createFrom(InhouseSheet inhouseSheet) {
        return (inhouseSheet != null)
                   ? new InhouseSheetModel(getRows(inhouseSheet), inhouseSheet.getFileName())
                   : null;
    }

    public static BookWireSheetModel createFrom(BookWireSheet bookWireSheet) {
        return (bookWireSheet != null)
                   ? new BookWireSheetModel(getRows(bookWireSheet), bookWireSheet.getFileName())
                   : null;
    }
    //endregion

    //region Private Helpers
    private static InhouseRowModel createRowFrom(InhouseRow inhouseRow) {
        InhouseRowModel m = new InhouseRowModel();
        m.setArticleNr(inhouseRow.getArticleNr());
        m.setAuthorLastName(inhouseRow.getAuthor());
        m.setTitle(inhouseRow.getTitle());
        m.setAvaSales(inhouseRow.getAvaSales());
        m.setAvaInventory(inhouseRow.getAvaInventory());
        m.setAmazonInventory(inhouseRow.getAmazonInventory());
        m.setCumulatedDisposition(inhouseRow.getCumulatedDisposition());
        m.setCumulatedSales(inhouseRow.getCumulatedSales());
        m.setDisposition(inhouseRow.getDisposition());
        m.setLastYearSales(inhouseRow.getLastYearSales());
        m.setProlitInventory(inhouseRow.getProlitInventory());
        m.setProlitSales(inhouseRow.getProlitSales());
        m.setPublisherInventory(inhouseRow.getPublisherInventory());
        m.setPublisherSales(inhouseRow.getPublisherSales());
        m.setTotalInventory(inhouseRow.getTotalInventory());
        m.setTotalSales(inhouseRow.getTotalSales());
        return m;
    }

    private static BookWireRowModel createRowFrom(BookWireRow bookWireRow) {

        BookWireRowModel r = new BookWireRowModel();
        r.setIsbnNumber(bookWireRow.getIsbnNumber());
        r.setAuthorAndTitle(bookWireRow.getAuthorAndTitle());

        String authorAndTitle = r.getAuthorAndTitle();

        String[] split = (authorAndTitle != null) && !authorAndTitle.isEmpty()
                ? r.getAuthorAndTitle().split(",")
                : new String[0];

        if(split.length == 2) {
            r.setAuthorLastName(split[0]);
            r.setBookTitle(split[1]);
        }

        r.setAmountJanuary(bookWireRow.getAmountJanuary());
        r.setSoldUnitsJanuary(bookWireRow.getSoldUnitsJanuary());

        r.setAmountFebruary(bookWireRow.getAmountFebruary());
        r.setSoldUnitsFebruary(bookWireRow.getSoldUnitsFebruary());

        r.setAmountMarch(bookWireRow.getAmountMarch());
        r.setSoldUnitsMarch(bookWireRow.getSoldUnitsMarch());

        double debug = bookWireRow.getAmountApril();

        r.setAmountApril(bookWireRow.getAmountApril());
        r.setSoldUnitsApril(bookWireRow.getSoldUnitsApril());

        r.setAmountMay(bookWireRow.getAmountMay());
        r.setSoldUnitsMay(bookWireRow.getSoldUnitsMay());

        r.setAmountJune(bookWireRow.getAmountJune());
        r.setSoldUnitsJune(bookWireRow.getSoldUnitsJune());

        r.setAmountJuly(bookWireRow.getAmountJuly());
        r.setSoldUnitsJuly(bookWireRow.getSoldUnitsJuly());

        r.setAmountAugust(bookWireRow.getAmountAugust());
        r.setSoldUnitsAugust(bookWireRow.getSoldUnitsAugust());

        r.setAmountSeptember(bookWireRow.getAmountSeptember());
        r.setSoldUnitsSeptember(bookWireRow.getSoldUnitsSeptember());

        r.setAmountOctober(bookWireRow.getAmountOctober());
        r.setSoldUnitsOctober(bookWireRow.getSoldUnitsOctober());

        r.setAmountNovember(bookWireRow.getAmountNovember());
        r.setSoldUnitsNovember(bookWireRow.getSoldUnitsNovember());

        r.setAmountDecember(bookWireRow.getAmountDecember());
        r.setSoldUnitsDecember(bookWireRow.getSoldUnitsDecember());

        return r;
    }

    private static Set<BookWireRowModel> getRows(BookWireSheet sheet) {
        return Arrays.stream(sheet.getRows())
            .map(ExcelToEntityConverter::createRowFrom)
            .collect(Collectors.toCollection(HashSet::new));
    }

    private static Set<InhouseRowModel> getRows(InhouseSheet sheet) {
        return Arrays.stream(sheet.getRows())
                   .map(ExcelToEntityConverter::createRowFrom)
                   .collect(Collectors.toCollection(HashSet::new));
    }

    //endregion
}
