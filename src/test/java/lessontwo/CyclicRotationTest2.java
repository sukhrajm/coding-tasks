package lessontwo;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CyclicRotationTest2 {

    /**
     * notes
     *
     * [2,6,1,3] -> 1 cycle [3,2,6,1]
     * each item move once
     * moves 1 position
     *
     * [1,6,2,5] -> 2 cycles [2,5,1,6]
     * [7,8,1,2,4,5] -> 2 cycles [4,5,7,8,1,2]
     *
     * from the end of array, you take the last n (number of cycles) elements
     * move them to the front
     *
     * [4,5,1,0] -> 3 cycles [5,1,0,4]
     *  from the end of array, you take the last n (number of cycles) elements
     *  move them to the front
     *
     *  [4,2,5,1] -> 5 cycles [1,4,2,5]
     *  take the cycle number - array length = x
     *  get the last x number of items and move to the beginning
     *
     *   []
     *
     */

    @Test
    public void testOneItemInArray_OneRotation() {
        //given
        int[] input = new int[]{1};

        //when
        int[] result = rotateArray(input, 1);

        //then
        assertArrayEquals(input, result);
    }

    private int[] rotateArray(int[] array, int cycles) {
        return null;
    }
}
