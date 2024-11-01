package lessonfour;


import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.HashSet;
import org.junit.Test;

/**
 * https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
 */
public class MissingIntegerTest {

  //A max size in 100,000
  //A values −1,000,000 to 1,000,000
  public int solution(int[] A) {

    HashSet<Integer> numbers = new HashSet<>();
    HashMap m = new HashMap(32, 2);
    //make a list starting from 1 to the length + 1
    for (int i =1; i<=A.length+1; i++) {
      numbers.add(Integer.valueOf(i));
    }

    for (int i : A) {
      numbers.remove(Integer.valueOf(i));
    }

    return numbers.iterator().next();
  }

  @Test
  public void testSolutionWithDuplicates() {
    int[] array = new int[]{1, 3, 6, 4, 1, 2};
    int result = solution(array);
    assertEquals(5, result);
  }

  @Test
  public void testSolutionConsecutiveNumber() {
    int[] array = new int[]{1, 2, 3};
    int result = solution(array);
    assertEquals(4, result);
  }

  @Test
  public void testSolutionWithNegatives() {
    int[] array = new int[]{-1, -3};
    int result = solution(array);
    assertEquals(1, result);
  }

}
