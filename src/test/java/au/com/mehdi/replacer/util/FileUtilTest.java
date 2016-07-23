package au.com.mehdi.replacer.util;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.junit.Assert.assertTrue;

/**
 * Created by mehdi on 7/18/16.
 */
public class FileUtilTest {

    private final static String FIRST_TEST_FILE = "fu_first_file.txt";
    private final static String ENVIRONMENT = "env";
    private final static String BACK_UP = "back";
    private static final String TEST_PATH = "src/test/resources/";

    private static Path testFileBackup;
    private static Path testEnvironment;

    private File firstFile;

    @BeforeClass
    public static void setUpTest() throws Exception {
        testEnvironment = FileSystems.getDefault().getPath(TEST_PATH + ENVIRONMENT + System.currentTimeMillis());
        testFileBackup = FileSystems.getDefault().getPath(TEST_PATH + BACK_UP);
        createTestEnvironment();
    }

    @AfterClass
    public static void cleanUp() throws Exception {
        eraseTestEnvironment();
    }

    private static void eraseTestEnvironment() {
        if (!Files.exists(testEnvironment)) {
            return;
        }
        try {
            Files.list(testEnvironment).forEach(p -> {
                try {
                    if (Files.exists(p)) {
                        Files.delete(p);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            Files.deleteIfExists(testEnvironment);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createTestEnvironment() {
        try {
            Predicate<Path> isFileUtilTest = p -> p.getFileName().toString().startsWith("fu_");
            Consumer<Path> copyFileToTestEnv = s -> {
                try {
                    Files.copy(s, Paths.get(testEnvironment.toString(), s.getFileName().toString()), REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            };

            Files.copy(testFileBackup, testEnvironment, REPLACE_EXISTING);
            Files.list(testFileBackup).filter(isFileUtilTest).forEach(copyFileToTestEnv);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setUp() throws Exception {
        firstFile = new File(testEnvironment + "/" + FIRST_TEST_FILE);
        assertTrue(firstFile.exists());
    }

    @Test
    public void avoidNullPointerExceptionInIsExactEqual() throws Exception {
        assertTrue(FileUtil.isExactEqual(null, null));
        assertTrue(FileUtil.isExactEqual(firstFile, null));
        assertTrue(FileUtil.isExactEqual(null, firstFile));
    }

}