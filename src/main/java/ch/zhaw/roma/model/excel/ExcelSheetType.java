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

    @Override
    public boolean equals(Object obj) {
        if(obj == null && this == null)
            return true;
        if(obj != null && this == null)
            return false;
        if(this != null && obj == null)
            return false;

        SheetType s = (SheetType) obj;
        return (s.compareTo(this.type) == 0);
    }

    public SheetType getType() {
        return type;
    }
    //endregion

    //region Getters and Setters
    //endregion
}
