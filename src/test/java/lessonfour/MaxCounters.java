package lessonfour;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import org.junit.Test;

/**
 * https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
 */
public class MaxCounters {

  private int[] solution(int N, int[] A) {

    int[] counters = new int[N];

    for (int indexOfCounterToWorkOn : A) {
      // 1 ≤ X ≤ N, then operation K is increase(X),
      if (indexOfCounterToWorkOn <= N && 1 <= indexOfCounterToWorkOn) {
        counters[indexOfCounterToWorkOn - 1] = counters[indexOfCounterToWorkOn - 1] + 1;
      }

      if (indexOfCounterToWorkOn >= N + 1) {
        //set all counters to the maximum number
        int max = findMax(counters);
        Arrays.fill(counters, max);
      }

    }
    return counters;
  }

  @Test
  public void testSolution() {
    int n = 5;
    int[] operations = new int[] { 3,4,4,6,1,4,4 };

    int[] countersResult = solution(n, operations);
    int[] expectedResult = new int[] {3, 2, 2, 4, 2};
    assertArrayEquals(expectedResult, countersResult);
  }

  private int findMax(int[] array) {

    int i;
    int max = array[0];

    for (i = 1; i < array.length; i++)
      if (array[i] > max)
        max = array[i];

    return max;

  }

}
