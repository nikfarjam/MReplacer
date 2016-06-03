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
        jtPattern = new JTextField(20);
        jtPattern.setPreferredSize(textFieldDimension);
        JLabel ljRefEx = UIFactory.createLabel(REGULAR_EXPRESSION);
        jcRegEx = new JCheckBox();
        JPanel refExPanel = new JPanel();
        refExPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        refExPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        refExPanel.add(ljRefEx);
        refExPanel.add(jcRegEx);

        JLabel ljPath = UIFactory.createLabel(LABEL_PATH);
        jtPath = new JTextField(20);
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


        GridBagConstraints gc00 = new GridBagConstraints();
        gc00.weightx = 1;
        gc00.weighty = 0.1;
        gc00.gridx = 0;
        gc00.gridy = 0;
        gc00.fill = GridBagConstraints.NONE;
        gc00.anchor = GridBagConstraints.LINE_END;
        gc00.insets = new Insets(0, 0, 0, 5);

        add(ljPattern, gc00);

        GridBagConstraints gc01 = new GridBagConstraints();
        gc01.weightx = 1;
        gc01.weighty = 0.9;
        gc01.gridx = 1;
        gc01.gridy = 0;
        gc01.anchor = GridBagConstraints.LINE_START;
        add(jtPattern, gc01);

        GridBagConstraints gc11 = new GridBagConstraints();
        gc11.gridx = 1;
        gc11.gridy = 1;
        gc11.anchor = GridBagConstraints.LINE_START;
        gc11.insets = new Insets(-15, 0, 0, 0);
        add(refExPanel, gc11);

        GridBagConstraints gc20 = new GridBagConstraints();
        gc01.weightx = 1;
        gc01.weighty = 0.5;
        gc20.gridx = 0;
        gc20.gridy = 2;
        gc20.anchor = GridBagConstraints.LINE_END;
        add(ljPath, gc20);

        GridBagConstraints gc21 = new GridBagConstraints();
        gc21.gridx = 1;
        gc21.gridy = 2;
        gc21.anchor = GridBagConstraints.LINE_START;
        add(jtPath, gc21);

        GridBagConstraints gc22 = new GridBagConstraints();
        gc22.gridx = 2;
        gc22.gridy = 2;
        gc22.anchor = GridBagConstraints.LINE_START;
        add(jbOpen, gc22);

    }

    @Override
    public ReplaceData getData() {
        return null;
    }
}
