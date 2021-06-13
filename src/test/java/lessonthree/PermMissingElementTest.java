package lessonthree;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PermMissingElementTest {

    public int solution(int[] A) {
        if (A.length == 1) {
            return 0;
        }
        Arrays.sort(A);
        int result = -1;

        for (int i=0; i<A.length; i++) {
            int current = A[i];
            int next = -1;
            if (i != A.length-1) {
                next = A[i+1];
            }
            if (next - current != 1 && next != -1) {
                result = next - 1;
            }
        }
        return result;
    }

    @Test
    public void testWithNoMissingElement() {
        int[] a = new int[]{1};

        int result = solution(a);
        assertEquals(0, result);
    }

    @Test
    public void testWithOneMissingElement() {
        int[] a = new int[]{1,2,4};

        int result = solution(a);
        assertEquals(3, result);
    }
}
