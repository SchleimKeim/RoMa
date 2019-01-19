package ch.zhaw.roma.interfaces;

import ch.zhaw.roma.model.excel.persistence.InhouseRowModel;

import java.util.Collection;

public interface IInhouseSheetModel {
    Collection<InhouseRowModel> getRows();
    void setRows(Collection<InhouseRowModel> rows);
}
