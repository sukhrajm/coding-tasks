package tasks;

/**
 * Find the number of common elements in 2 two sorted integer arrays.
 */
public class CommonElements {


    public int find(int[] input1, int[] input2) {

        //input1 [2,6,7,8,9,12,13,16,19,21,24,26,29]

        //input2 [6,8,9,11,13,16,19,22,23,24,31,34]

        int numberOfCommonItems = 0;

        int indexOfArrayOne = 0;

        int indexOfArrayTwo = 0;
        int itemInOtherArray = 0;

        while(indexOfArrayOne != input1.length && indexOfArrayTwo != input2.length) {

            int  itemInThisArray = input1[indexOfArrayOne];

//            try {
                itemInOtherArray = input2[indexOfArrayTwo];
//            }catch(ArrayIndexOutOfBoundsException e) {
//                e.printStackTrace();
//            }

            if (itemInThisArray < itemInOtherArray) {
                //then it cant be in the other array, so move on
                indexOfArrayOne++;
            } else if (itemInThisArray == itemInOtherArray) {
                //then move both counters up
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
