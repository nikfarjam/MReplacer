package au.com.mehdi.replacer.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * Created by mehdi on 6/17/16.
 */
public class ColourCellRenderer extends DefaultTableCellRenderer {

    private static Color[] bgColors = {Color.white, new Color(236, 236, 236)};

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setBackground(getBackGroundColor(row));
        return c;
    }

    private Color getBackGroundColor(int row) {
        int i = row % bgColors.length;
        return bgColors[i];
    }
}
