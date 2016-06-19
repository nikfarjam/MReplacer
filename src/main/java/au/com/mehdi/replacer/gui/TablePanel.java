package au.com.mehdi.replacer.gui;

import au.com.mehdi.replacer.model.ParameterBean;
import au.com.mehdi.replacer.model.ParameterTableModel;
import au.com.mehdi.replacer.util.ConfigurationUtil;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;

import static au.com.mehdi.replacer.util.LabelConstants.LABEL_TABLE;

/**
 * Created by mehdi on 6/5/16.
 */
public class TablePanel extends JPanel {

    private JTable table;
    private ParameterTableModel tableModel;

    public TablePanel() {
        setLayout(new BorderLayout());
        Border innerBorder = BorderFactory.createTitledBorder(ConfigurationUtil.getInstance().getValue(LABEL_TABLE));
        Border outerBorder = BorderFactory.createEmptyBorder(0, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        tableModel = new ParameterTableModel();
        table = new JTable(tableModel);
        table.setDefaultRenderer(Object.class, new ColourCellRenderer());
        table.setName("tbl_result");
        table.setEnabled(false);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public List<ParameterBean> getData() {
        return tableModel.getData();
    }

    public void setData(List<ParameterBean> data) {
        tableModel.setData(data);
    }
}
