package lessonone;

/**
 * Solution to the problem as described here:
 * https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
 * @author Sukhraj Rattan
 *
 */
public class BinaryGap2 {

    public int solution(int i) {

        //while(i <= 1) {
        int numberOfZeros = 0;
        boolean hasSeenAOne = false;
        while(true) {
            if (i <= 1 ) {
                return numberOfZeros;
            }

            if (i==0) {
                return 0;
            }

            //divide by zero, look at the right most digit
            int remainder = i % 2;
            if (remainder == 0) {
                if (hasSeenAOne) {
                    numberOfZeros++;
                }

                //return 1;
                //return numberOfZeros;
            } else {
                hasSeenAOne = true;
            }

            //numberOfZeros++;
            i = i >> 1;

        }
    }
}
