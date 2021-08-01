package lessonthree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TapeEquilibriumTest {

    public int solution(int[] A) {

        if (A.length == 1) {
            return A[0];
        }

        return -1;
    }

    @Test
    public void testWithOneElementInArray() {
        int[] a = new int[]{3};
        int p = 0;
        int result = solution(a);
        assertEquals(3, result);
    }

    @Test
    public void testWithTwoElementsInArray() {
        int[] a = new int[]{1, 2};

        int p = 1;
        int result = solution(a);
        assertEquals(1, result);


    }
}
