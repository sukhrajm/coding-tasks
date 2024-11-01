package lessonsix;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import org.junit.Test;

/**
 * https://app.codility.com/programmers/lessons/6-sorting/distinct/
 */
public class DistinctValuesTest {

  public int solution(int[] A) {

    HashSet set = new HashSet();
    for (int number : A) {
      set.add(number);
    }
    return set.size();
  }

  @Test
  public void testSolutionWithCommonElements() {
    int a[] = new int[]{ 2,1,1,2,3,1 };
    int result = solution(a);
    assertEquals(3, result);
  }

  @Test
  public void testSolution() {
    int a[] = new int[]{ 5,6,7,8 };
    int result = solution(a);
    assertEquals(4, result);
  }

  @Test
  public void testSolutionEmpty() {
    int a[] = new int[]{  };
    int result = solution(a);
    assertEquals(0, result);
  }

  @Test
  public void testSolutionNegative() {
    int a[] = new int[]{-1,-5, 5, -4 };
    int result = solution(a);
    assertEquals(4, result);
  }
}
