package lessontwo;

/**
 * Solution for exercise: https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
 *
 * @author sukhraj rattan
 */
public class CyclicRotation {

    public int[] solution(int[] input, int numberOfRotations) {

        int inputLength = input.length;
        if (inputLength != 1 && inputLength != numberOfRotations) {

            int countOfRotations = 0;

            while(countOfRotations < numberOfRotations) {

                int lastItem = input[inputLength-1];

                for (int i = inputLength - 2; i >= 0; i--) {
                    int currentItem = input[i];
                    input[i + 1] = currentItem;

                    if (i == 0) {
                        input[0] = lastItem;
                    }
                }
                countOfRotations++;
            }
        }
        return input;
    }
}
