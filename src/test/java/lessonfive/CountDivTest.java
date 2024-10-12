package lessonfive;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountDivTest {

  public int solution(int A, int B, int K) {


    double val = (double)(B - A) / K;
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

}
