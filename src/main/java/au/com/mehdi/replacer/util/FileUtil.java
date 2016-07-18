package au.com.mehdi.replacer.util;

import au.com.mehdi.replacer.exception.UtilException;

import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.zip.Adler32;

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

    public static boolean isExactEqual(File f1, File f2) throws UtilException {
        if (f1 == f2) {
            return true;
        }
        if (f1 == null || f2 == null) {
            return false;
        }
        if (StringUtil.isEmpty(f1.getAbsolutePath()) && !StringUtil.isEmpty(f2.getAbsolutePath())){
            return false;
        }
        if (StringUtil.isEmpty(f2.getAbsolutePath()) && !StringUtil.isEmpty(f1.getAbsolutePath())){
            return false;
        }
        if(f1.getAbsolutePath().equals(f2.getAbsolutePath())){
            return true;
        }
        if(f1.length() != f2.length()){
            return false;
        }

        String checksum1 = getFileChecksum(f1);
        String checksum2 = getFileChecksum(f2);

        return checksum1.equals(checksum2);
    }

    private static String getFileChecksum(File file) throws UtilException {
        String checksum ;
        try (FileInputStream fis = new FileInputStream(file)){
            checksum = calcChecksum(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new UtilException("Error in file" + file);
        }
        return checksum;
    }

    public static boolean isEqual(File f1, File f2) {
        return false;
    }

    public static List getFileDifference(File f1, File f2) {
        return Collections.emptyList();
    }

    public static String calcChecksum(InputStream is) throws IOException {
        Adler32 checksum = new Adler32();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = is.read(buffer)) > 0) {
            checksum.update(buffer, 0, length);
        }
        return Long.toHexString(checksum.getValue());
    }
}
