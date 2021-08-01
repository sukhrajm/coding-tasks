package lessonthree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TapeEquilibriumTest {

    public int solution(int[] A) {

        if (A.length == 1) {
            return A[0];
        }

        if (A.length == 2) {
            return A[1] - A[0];
        }

        int result = 0;
        int sumOfAllArray = A[0];

        for (int i=1; i<A.length; i++) {
            sumOfAllArray = sumOfAllArray + A[i];
        }

        for (int i=A.length-1; i>0; i--) {
            int remainingTotal = sumOfAllArray - A[i];
            sumOfAllArray = sumOfAllArray - A[i];
            if (remainingTotal == sumOfAllArray) {
               return sumOfAllArray + 1;
            }
        }

        return result;
    }

    @Test
    public void testWithOneElementInArray() {
        int[] a = new int[]{3};
        int result = solution(a);
        assertEquals(3, result);
    }

    @Test
    public void testWithTwoElementsInArray() {
        int[] a = new int[]{1, 2};
        int result = solution(a);
        assertEquals(1, result);
    }

    @Test
    public void testWithThreeElementsInArrayOneSplit() {
        int[] a = new int[]{3, 1, 9};
        int result = solution(a);
        assertEquals(5, result);
    }
}
