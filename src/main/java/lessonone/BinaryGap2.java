package lessonone;

/**
 * Solution to the problem as described here:
 * https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
 * @author Sukhraj Rattan
 *
 */
public class BinaryGap2 {

    public int solution(int i) {

        int numberOfZeros = 0;
        boolean hasSeenAOne = false;
        int maxGap = 0;

        while(i != 0) {

            if (i <= 1 ) {
                return maxGap;
            }

            //get the remainder after halving i.e look at the right most digit
            int remainder = i % 2;
            if (remainder == 0) {
                if (hasSeenAOne) {
                    numberOfZeros++;
                    maxGap = getGap(numberOfZeros, maxGap);

                }

            } else {
                if (hasSeenAOne) {
                    //if already seen one
                    maxGap = getGap(numberOfZeros, maxGap);
                    numberOfZeros = 0;
                }
                hasSeenAOne = true;
            }
            i = i >> 1;
        }
        return 0;
    }

    private int getGap(int numberOfZeros, int maxGap) {
        if (numberOfZeros > maxGap) {
            return numberOfZeros;
        }
        return maxGap;
    }
}
