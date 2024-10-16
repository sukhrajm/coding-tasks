package lessonfive;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *
 */
public class MinAvgTwoSliceTest {


  public int solution(int[] A) {

    int sumMin = Integer.MAX_VALUE;
    int index = -1;

    for (int i=0; i< A.length-1; i++) {
      int val1 = A[i];
      int val2 = A[i + 1];
      int sum = val1 + val2;
      if (sum < sumMin) {
        sumMin = sum;
        index = i;
      }
    }

    for (int i=0; i< A.length-2; i++) {
      int val1 = A[i];
      int val2 = A[i + 1];
      int val3 = A[i + 2];
      int sum = val1 + val2 + val3;
      if (sum < sumMin) {
        sumMin = sum;
        index = i;
      }
    }

    return index;
  }

  @Test
  public void testSolution() {
    int[] a = new int[] { 4,2,2,5,1,5,8 };
    int result = solution(a);
    assertEquals(1, result);
  }
}
