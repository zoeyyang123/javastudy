package foundation.dt;

import com.google.common.collect.Lists;
import foundation.model.ModelComponent;

import java.util.List;


public class TableItem extends ModelComponent {

    private List<TableColumn> columns = Lists.newArrayList();


    public List<TableColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<TableColumn> columns) {
        this.columns = columns;
    }
}
