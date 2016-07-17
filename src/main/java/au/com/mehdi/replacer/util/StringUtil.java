package au.com.mehdi.replacer.util;

/**
 * Util class for String operations
 */
public class StringUtil {

    private StringUtil() {
    }

    /**
     * check if a string is null or empty
     *
     * @param str string value which is checked
     * @return true, when the input is null or ""
     */
    public static boolean isEmpty(final String str) {
        if (str == null) {
            return true;
        }
        return str.isEmpty() || str.replaceAll(" ", "").isEmpty();
    }
}
