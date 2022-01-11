package wordwrap;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given a string, divide into lines of a certain character length
 * Words can not be split
 */
public class WordWrapTest2 {

    @Test
    public void testOneCharacterLine_ShouldReturnOriginalLine() {
        String input = "a";
        String result = wrap(input, 10);
        assertEquals("a", result);
    }

    @Test
    public void testSentence_whenMaximumLengthIsLessThanSentence() {
        String input = "a b c";
        String result = wrap(input, 1);
        assertEquals("a\nb\nc", result);
    }

    @Test
    public void testSentence_whenMaximumLengthIsBiggerThanSentence() {
        String input = "a b c";
        String result = wrap(input, 5);
        assertEquals("a b c", result);
    }

    @Test
    public void testSentenceWithWords_whenMaximumLengthIsSameAsBiggestWord() {
        String input = "the cow jumps";
        String result = wrap(input, 5);
        assertEquals("the\ncow\njumps", result);
    }

    @Test
    public void testSentenceWithWords_whenMaximumLengthIsBiggerThanSentence() {
        String input = "the cow jumps";
        String result = wrap(input, 15);
        assertEquals("the cow jumps", result);
    }

    private String wrap(String input, int maximumLineLength) {

        if (input.length() <= maximumLineLength){
            return input;
        }

        //always set the head to be this
        String line = input.substring(0, maximumLineLength);
        int indexOfSpace = maximumLineLength;

        if (input.charAt(maximumLineLength) == ' ') {
            line = input.substring(0, maximumLineLength);
        } else {
            indexOfSpace = line.indexOf(" ");
            if (indexOfSpace != -1) {
                line = line.substring(0, indexOfSpace);
            }
        }

        //this is the tail
        String restOfTheLine = input.substring(indexOfSpace + 1);

        return line + "\n" + wrap(restOfTheLine, maximumLineLength);
    }
}
