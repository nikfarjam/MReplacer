package au.com.mehdi.replacer.gui;

import org.fest.swing.finder.JFileChooserFinder;
import org.fest.swing.fixture.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static au.com.mehdi.replacer.util.LabelConstants.*;

/**
 * Created by mehdi on 6/18/16.
 */
public class ReplacerMainFrameTest {

    private FrameFixture demo;

    @Before
    public void setUp() throws Exception {
        demo = new FrameFixture(new ReplacerMainFrame());
    }

    @After
    public void tearDown() throws Exception {
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

        JFileChooserFixture fileChooser = JFileChooserFinder.findFileChooser().using(demo.robot);
        fileChooser.setCurrentDirectory(file.getParentFile());
        fileChooser.selectFile(file.getAbsoluteFile());
        fileChooser.approve();

//        then
        getTxtPath().requireText(file.getAbsolutePath());
        getButtonSearch().requireEnabled();
        getButtonCancel().requireDisabled();
    }

    private File getFile() {
        return new File("src/test/resources/basic_test.txt");
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