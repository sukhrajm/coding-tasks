package lessonfour;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/
 */
public class FrogRiverOneTest {

    @Test
    public void testOneJump() {
        int[] a = new int[]{1};
        int input = 1;
        int result = solution(input, a);
        assertEquals(0, result);
    }

    @Test
    public void testNoJumps() {
        int[] a = new int[]{1,2};
        int input = 3;
        int result = solution(input, a);
        assertEquals(-1, result);
    }

    @Test
    public void testJumpsInOrder() {
        int[] a = new int[]{1,2,3};
        int input = 3;
        int result = solution(input, a);
        assertEquals(2, result);
    }

    int solution(int x, int[] a) {
        if (a[0] == x) {
            return 0;
        }
        return -1;
    }


}
