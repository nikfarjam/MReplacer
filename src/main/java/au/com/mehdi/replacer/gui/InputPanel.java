package au.com.mehdi.replacer.gui;

import au.com.mehdi.replacer.model.ReplaceData;
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

    private File file;
    private InputPanelListener listener;

    public InputPanel() {
        createComponents();

        setLayout(new GridBagLayout());
        setBorder(createBorder());
        addFirstRow();
        addSecondRow();
        addThirdRow();
    }

    public void setListener(InputPanelListener listener) {
        this.listener = listener;
    }

    private void createComponents() {
        jfcPath = new JFileChooser();
        jfcPath.setName("path_filechooser");
        jtPattern = new JTextField(20);
        jtPattern.setName("txt_pattern");
        jcRegEx = new JCheckBox();
        jcRegEx.setName("chk_regularExpr");
        jtPath = new JTextField(20);
        jtPath.setEnabled(false);
        jtPath.setName("txt_path");
        jbOpen = UIFactory.createButton(BUTTON_OPEN, (ActionListener) e -> {
            jfcPath.setCurrentDirectory(new File(System.getProperty("user.home")));
            int ret = jfcPath.showOpenDialog(this);
            System.out.println("ret = " + ret);
            if (JFileChooser.APPROVE_OPTION == ret) {
                file = jfcPath.getSelectedFile();
                jtPath.setText(file.getAbsolutePath());
                if (listener != null) {
                    listener.updateUI();
                }
            }
        });
//        jbOpen.addActionListener(listener);
    }

    private void addFirstRow() {
        GridBagConstraints gc1 = new GridBagConstraints();
        gc1.weightx = 1;
        gc1.weighty = 0.1;
        gc1.gridx = 0;
        gc1.gridy = 0;
        gc1.fill = GridBagConstraints.NONE;
        gc1.anchor = GridBagConstraints.LINE_END;
        gc1.insets = new Insets(0, 0, 0, 5);

        add(UIFactory.createLabel(LABEL_PATTERN), gc1);

        GridBagConstraints gc2 = new GridBagConstraints();
        gc2.weightx = 1;
        gc2.weighty = 0.9;
        gc2.gridx = 1;
        gc2.gridy = 0;
        gc2.anchor = GridBagConstraints.LINE_START;
        add(jtPattern, gc2);
    }

    private void addSecondRow() {
        JPanel refExPanel = createRegularExpressionPanel();
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 1;
        gc.gridy = 1;
        gc.weighty = 0.5;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(refExPanel, gc);
    }

    private void addThirdRow() {
        GridBagConstraints gc1 = new GridBagConstraints();
        gc1.weightx = 1;
        gc1.weighty = 0.5;
        gc1.gridx = 0;
        gc1.gridy = 2;
        gc1.anchor = GridBagConstraints.LINE_END;
        add(UIFactory.createLabel(LABEL_PATH), gc1);

        GridBagConstraints gc2 = new GridBagConstraints();
        gc2.gridx = 1;
        gc2.gridy = 2;
        gc2.anchor = GridBagConstraints.LINE_START;
        add(jtPath, gc2);

        GridBagConstraints gc3 = new GridBagConstraints();
        gc3.gridx = 2;
        gc3.gridy = 2;
        gc3.anchor = GridBagConstraints.LINE_START;
        add(jbOpen, gc3);
    }

    private JPanel createRegularExpressionPanel() {
        JPanel refExPanel = new JPanel();
        refExPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        refExPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        JLabel ljRefEx = UIFactory.createLabel(REGULAR_EXPRESSION);
        refExPanel.add(ljRefEx);
        refExPanel.add(jcRegEx);
        return refExPanel;
    }

    private Border createBorder() {
        Border innerBorder = BorderFactory.createTitledBorder(ConfigurationUtil.getInstance().getValue(BUTTON_REPLACE));
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 0, 5);
        return BorderFactory.createCompoundBorder(outerBorder, innerBorder);
    }

    @Override
    public ReplaceData getData() {
        return null;
    }
}
