package au.com.mehdi.replacer.util;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Factory for UI components
 */
public class UIFactory {

    private UIFactory() {
    }

    public static JLabel createLabel(String key) {
        String text = ConfigurationUtil.getInstance().getValue(key);
        if (StringUtil.isEmpty(text)) {
            text = "Unknown";
        }
        JLabel label = new JLabel(text);
        label.setName(String.format("lbl_%s", key));
        return label;
    }

    public static JButton createButton(String key, List<ActionListener> listeners) {
        String text = ConfigurationUtil.getInstance().getValue(key);
        if (StringUtil.isEmpty(text)) {
            text = "Unknown";
        }
        JButton button = new JButton(text);
        if (listeners != null) {
            listeners.forEach(l -> button.addActionListener(l));
        }
        button.setName(String.format("btn_%s", key));
        return button;
    }

    public static JButton createButton(String key, ActionListener... listeners) {
        String text = ConfigurationUtil.getInstance().getValue(key);
        if (StringUtil.isEmpty(text)) {
            text = "Unknown";
        }
        JButton button = new JButton(text);
        if (listeners != null) {
            for (ActionListener l : listeners) {
                if (l != null) {
                    button.addActionListener(l);
                }
            }
        }
        button.setName(String.format("btn_%s", key));
        return button;
    }
}
