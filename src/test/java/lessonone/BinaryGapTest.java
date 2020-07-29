package lessonone;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryGapTest {

    @Test
    public void testWithGaps() {

        BinaryGap binaryGap = new BinaryGap();
        int result = binaryGap.solution(1041); //10000010001
        assertEquals( 5, result);
    }

    @Test
    public void testWithNoGaps() {

        BinaryGap binaryGap = new BinaryGap();
        int result = binaryGap.solution(2147483647); //1111111111111111111111111111111
        assertEquals(0, result);
    }

    @Test
    public void testWithManyGaps() {

        BinaryGap binaryGap = new BinaryGap();
        int result = binaryGap.solution(4356); //001000100000100
        assertEquals(5, result);
    }

    @Test
    public void testWithSingleZero() {

        BinaryGap binaryGap = new BinaryGap();
        int result = binaryGap.solution(0); //0
        assertEquals(0, result);
    }


    @Test
    public void testWithSingleOne() {

        BinaryGap binaryGap = new BinaryGap();
        int result = binaryGap.solution(1); //1
        assertEquals(0, result);
    }
}


