package lessontwo;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CyclicRotationTest {

    private static CyclicRotation cyclicRotation;

    @BeforeClass
    public static void setup() {
        cyclicRotation = new CyclicRotation();
    }

    @Test
    public void testOneItem_ShouldReturnOriginal() {
        //given
        int[] input = new int[]{3};
        int numberOfTurns = 4;

        //when
        int[] result = cyclicRotation.solution(input, numberOfTurns);

        //then
        assertArrayEquals(input, result);
    }

    @Test
    public void testTwoItems_WithOneCycle_ShouldReturnSwapped() {
        //given
        int input[] = new int[]{2, 4};
        int numberOfTurns = 1;

        //when
        int[] result = cyclicRotation.solution(input, numberOfTurns);

        //then
        int[] expected = new int[]{4,2};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testThreeItems_WithOneCycle() {
        //given
        int input[] = new int[]{2, 4, 7};
        int numberOfTurns = 1;

        //when
        int[] result = cyclicRotation.solution(input, numberOfTurns);

        //then
        int[] expected = new int[]{7, 2, 4};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testThreeItems_WithMoreThanOneCycle() {
        //given
        int input[] = new int[]{2, 4, 7};
        int numberOfTurns = 2;

        //when
        int[] result = cyclicRotation.solution(input, numberOfTurns);

        //then
        int[] expected = new int[]{4, 7, 2};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMultipleItems_WithSameNumberOfCycles_ShouldReturnOriginal() {
        //given
        int input[] = new int[]{2, 4, 7};
        int numberOfTurns = 3;

        //when
        int[] result = cyclicRotation.solution(input, numberOfTurns);

        //then
        int[] expected = new int[]{2, 4, 7};
        assertArrayEquals(expected, result);
    }
}
