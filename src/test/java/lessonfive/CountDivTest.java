package lessonfive;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountDivTest {

  public int solution(int A, int B, int K) {

    if (A == K && B < (A + K)) {
      return 1;
    }

    double val = (double)(B - A) / K;
    if (val < 1 && A != K ) {
      return 0;
    }

    double res = Math.ceil(val);
    if (A == K) {
      res = res + 1;
    }
    return (int)res;

  }

  @Test
  public void testSolutionFromExample() {
    int a = 6;
    int b = 11;
    int k = 2;

    int result = solution(a, b, k);
    assertEquals(3, result);
  }

  @Test
  public void testSolution() {
    int a = 3;
    int b = 18;
    int k = 3;

    int result = solution(a, b, k);
    assertEquals(6, result);
  }

  @Test
  public void testSolutionB() {
    int a = 3;
    int b = 16; //3,4,5,6,7,8,9,10,11,12,13,14,15,16
    int k = 2;

    int result = solution(a, b, k);
    assertEquals(7, result);
  }

  @Test
  public void testSolutionWith0Result() {
    int a = 3;
    int b = 4;
    int k = 2;

    int result = solution(a, b, k);
    assertEquals(0, result);
  }

  @Test
  public void testSolutionWithOneResult() {
    int a = 3;
    int b = 5;
    int k = 3;

    int result = solution(a, b, k);
    assertEquals(1, result);
  }

}
