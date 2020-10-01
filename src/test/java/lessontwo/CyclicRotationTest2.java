package lessontwo;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CyclicRotationTest2 {

    /**
     * notes
     *
     *
     * 2 + 2 > 3 -> 4 - 3 = 1
     * 3 + 2 > 3 -> 5 - 3 = 2
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
    public void testThreeItemsInArray_TwoRotations() {
        //given
        int[] input = new int[]{2,4,1};

        //when
        int[] result = rotateArray(input, 2);

        //then
        assertArrayEquals(new int[]{4,1,2}, result);

    }

    private int[] rotateArray(int[] array, int cycles) {
        int[] itemsToMove = new int[cycles];
        int counter = itemsToMove.length - 1;
        int countOfItemsAdded = 0;

        int lastIndex = array.length-1;

        int offsetFromTheBackToTake = lastIndex - cycles;

        for (int i=lastIndex; i > 0; i--) {

            if (countOfItemsAdded != cycles) {
                itemsToMove[counter] = array[i];
                countOfItemsAdded++;
                if (counter != 0) {
                    counter--;
                }

            }
            int newPosition = findNewPosition(i,cycles,array.length-1);
            if (newPosition > offsetFromTheBackToTake) {
                array[newPosition] = array[i];
            }

            if (i == cycles){
                array[i] = array[i-1];
                array[i-1] = itemsToMove[counter];
            }

        }

        return array;
    }


    private int findNewPosition(int currentPosition, int cycles, int lastIndexNumber) {

        int newPosition = currentPosition + cycles;
        if (newPosition > lastIndexNumber) {
            newPosition = newPosition - lastIndexNumber - 1;
        }
        return newPosition;

    }
}
