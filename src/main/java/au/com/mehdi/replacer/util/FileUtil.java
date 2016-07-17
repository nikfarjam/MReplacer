package au.com.mehdi.replacer.util;

import java.io.File;

/**
 * Util class to work with files
 */
public class FileUtil {

    private FileUtil() {
    }

    /**
     * Compare two files
     *
     * @param f1 the first file
     * @param f2 the second file
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     */
    public static int compareFile(File f1, File f2) {
        return -1;
    }

    public static boolean isExactEqual(File f1, File f2) {
        return false;
    }

    public static boolean isEqual(File f1, File f2) {
        return false;
    }
}
