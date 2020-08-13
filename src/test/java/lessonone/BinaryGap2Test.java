package lessonone;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryGap2Test {

    static BinaryGap2 binaryGap2;

    @BeforeClass
    public static void setup() {
        binaryGap2 = new BinaryGap2();
    }

    @Test
    public void testOne() {
        int result = binaryGap2.solution(0b1);
        assertEquals(0, result);
    }

    @Test
    public void testWithGapOfOne() {
        int result = binaryGap2.solution(0b101);
        assertEquals(1, result);
    }

    @Test
    public void testWithGapOfTwoInMiddle() {
        int result = binaryGap2.solution(0b1001);
        assertEquals(2, result);
    }

    @Test
    public void testWithGapOf0() {
        int result = binaryGap2.solution(0b100);
        assertEquals(0, result);
    }


    @Test
    public void testWithMultipleGaps() {
        int result = binaryGap2.solution(0b101001);
        assertEquals(2, result);
    }

    @Test
    public void testMoveToLeft() {
        //given
        int binaryNumber = 0b101;

        //when it move to the left
        int result = binaryNumber * 2;

        //then it is
        assertEquals(0b1010, result);

    }

    @Test
    public void testMoveToRight() {
        //given
        int binaryNumber = 0b101;

        //when it move to the right
        int result = binaryNumber / 2;

        //then it is
        assertEquals(0b10, result);


        int x = 43; //value of the first digit in binary representation
        int a = 0b100101;
        int remainder = a % 2; //pick last digit


    }

    /*@Test
    public void testExampleInQuestion() {
        //given a binary class
        BinaryGap2 binaryGap2 = new BinaryGap2();

        //when
        int result = binaryGap2.solution(0b10000010001);

        //then
        assertEquals(5, result);

    }*/
}
