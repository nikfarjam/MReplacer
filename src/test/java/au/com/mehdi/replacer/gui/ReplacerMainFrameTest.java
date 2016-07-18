package au.com.mehdi.replacer.gui;

import au.com.mehdi.replacer.util.ConfigurationUtil;
import au.com.mehdi.replacer.util.FileUtil;
import au.com.mehdi.replacer.util.LabelConstants;
import org.fest.swing.data.TableCell;
import org.fest.swing.finder.JFileChooserFinder;
import org.fest.swing.fixture.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static au.com.mehdi.replacer.util.LabelConstants.*;
import static org.junit.Assert.assertTrue;

/**
 * Created by mehdi on 6/18/16.
 */
public class ReplacerMainFrameTest {

    private static final String TEST_PATH = "src/test/resources/";
    private static final String FILE_1 = "basic_test.txt";

    private FrameFixture demo;

    @Before
    public void setUp() throws Exception {
        Files.copy(Paths.get(TEST_PATH + "back/" + FILE_1), Paths.get(TEST_PATH + FILE_1), StandardCopyOption.REPLACE_EXISTING);
        demo = new FrameFixture(new ReplacerMainFrame());
    }

    @After
    public void tearDown() throws Exception {
        Files.delete(Paths.get(TEST_PATH + FILE_1));
        demo.cleanUp();
    }

    @Test
    public void initState() throws Exception {
        getTxtPattern().requireEmpty();
        getTxtPattern().requireEnabled();
        getTxtPattern().requireEditable();

        getTxtPath().requireEmpty();
        getTxtPath().requireDisabled();

        getCheckRegExpr().requireEnabled();
        getCheckRegExpr().requireNotSelected();

        getButtonOpen().requireEnabled();

        getButtonSearch().requireText(ConfigurationUtil.getInstance().getValue(LabelConstants.BUTTON_SEARCH));
        getButtonSearch().requireDisabled();
        getButtonCancel().requireDisabled();

        getTable().requireDisabled();
    }

    @Test
    public void disableReplaceButton() throws Exception {
        getTxtPattern().setText("$param");
        getButtonSearch().requireDisabled();
        getButtonCancel().requireDisabled();

        getCheckRegExpr().check();
        getButtonSearch().requireDisabled();
        getButtonCancel().requireDisabled();
    }

    @Test
    public void selectFile() throws Exception {
        //given
        File file = getFile();
        getTxtPattern().setText("$param");
        getButtonOpen().click();

//        when
        JFileChooserFixture fileChooser = JFileChooserFinder.findFileChooser().using(demo.robot);
        fileChooser.setCurrentDirectory(file.getParentFile());
        fileChooser.selectFile(file.getAbsoluteFile());
        fileChooser.approve();

//        then
        getTxtPath().requireText(file.getAbsolutePath());
        getButtonSearch().requireEnabled();
        getButtonCancel().requireDisabled();
    }

    @Test
    public void searchPattern() throws Exception {
//        given
        File file = getFile();
        getTxtPattern().setText("$param");
        getButtonOpen().click();
        JFileChooserFixture fileChooser = JFileChooserFinder.findFileChooser().using(demo.robot);
        fileChooser.setCurrentDirectory(file.getParentFile());
        fileChooser.selectFile(file.getAbsoluteFile());
        fileChooser.approve();

//        when
        getButtonSearch().click();
        demo.robot.waitForIdle();

//        then
        getButtonSearch().requireText(ConfigurationUtil.getInstance().getValue(LabelConstants.BUTTON_REPLACE));
        getButtonCancel().requireEnabled();
        getTable().requireEnabled();

        JTableCellFixture cell00 = getTable().cell(TableCell.row(0).column(0));
        cell00.requireNotEditable();
        cell00.requireValue("ip");

        JTableCellFixture cell01 = getTable().cell(TableCell.row(0).column(1));
        cell01.requireEditable();
        cell01.requireValue("");

        JTableCellFixture cell10 = getTable().cell(TableCell.row(1).column(0));
        cell10.requireNotEditable();
        cell10.requireValue("port");

        JTableCellFixture cell11 = getTable().cell(TableCell.row(1).column(1));
        cell11.requireEditable();
        cell11.requireValue("");

        JTableCellFixture cell20 = getTable().cell(TableCell.row(2).column(0));
        cell20.requireNotEditable();
        cell20.requireValue("path");

        JTableCellFixture cell21 = getTable().cell(TableCell.row(2).column(1));
        cell21.requireEditable();
        cell21.requireValue("");
    }

    @Test
    public void replacePatternInFile() throws Exception {
//        given
        File file = getFile();
        getTxtPattern().setText("$param");
        getButtonOpen().click();
        JFileChooserFixture fileChooser = JFileChooserFinder.findFileChooser().using(demo.robot);
        fileChooser.setCurrentDirectory(file.getParentFile());
        fileChooser.selectFile(file.getAbsoluteFile());
        fileChooser.approve();
        getButtonSearch().click();
        demo.robot.waitForIdle();

//        when
        getTable().cell(TableCell.row(0).column(1)).enterValue("127.0.0.1");
        getTable().cell(TableCell.row(1).column(1)).enterValue("8080");
        getTable().cell(TableCell.row(2).column(1)).enterValue("/tmp");
        getButtonSearch().click();
        waitForTest(2);

//        then
        assertTrue("After run replace result must as 'src/test/resources/back/basic_test_expected.txt'", FileUtil.isEqual(file, new File("src/test/resources/back/basic_test_expected.txt")));
    }

    private File getFile() {
        return new File("src/test/resources/basic_test.txt");
    }

    private void waitForTest(long l) {
        try {
            Thread.sleep(l * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private JTextComponentFixture getTxtPattern() {
        return demo.textBox("txt_pattern");
    }

    private JTextComponentFixture getTxtPath() {
        return demo.textBox("txt_path");
    }

    private JCheckBoxFixture getCheckRegExpr() {
        return demo.checkBox("chk_regularExpr");
    }

    private JButtonFixture getButtonOpen() {
        return demo.button("btn_" + BUTTON_OPEN);
    }

    private JButtonFixture getButtonSearch() {
        return demo.button("btn_" + BUTTON_SEARCH);
    }

    private JButtonFixture getButtonCancel() {
        return demo.button("btn_" + BUTTON_CANCEL);
    }

    private JTableFixture getTable() {
        return demo.table("tbl_result");
    }
}