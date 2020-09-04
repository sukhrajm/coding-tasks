package lessontwo;

/**
 * Solution for exercise: https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
 *
 * @author sukhraj rattan
 */
public class CyclicRotation {

    public int[] solution(int[] input, int numberOfCycles) {

        if (input.length > 1) {
            int firstItem = input[0];
            input[0] = input[1];
            input[1] = firstItem;
        }
        return input;
    }
}
