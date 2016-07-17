package au.com.mehdi.replacer.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test class for String Util
 */
public class StringUtilTest {

    @Test
    public void isEmpty() throws Exception {
        assertTrue(StringUtil.isEmpty(null));
        assertTrue(StringUtil.isEmpty(""));
        assertTrue(StringUtil.isEmpty("   "));

        assertFalse(StringUtil.isEmpty("1"));
        assertFalse(StringUtil.isEmpty(" 1 "));
    }

    @Test
    public void noChangeAfterCallIsEmpty() {
        String sample = "    ABC  ";
        String origin = String.valueOf(sample);
        StringUtil.isEmpty(sample);
        assertEquals(sample, origin);

        sample = null;
        StringUtil.isEmpty(sample);
        assertNull(sample);
    }
}