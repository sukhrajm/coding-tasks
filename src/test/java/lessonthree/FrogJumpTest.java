package lessonthree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
 */
public class FrogJumpTest {

    public int solution(int x, int y, int d) {

        int jumps = 0;

        while(x < y) {
            x = x + d;
            jumps++;
        }

        return jumps;
    }

    @Test
    public void testOneJump() {
        int x = 10;
        int y = 20;
        int d = 10;

        int result = solution(x, y, d);

        assertEquals(1, result);
    }

}
