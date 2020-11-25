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
}


