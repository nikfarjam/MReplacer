package au.com.mehdi.replacer.model;

import au.com.mehdi.replacer.util.ConfigurationUtil;
import au.com.mehdi.replacer.util.LabelConstants;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by mehdi on 6/5/16.
 */
public class ParameterTableModel extends AbstractTableModel {

    private static final int COLUMN_COUNT = 2;

    List<ParameterBean> data;

    String[] columnNames;

    public ParameterTableModel() {
        columnNames = new String[COLUMN_COUNT];
        ConfigurationUtil bundle = ConfigurationUtil.getInstance();
        columnNames[0] = bundle.getValue(LabelConstants.TABLE_PARAMETER);
        columnNames[1] = bundle.getValue(LabelConstants.TABLE_VALUE);
    }

    public List<ParameterBean> getData() {
        return data;
    }

    public void setData(List<ParameterBean> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        if (data != null) {
            return data.size();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {
        return COLUMN_COUNT;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (data == null || data.size() <= rowIndex) {
            return null;
        }
        ParameterBean param = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return param.getParameter();
            case 1:
                return param.getValue();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
