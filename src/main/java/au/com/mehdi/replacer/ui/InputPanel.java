package au.com.mehdi.replacer.ui;

import au.com.mehdi.replacer.data.ReplaceData;
import au.com.mehdi.replacer.util.ConfigurationUtil;
import au.com.mehdi.replacer.util.UIFactory;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

import static au.com.mehdi.replacer.util.LabelConstants.*;

/**
 * Panel that contains input components
 */
public class InputPanel extends JPanel implements InputForm {

    private JTextField jtPattern;
    private JCheckBox jcRegEx;
    private JTextField jtPath;
    private JButton jbOpen;
    private JFileChooser jfcPath;


    public InputPanel() {
        setLayout(new GridBagLayout());
        Border innerBorder = BorderFactory.createTitledBorder(ConfigurationUtil.getInstance().getValue(BUTTON_REPLACE));
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        Dimension textFieldDimension = new Dimension(200, 24);
        jfcPath = new JFileChooser();

        JLabel ljPattern = UIFactory.createLabel(LABEL_PATTERN);
        jtPattern = new JTextField();
        jtPattern.setPreferredSize(textFieldDimension);
        JLabel ljRefEx = UIFactory.createLabel(REGULAR_EXPRESSION);
        jcRegEx = new JCheckBox();
        JPanel refExPanel = new JPanel();
        refExPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        refExPanel.setPreferredSize(textFieldDimension);
        refExPanel.add(ljRefEx);
        refExPanel.add(jcRegEx);

        JLabel ljPath = UIFactory.createLabel(LABEL_PATH);
        jtPath = new JTextField();
        jtPath.setEnabled(false);
        jtPath.setPreferredSize(textFieldDimension);
        jbOpen = UIFactory.createButton(BUTTON_OPEN, (ActionListener) e -> {
            jfcPath.setCurrentDirectory(new File(System.getProperty("user.home")));
            int result = jfcPath.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jfcPath.getSelectedFile();
                jtPath.setText(selectedFile.getAbsolutePath());
            }
        });


        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.VERTICAL;

        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);

        add(ljPattern, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(jtPattern, gc);

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 1;
        gc.gridy = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(refExPanel, gc);

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 2;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);

        add(ljPath, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(jtPath, gc);

        gc.gridx = 2;
        gc.gridy = 2;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(jbOpen, gc);

    }

    @Override
    public ReplaceData getData() {
        return null;
    }
}
