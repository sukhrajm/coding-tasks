package lessontwo;

/**
 * Solution for exercise: https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
 *
 * @author sukhraj rattan
 */
public class CyclicRotation {

    public int[] solution(int[] input, int numberOfCycles) {

        if (input.length == 2 && numberOfCycles == 1) {
            //then it is a swap
            int firstItem = input[0];
            input[0] = input[1];
            input[1] = firstItem;
        }
        else if (input.length == 1) {
            return input;
        }
        else {
            int[] transformedInput = new int[input.length];
            int indexOfTransformedArray = 0;
            int currentCycle = 0;

            while(currentCycle < numberOfCycles) {
                for (int i = 0; i < input.length - 1; i++) {
                    transformedInput[indexOfTransformedArray + 1] = input[i];
                    indexOfTransformedArray++;

                    if (indexOfTransformedArray == input.length - 1) {
                        transformedInput[0] = input[input.length - 1];
                    }
                }
                input = transformedInput;
                transformedInput = new int[input.length];
                currentCycle++;
                indexOfTransformedArray = 0;
            }
        }
        return input;
    }
}
