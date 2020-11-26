package tasks;

/**
 * Find the number of common elements in 2 two sorted integer arrays.
 */
public class CommonElements {


    public int find(int[] input1, int[] input2) {

        //input1 [2,6,7,8,9,12,13,16,19,21,24,26,29]

        //input2 [6,8,9,11,13,16,19,22,23,24,31,34]

        //iterate the biggest array
        int largestLength = input1.length > input1.length ? input1.length : input2.length;

        int numberOfCommonItems = 0;

        int indexOfArrayOne = 0;

        int indexOfArrayTwo = 0;


        while(indexOfArrayOne < largestLength) {

            int itemInThisArray = input1[indexOfArrayOne];

            int itemInOtherArray = input2[indexOfArrayTwo];

            if (itemInThisArray < itemInOtherArray) {
                //then it cant be in the other array, so move on
                indexOfArrayOne++;
            } else if (itemInThisArray == itemInOtherArray) {
                numberOfCommonItems++;
                indexOfArrayOne++;
                indexOfArrayTwo++;

            } else {
                //this item is less than the other one
                indexOfArrayTwo++;
            }

        }

        return numberOfCommonItems;

    }

}
