package lessontwo;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

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
}
