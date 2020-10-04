package lessontwo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OddOccurrencesInArrayTest {

    @Test
    public void testWithOnePair() {
        //given
        int[] array = new int[]{2,2,3};

        //when
        int result = findOddOccurance(array);

        //then
        assertEquals(3, result);

    }

    private int findOddOccurance(int[] array) {
        return -1;
    }
}
