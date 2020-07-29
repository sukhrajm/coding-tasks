package lessonone;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BinaryGapTest {

    @Test
    public void testBinaryGap() {

        BinaryGap binaryGap = new BinaryGap();
        int result = binaryGap.solution(1041);
        assertTrue( result == 5);
    }
}


