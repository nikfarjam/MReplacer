package au.com.mehdi.replacer.ui;

import au.com.mehdi.replacer.util.ConfigurationUtil;
import au.com.mehdi.replacer.util.LabelConstants;

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
    private JButton jbSearch;
    private JButton jbReplace;

    public ReplacerMainFrame() throws HeadlessException {
        super(ConfigurationUtil.getInstance().getValue(LabelConstants.MAIN_TITLE));
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        inputPanel = new InputPanel();
        panel.add(inputPanel, BorderLayout.CENTER);

        add(panel, BorderLayout.CENTER);

        setSize(420, 150);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
