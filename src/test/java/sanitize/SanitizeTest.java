package sanitize;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SanitizeTest {

    private Sanitizer sanitizer = new Sanitizer();

    @Test
    public void testEmptyString() {
        String input = "";
        String result = sanitizer.sanitize(input);
        assertEquals("", result);
    }

    @Test
    public void testNullString() {
        String input = null;
        String result = sanitizer.sanitize(input);
        assertEquals(null, result);
    }

    @Test
    public void testGoodSentence() {
        String input = "hello world";
        String result = sanitizer.sanitize(input);
        assertEquals("hello world", result);
    }

    @Test
    public void testSingleBadWord() {
        String input = "crap";
        String result = sanitizer.sanitize(input);
        assertEquals("****", result);
    }

    @Test
    public void testTwoBadWordWithSpaceBetween() {
        String input = "crap swearword";
        String result = sanitizer.sanitize(input);
        assertEquals("**** *********", result);
    }

    @Test
    public void testBadWordFirstThenGoodWord() {
        String input = "crap hello";
        String result = sanitizer.sanitize(input);
        assertEquals("**** hello", result);
    }

    @Test
    public void testGoodWordFirstThenBadWord() {
        String input = "hello crap";
        String result = sanitizer.sanitize(input);
        assertEquals("hello ****", result);
    }

    @Test
    public void testEmailAddress() {
        String input = "hello@world.com";
        String result = sanitizer.sanitize(input);
        assertEquals("<email address>", result);
    }

    @Test
    public void testEmailAddressWithBadWord() {
        String input = "crap@world.com";
        String result = sanitizer.sanitize(input);
        assertEquals("<email address>", result);
    }



}
