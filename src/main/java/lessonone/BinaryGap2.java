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
        int maxGap = 0;

        while(true) {
            if (i <= 1 ) {
                return maxGap;
            }

            if (i==0) {
                return 0;
            }

            //get the remainder after halving i.e look at the right most digit
            int remainder = i % 2;
            if (remainder == 0) {
                if (hasSeenAOne) {
                    numberOfZeros++;
                    if (numberOfZeros > maxGap) {
                        maxGap = numberOfZeros;
                    }
                }

            } else {
                if (hasSeenAOne) {
                    //if already seen one
                    if (numberOfZeros > maxGap) {
                        maxGap = numberOfZeros;
                    }
                    numberOfZeros = 0;
                }
                hasSeenAOne = true;
            }
            i = i >> 1;
        }
    }
}
