package lessontwo;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CyclicRotationTest2 {

    @Test
    public void testOneItemInArray_OneRotation() {
        //given
        int[] input = new int[]{1};

        //when
        int[] result = rotateArray(input, 1);

        //then
        assertArrayEquals(input, result);
    }

    @Test
    public void testTwoItemsInArray_OneRotation() {
        //given
        int[] input = new int[]{2,4};

        //when
        int[] result = rotateArray(input, 1);

        //then
        assertArrayEquals(new int[]{4,2}, result);

    }

    @Test
    public void testThreeItemsInArray_OneRotation() {
        //given
        int[] input = new int[]{2,4,1};

        //when
        int[] result = rotateArray(input, 1);

        //then
        assertArrayEquals(new int[]{1,2,4}, result);

    }

    @Test
    public void testNumberOfRotationsIsSameSizeArray() {
        //given
        int[] input = new int[]{1,2,3,4};

        //when
        int[] result = rotateArray(input, 4);

        //then
        assertArrayEquals(new int[]{1,2,3,4}, result);
    }

    @Test
    public void testThreeItemsInArray_TwoRotations() {
        //given
        int[] input = new int[]{2,4,1};

        //when
        int[] result = rotateArray(input, 2);

        //then
        assertArrayEquals(new int[]{4,1,2}, result);

    }

    private int[] rotateArray(int[] array, int cycles) {

        if (array.length == cycles) {
            return array;
        }

        int[] itemsToMove = new int[cycles];
        int indexCounter = itemsToMove.length - 1;

        int lastIndex = array.length-1;

        int indexToStartMovingUp = lastIndex - cycles;

        int cycleCounter = 0;

        if (cycles == 1) {
            itemsToMove[0] = array[lastIndex];
        }

        for (int i=lastIndex; i >= 0; i--) {

            if (cycleCounter != cycles) {
                itemsToMove[indexCounter] = array[i];
                indexCounter--;
                cycleCounter++;
            }

            if (i <= indexToStartMovingUp) {
                array[i + cycles] = array[i];
            }

            if (i <= itemsToMove.length - 1) {
                array[i] = itemsToMove[i];
            }

        }

        return array;
    }

}
