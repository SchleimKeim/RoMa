package ch.zhaw.roma.interfaces;

import ch.zhaw.roma.model.excel.persistence.BookWireSheetModel;

public interface IBookWireRowModel {
     Long getId();

     void setId(Long id);

     String getIsbnNumber();

     void setIsbnNumber(String isbnNumber);

     String getAuthorAndTitle();

     void setAuthorAndTitle(String authorAndTitle);

     int getSoldUnitsJanuary();

     void setSoldUnitsJanuary(int soldUnitsJanuary);

     double getAmountJanuary();

     void setAmountJanuary(double amountJanuary);

     int getSoldUnitsFebruary();

     void setSoldUnitsFebruary(int soldUnitsFebruary);

     double getAmountFebruary();

     void setAmountFebruary(double amountFebruary);

     int getSoldUnitsMarch();

     void setSoldUnitsMarch(int soldUnitsMarch);

     double getAmountMarch();

     void setAmountMarch(double amountMarch);

     int getSoldUnitsApril();

     void setSoldUnitsApril(int soldUnitsApril);

     double getAmountApril();

     void setAmountApril(double amountApril);

     int getSoldUnitsMay();

     void setSoldUnitsMay(int soldUnitsMay);

     double getAmountMay();

     void setAmountMay(double amountMay);

     int getSoldUnitsJune();

     void setSoldUnitsJune(int soldUnitsJune);

     double getAmountJune();

     void setAmountJune(double amountJune);

     int getSoldUnitsJuly();

     void setSoldUnitsJuly(int soldUnitsJuly);

     double getAmountJuly();

     void setAmountJuly(double amountJuly);

     int getSoldUnitsAugust();

     void setSoldUnitsAugust(int soldUnitsAugust);

     double getAmountAugust();

     void setAmountAugust(double amountAugust);

     int getSoldUnitsSeptember();

     void setSoldUnitsSeptember(int soldUnitsSeptember);

     double getAmountSeptember();

     void setAmountSeptember(double amountSeptember);

     int getSoldUnitsOctober();

     void setSoldUnitsOctober(int soldUnitsOctober);

     double getAmountOctober();

     void setAmountOctober(double amountOctober);

     int getSoldUnitsNovember();

     void setSoldUnitsNovember(int soldUnitsNovember);

     double getAmountNovember();

     void setAmountNovember(double amountNovember);

     int getSoldUnitsDecember();

     void setSoldUnitsDecember(int soldUnitsDecember);

     double getAmountDecember();

     void setAmountDecember(double amountDecember);

     int getSoldUnitsTotal();

     void setSoldUnitsTotal(int soldUnitsTotal);

     double getAmountTotal();

     void setAmountTotal(double amountTotal);

     BookWireSheetModel getSheet();

     void setSheet(BookWireSheetModel sheet);
}
