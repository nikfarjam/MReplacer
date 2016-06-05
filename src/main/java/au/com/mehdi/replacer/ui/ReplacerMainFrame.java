package au.com.mehdi.replacer.ui;

import au.com.mehdi.replacer.util.ConfigurationUtil;
import au.com.mehdi.replacer.util.LabelConstants;
import au.com.mehdi.replacer.util.UIFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Main Frame
 */
public class ReplacerMainFrame extends JFrame implements ActionListener {

    private InputPanel inputPanel;
    private JTable jtParam;
    private JButton jbReplace;

    public ReplacerMainFrame() throws HeadlessException {
        super(ConfigurationUtil.getInstance().getValue(LabelConstants.MAIN_TITLE));
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        inputPanel = new InputPanel();
        panel.add(inputPanel, BorderLayout.CENTER);

        jbReplace = UIFactory.createButton(LabelConstants.BUTTON_SEARCH);

        add(panel, BorderLayout.CENTER);
        add(jbReplace, BorderLayout.AFTER_LAST_LINE);

        setSize(420, 180);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
