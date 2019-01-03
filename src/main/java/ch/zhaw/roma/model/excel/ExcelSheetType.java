package ch.zhaw.roma.model.excel;

public class ExcelSheetType {

    //region Private Fields
    private SheetType type;
    //endregion

    //region Construction
    public ExcelSheetType(SheetType type) {
        this.type = type;
    }
    //endregion

    //region Overrides
    @Override
    public String toString() {
        return type.toString();
    }

    public SheetType getType() {
        return type;
    }
    //endregion

    //region Getters and Setters
    //endregion
}
