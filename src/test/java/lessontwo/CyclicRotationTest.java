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
    public void testOneItem_ShouldReturnInputUnchanged() {
        //given
        int[] input = new int[]{3};
        int numberOfRotations = 4;

        //when
        int[] result = cyclicRotation.solution(input, numberOfRotations);

        //then
        assertArrayEquals(input, result);
    }

    @Test
    public void testTwoItems_WithOneRotation_ShouldReturnSwapped() {
        //given
        int input[] = new int[]{2, 4};
        int numberOfRotations = 1;

        //when
        int[] result = cyclicRotation.solution(input, numberOfRotations);

        //then
        int[] expected = new int[]{4,2};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testThreeItems_WithOneRotation() {
        //given
        int input[] = new int[]{2, 4, 7};
        int numberOfRotations = 1;

        //when
        int[] result = cyclicRotation.solution(input, numberOfRotations);

        //then
        int[] expected = new int[]{7, 2, 4};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testThreeItems_WithMoreThanOneRotation() {
        //given
        int input[] = new int[]{2, 4, 7};
        int numberOfRotations = 2;

        //when
        int[] result = cyclicRotation.solution(input, numberOfRotations);

        //then
        int[] expected = new int[]{4, 7, 2};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMultipleItems_WithSameNumberOfRotation_ShouldReturnInputUnchangedl() {
        //given
        int input[] = new int[]{2, 4, 7};
        int numberOfRotations = 3;

        //when
        int[] result = cyclicRotation.solution(input, numberOfRotations);

        //then
        int[] expected = new int[]{2, 4, 7};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMultipleItems_WithNumberOfRotationsBiggerThanArrayLength() {
        //given
        int input[] = new int[]{2, 4, 7};
        int numberOfRotations = 5;

        //when
        int[] result = cyclicRotation.solution(input, numberOfRotations);

        //then
        //7,2,4
        //4,7,2
        //2,4,7
        //7,2,4
        //4,7,2
        int[] expected = new int[]{4, 7, 2};
        assertArrayEquals(expected, result);
    }

    @Test
    public void test_WithEmptyArray_ShouldReturnInputUnchanged() {
        //given
        int[] input = new int[0];
        int numberOfRotations = 3;

        //when
        int[] result = cyclicRotation.solution(input, numberOfRotations);

        //then
        assertArrayEquals(input, result);
    }

}
