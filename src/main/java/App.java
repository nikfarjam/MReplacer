import au.com.mehdi.replacer.gui.ReplacerMainFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

/**
 * Main class of application.
 */
public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    private App() {
    }

    public static void main(String[] args) {
        logger.warn("Start Multi replacer");
        SwingUtilities.invokeLater(() -> {
            new ReplacerMainFrame();
        });
    }
}
