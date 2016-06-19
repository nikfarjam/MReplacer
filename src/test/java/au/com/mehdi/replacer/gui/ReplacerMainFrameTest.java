package au.com.mehdi.replacer.gui;

import org.fest.swing.fixture.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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