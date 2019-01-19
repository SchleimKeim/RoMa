package ch.zhaw.roma.model.excel.persistence;

import ch.zhaw.roma.model.excel.inhouse.InhouseSheet;

public class InhouseSheetModel extends SheetModel{

    //region Private Fields
    private Long id;
    private InhouseRowModel[] rows;
    //endregion


    //region Construction
    public InhouseSheetModel() {

    }
    //endregion

    //region Public Members
    public static InhouseSheetModel createFrom(InhouseSheet asInhouse) {
        return null;
    }
    //endregion
}
