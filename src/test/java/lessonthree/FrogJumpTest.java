package lessonthree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
 */
public class FrogJumpTest {

    public int solution(int x, int y, int d) {

        int end = y - x;

        int remainder = end % d;

        int jumps = end / d;

        if (remainder == x) {
            jumps = jumps + 1;
        }

        return jumps;
    }

    @Test
    public void testNoJumpNeeded() {
        int x = 10;
        int y = 10;
        int d = 10;

        int result = solution(x,y,d);

        assertEquals(0, result);
    }

    @Test
    public void testOneJump_YIsEqual() {
        int x = 10;
        int y = 20;
        int d = 10;

        int result = solution(x, y, d);

        assertEquals(1, result);
    }

    @Test
    public void testTwoJumps_YIsBigger() {
        int x = 5;
        int y = 30;
        int d = 10;

        int result = solution(x, y, d);


        assertEquals(3, result);
    }

    @Test
    public void testJumps_YIsBigger() {
        int x = 10;
        int y = 85;
        int d = 30;

        int result = solution(x, y, d);


        assertEquals(3, result);
    }
}
