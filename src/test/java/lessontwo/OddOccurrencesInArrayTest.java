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
        Map<Integer, Integer> unpaired = new HashMap<>();

        for (int i=0; i<array.length; i++) {
            int current = array[i];
            if (unpaired.get(current) != null) {
                //if already in the list, then it's paired so remove
                unpaired.remove(current);

            } else {
                unpaired.put(current, current);
            }
        }

        Map.Entry<Integer, Integer> entry = unpaired.entrySet().iterator().next();
        return entry.getKey();
    }
}
