package lessonfour;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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

    @Test
    public void testJumpsNotInOrder() {
        int[] a = new int[]{3,1,2};
        int input = 3;
        int result = solution(input, a);
        assertEquals(2, result);
    }

    int solution(int X, int[] A) {
        int earliestJump = -1;
        Set<Integer> values = new TreeSet<>();

        for (int i=0; i<A.length; i++) {
            if (A[i] <= X) {
                values.add(A[i]);
            }

            if (values.size() == X) {
                earliestJump = i;
                break;
            }
        }

        return earliestJump;
    }


}
