package au.com.mehdi.replacer.util;

/**
 * Util class for String operations
 */
public interface StringUtil {

    /**
     * check if a string is null or empty
     *
     * @param str string value which is checked
     * @return true, when the input is null or ""
     */
    static boolean isEmpty(String str) {
        if (str == null) {
            return true;
        }
        if (str.length() == 0) {
            return true;
        }
        return str.replaceAll(" ", "").length() == 0;
    }
}
