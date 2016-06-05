package au.com.mehdi.replacer.gui;

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
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//        panel.setLayout(new BorderLayout());
        inputPanel = new InputPanel();
        panel.add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        Dimension buttonPanelSize = buttonPanel.getPreferredSize();
        buttonPanelSize.width =100;
        buttonPanel.setPreferredSize(buttonPanelSize);
        jbReplace = UIFactory.createButton(LabelConstants.BUTTON_SEARCH);
        jbReplace.setPreferredSize(new Dimension(100, 50));
        buttonPanel.add(jbReplace, BorderLayout.EAST);

        panel.add(buttonPanel);

        add(panel, BorderLayout.CENTER);

        setSize(420, 180);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
