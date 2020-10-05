package lessontwo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Solution for exercise: https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
 *
 * @author sukhraj rattan
 */
public class OddOccurrencesInArrayTest {

    @Test
    public void testWithOnePair() {
        //given
        int[] array = new int[]{2,2,3};

        //when
        int result = findOddOccurrence(array);

        //then
        assertEquals(3, result);

    }

    private int findOddOccurrence(int[] array) {
        List<Integer> unpaired = new ArrayList<>();

        for (int i=0; i<array.length; i++) {
            int current = array[i];
            if (unpaired.contains(current)) {
                //if already in the list, then it's paired so remove
                unpaired.remove((Integer)current);

            } else {
                unpaired.add(current);
            }
        }

        return unpaired.get(0);

    }
}
