package tasks;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommonElementsTest {

    private CommonElements commonElements;

    @Before
    public void setup() {
        commonElements = new CommonElements();
    }

    @Test
    public void findCommon_withVerySmallArrays(){
        int[] input1 = new int[]{2,3};
        int[] input2 = new int[]{2,6};

        int result = commonElements.find(input1, input2);
        assertEquals(1, result);
    }

    @Test
    public void findCommon_withVeryLargeArrays(){
        int[] input1 = new int[]{2,6,7,8,9,12,13,16,19,21,24,26,29};
        int[] input2 = new int[]{6,8,9,11,13,16,19,22,23,24,31,34};

        int result = commonElements.find(input1, input2);
        assertEquals(7, result);
    }

    //fails with index out of bounds
    @Test
    public void findCommon_withFirstArraySmaller(){
        int[] input1 = new int[]{2,6,7,8,9,12,13,16,19,21,24};
        int[] input2 = new int[]{6,8,9,11,13,16,19,22,23,24,31,34};

        int result = commonElements.find(input1, input2);
        assertEquals(6, result);
    }
}


