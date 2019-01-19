package ch.zhaw.roma.interfaces;

import ch.zhaw.roma.model.excel.persistence.InhouseRowModel;

import java.util.List;

public interface IInhouseSheetModel {
    List<InhouseRowModel> getRows();
    void setRows(List<InhouseRowModel> rows);
}
