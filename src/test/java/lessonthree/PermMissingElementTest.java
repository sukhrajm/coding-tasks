package lessonthree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 ▶large_range
 range sequence, length = ~100,000✘WRONG ANSWER
 got -2147483647 expected 1
 1.0.244 sOK
 2.0.124 sWRONG ANSWER, got -2147483647 expected 1
 3.0.120 sWRONG ANSWER, got -2147471303 expected 12345

 large2
 large test, length = ~100,000✘WRONG ANSWER
 got -2147473647 expected 10001
 1.0.144 sWRONG ANSWER, got -2147473647 expected 10001

 */


public class PermMissingElementTest {

    public int solution(int[] A) {
        if (A.length == 0) {
            return 1;
        }
        int result = 0;

        int maximumNumberInArray = A.length + 1;

        int totalSumOfArray = (maximumNumberInArray * (maximumNumberInArray + 1)) / 2;

        int runningTotal = 0;
        for(int i = 0; i < A.length; i++) {
            runningTotal = runningTotal + A[i];
        }

        result = totalSumOfArray - runningTotal;
        return result;
    }

    @Test
    public void testWithNoMissingElement() {
        int[] a = new int[]{1};

        int result = solution(a);
        assertEquals(2, result);
    }

    @Test
    public void testWithOneMissingElement() {
        int[] a = new int[]{1,2,4};

        int result = solution(a);
        assertEquals(3, result);
    }

    @Test
    public void testWithEmptyList() {
        int[] a = new int[]{};

        int result = solution(a);
        assertEquals(1, result);
    }

    @Test
    public void testWithSingleElement() {
        int[] a = new int[]{1};

        int result = solution(a);
        assertEquals(2, result);
    }

    @Test
    public void testWithTwoElements() {
        int[] a = new int[]{1,3};

        int result = solution(a);
        assertEquals(2, result);
    }
}
