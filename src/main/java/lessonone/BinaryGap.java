package lessonone;

import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Solution to the problem as described here:
 * https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
 * @author Sukhraj Rattan
 *
 */
public class BinaryGap {

    public int solution(int n) {

        String binaryString = Integer.toBinaryString(n);

        int maxGap = 0;
        StringTokenizer s = new StringTokenizer(binaryString, "1");

        while(s.hasMoreTokens()) {

            String gap = s.nextToken();

            //if it was not tokenized, the token would be the same as original
            if (gap.equals(binaryString)) {
                return 0;
            }

            if (gap.length() > maxGap) {
                maxGap = gap.length();
            }
        }

        return maxGap;
    }
}
