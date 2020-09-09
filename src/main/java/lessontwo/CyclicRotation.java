package lessontwo;

/**
 * Solution for exercise: https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
 *
 * @author sukhraj rattan
 */
public class CyclicRotation {

    public int[] solution(int[] input, int numberOfCycles) {

        if (input.length ==2 && numberOfCycles == 1) {
            int firstItem = input[0];
            input[0] = input[1];
            input[1] = firstItem;
        } else {
            if (numberOfCycles == 1){
                int[] transformedInput = new int[input.length];
                int newArrayIndex = 0;

                for (int i=0; i<input.length-1; i++) {
                    transformedInput[newArrayIndex + 1] = input[i];
                    newArrayIndex++;
                    if (newArrayIndex == input.length - 1) {
                        transformedInput[0] = input[input.length - 1];
                    }

                }
                input = transformedInput;

            }

        }


        return input;
    }
}
