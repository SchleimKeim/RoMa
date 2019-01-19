package ch.zhaw.roma.model.excel.persistence;

import ch.zhaw.roma.model.excel.bookwire.BookWireRow;
import ch.zhaw.roma.model.excel.bookwire.BookWireSheet;
import ch.zhaw.roma.model.excel.inhouse.InhouseRow;
import ch.zhaw.roma.model.excel.inhouse.InhouseSheet;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class ExcelToDbConverter {

    //region Public Members
    public static InhouseSheetModel createFrom(InhouseSheet inhouseSheet) {
        InhouseSheet sheet = inhouseSheet;
        if (sheet == null)
            return null;

        InhouseRowModel[] rows = Arrays.stream(
            sheet.getRows())
                                     .map(ExcelToDbConverter::createRowFrom)
                                     .toArray(InhouseRowModel[]::new);

        InhouseSheetModel bws = new InhouseSheetModel();
        bws.setRows(getSet(rows));
        return bws;
    }

    public static BookWireSheetModel createFrom(BookWireSheet bookWireSheet) {
        BookWireSheet sheet = bookWireSheet;
        if (sheet == null)
            return null;

        BookWireRowModel[] rows = Arrays.stream(sheet.getRows())
            .map(ExcelToDbConverter::createRowFrom)
            .toArray(BookWireRowModel[]::new);

        BookWireSheetModel bws = new BookWireSheetModel();
        bws.setRows(getSet(rows));
        return bws;
    }
    //endregion

    //region Private Helpers
    private static Collection<InhouseRowModel> getSet(InhouseRowModel[] rows) {
        return Arrays.asList(rows);
    }

    private static Collection<BookWireRowModel> getSet(BookWireRowModel[] rows) {
        return Arrays.asList(rows);
    }

    private static InhouseRowModel createRowFrom(InhouseRow inhouseRow) {
        InhouseRowModel m = new InhouseRowModel();

        m.setArticleNr(inhouseRow.getArticleNr());
        m.setTitle(inhouseRow.getTitle());

        m.setAvaSales(inhouseRow.getAvaSales());
        m.setAvaInventory(inhouseRow.getAvaInventory());

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
        r.setAmountJanuary(bookWireRow.getAmountJanuary());
        r.setSoldUnitsJanuary(bookWireRow.getSoldUnitsJanuary());

        r.setAmountFebruary(bookWireRow.getAmountFebruary());
        r.setSoldUnitsFebruary(bookWireRow.getSoldUnitsFebruary());

        r.setAmountMarch(bookWireRow.getAmountMarch());
        r.setSoldUnitsMarch(bookWireRow.getSoldUnitsMarch());

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

        r.setAmountSeptembre(bookWireRow.getAmountSeptembre());
        r.setSoldUnitsSeptembre(bookWireRow.getSoldUnitsSeptembre());

        r.setAmountOctobre(bookWireRow.getAmountOctobre());
        r.setSoldUnitsOctobre(bookWireRow.getSoldUnitsOctobre());

        r.setAmountNovember(bookWireRow.getAmountNovember());
        r.setSoldUnitsDecember(bookWireRow.getSoldUnitsDecember());

        return r;
    }
    //endregion
}
