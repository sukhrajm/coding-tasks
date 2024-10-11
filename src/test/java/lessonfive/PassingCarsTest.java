package lessonfive;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PassingCarsTest {

  //0 represents a car traveling east,
  //1 represents a car traveling west.

  public int solution(int[] A) {

    int eastCars=0;

    int passingCars = 0;

    for (int i : A ) {

      if (i == 0) {
        //increment east cars total
        eastCars++;
      } else {
        //when we see west, find the east cars and add this counter
        passingCars = passingCars + eastCars;
      }
    }
    return passingCars > 1000000000 ? -1 : passingCars;
  }

  @Test
  public void testSolution() {
    int[] array = new int[]{ 0,1,0,1,1 };

    int result = solution(array);
    assertEquals(5, result);

  }

}
