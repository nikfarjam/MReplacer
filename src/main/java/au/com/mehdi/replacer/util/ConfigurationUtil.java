package au.com.mehdi.replacer.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * A singleton class which loads resource bundles and configuration files
 */
public class ConfigurationUtil {

    private static ConfigurationUtil ourInstance;

    private ResourceBundle labels;

    private ConfigurationUtil() {
        labels = ResourceBundle.getBundle("ui_labels", Locale.getDefault());
        if (labels == null) {
            labels = ResourceBundle.getBundle("ui_labels");
        }
    }

    public static ConfigurationUtil getInstance() {
        if (ourInstance == null) {
            synchronized (ConfigurationUtil.class) {
                if (ourInstance == null) {
                    ourInstance = new ConfigurationUtil();
                }
            }
        }

        return ourInstance;
    }

    /**
     * Fetch value assigned to this key from resource bundle and return it.
     *
     * @param key for string value
     * @return if key is null returns "", if there is no value for this key return the key
     */
    public String getValue(String key) {
        if (StringUtil.isEmpty(key)) {
            return "";
        }
        String value = labels.getString(key);
        if (StringUtil.isEmpty(value)) {
            return key;
        }
        return value;
    }

}
