package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RemoveDuplicatesSortedArrayTwo80 {

//0,0,1,1,1,1,2,3,3        0,0,1,1,2,3,3
  public int removeDuplicates(int[] nums) {

    int freq = 1;
    int j = 1;

    for (int i=1; i<=nums.length-1; i++) {

        int curr = nums[i];
        int prev = nums[i-1];
        if (curr == prev) {
          freq++;
        } else {
          freq=1;
        }

        if (freq <=2 ) {
          nums[j] = curr;
          j++;
        }
    }
    return j;
  }

  @Test
  public void test1() {
    int[] input = new int[]{1,1,1,2,2,3};
    int[] expected = new int[]{1,1,2,2,3};
    int result = removeDuplicates(input);
    assertEquals(5, result);

    for (int i = 0; i < result; i++) {
      assertEquals(expected[i], input[i]);
    }
  }

  @Test
  public void test2() {
    int[] input = new int[]{0,0,1,1,1,1,2,3,3};
    int[] expected = new int[]{0,0,1,1,2,3,3};
    int result = removeDuplicates(input);
    assertEquals(7, result);

    for (int i = 0; i < result; i++) {
      assertEquals(expected[i], input[i]);
    }
  }
}
