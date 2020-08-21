package wordwrap;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given a string, divide into lines of a certain character length
 * Words can not be split
 */
public class WordWrapTest {

    @Test
    public void testOneCharacterLine_ShouldReturnOriginalString() {
        String input = "a";
        int maximumLineLength = 10;

        String result = wrap(input, maximumLineLength);
        assertEquals("a", result);
    }

    @Test
    public void testWordIsSameAsLineLength_ShouldReturnWordPerLine() {
        // given
        String input = "a b c";
        int maximumLineLength = 1;

        // when
        String result = wrap(input, maximumLineLength);

        // then
        assertEquals("a\nb\nc", result);
    }

    @Test
    public void testInputIsSmallerOfEqualToLineLength_ShouldReturnInput() {
        // given
        String input = "a b c";
        int maximumLineLength = 5;

        // when
        String result = wrap(input, maximumLineLength);

        // then
        assertEquals("a b c", result);
    }


    @Test
    public void testInputIsBiggerThanLineLength_ShouldKeepWordsUnderLimitOnSameLine() {
        // given
        String input = "the dog jumps";
        int maximumLineLength = 7;

        // when
        String result = wrap(input, maximumLineLength);

        // then
        assertEquals("the dog\njumps", result);
    }


    @Test
    public void testLineBiggerThanMaximumLine_WithWordsOnBoundary_ShouldMoveWordToNewLine() {
        // given
        String input = "the dog jumps";
        int maximumLineLength = 5;

        //when
        String result = wrap(input, maximumLineLength);

        //then
        assertEquals("the\ndog\njumps", result);
    }

    private String wrap(String input, int maximumLineLength) {
        if (input.length() <= maximumLineLength){
            return input;
        }

        String head = input.substring(0, maximumLineLength);
        int indexOfSpace = maximumLineLength;

        if (input.charAt(maximumLineLength) == ' ') {
            head = head.substring(0, maximumLineLength);
        }
        else {
            indexOfSpace = head.indexOf(" ");
            if (indexOfSpace != -1) {
                head = head.substring(0, indexOfSpace);
            }
        }

        String tail = input.substring(indexOfSpace + 1);

        return head + "\n" + wrap(tail, maximumLineLength);

    }

}
