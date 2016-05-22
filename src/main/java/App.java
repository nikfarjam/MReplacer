import au.com.mehdi.replacer.ui.ReplacerMainFrame;
import au.com.mehdi.replacer.util.ConfigurationUtil;

import javax.swing.*;

/**
 * Main class of application.
 */
public class App {

    private App() {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->{
            new ReplacerMainFrame();
        });
    }
}
