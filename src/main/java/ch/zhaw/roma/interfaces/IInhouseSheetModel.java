package ch.zhaw.roma.interfaces;

import ch.zhaw.roma.model.excel.persistence.InhouseRowModel;

import java.util.Set;

public interface IInhouseSheetModel {
    Set<InhouseRowModel> getRows();
    void setRows(Set<InhouseRowModel> rows);
}
