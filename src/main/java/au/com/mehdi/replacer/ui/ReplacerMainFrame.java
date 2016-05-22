package au.com.mehdi.replacer.ui;

import au.com.mehdi.replacer.util.ConfigurationUtil;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Main Frame
 */
public class ReplacerMainFrame extends JFrame {

    private JTextField jtPattern;
    private JCheckBox jcRegEx;
    private JFileChooser jfcPath;
    private JTable jtParam;
    private JButton jbSearch;
    private JButton jbReplace;

    public ReplacerMainFrame() throws HeadlessException {
        super(ConfigurationUtil.getInstance().getValue("ui.main.title"));
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY); // todo remove
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        Border border = panel.getBorder();
        Border margin = new EmptyBorder(10,10,10,10);
        panel.setBorder(new CompoundBorder(border, margin));
        panel.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.VERTICAL;

        JLabel ljPattern = createLabel(ConfigurationUtil.getInstance().getValue("ui.main.label.pattern"));
        c.gridx = 0;
        c.gridy = 0;
        panel.add(ljPattern, c);

        jtPattern = new JTextField();
        jtPattern.setPreferredSize( new Dimension( 200, 24 ) );
        c.gridx = 1;
        c.gridy = 0;
        panel.add(jtPattern, c);

        JLabel ljRefExx = createLabel(ConfigurationUtil.getInstance().getValue("ui.main.label.regular_expression"));
        c.gridx = 0;
        c.gridy = 1;
        panel.add(ljRefExx, c);

        jcRegEx = new JCheckBox();
        c.gridx = 1;
        c.gridy = 1;
        panel.add(jcRegEx, c);

        JLabel ljPath = createLabel(ConfigurationUtil.getInstance().getValue("ui.main.label.path"));
        c.gridx = 0;
        c.gridy = 2;
        panel.add(ljPath, c);

        jfcPath = new JFileChooser();
        c.gridx = 1;
        c.gridy = 2;
//        panel.add(jfcPath, c);

        jbSearch = new JButton(ConfigurationUtil.getInstance().getValue("ui.main.button.search"));
        c.gridx = 0;
        c.gridy = 3;
        panel.add(jbSearch, c);

        jbReplace = new JButton(ConfigurationUtil.getInstance().getValue("ui.main.button.search"));
        c.gridx = 1;
        c.gridy = 3;
        panel.add(jbReplace, c);

        add(panel, BorderLayout.CENTER);
        setSize(300, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JLabel createLabel(String text){
        JLabel label = new JLabel(text);
        return label;
    }
}
