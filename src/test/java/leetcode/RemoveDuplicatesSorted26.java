package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * <link>https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150</link>
 */
public class RemoveDuplicatesSorted26 {

  public int removeDuplicates(int[] nums) {
    //go up to -2 of the array length
    int replaceIndex=1;

    for (int i=0; i<nums.length - 1; i++) {
      if (nums[i] != nums[i + 1]) {
        nums[replaceIndex] = nums[i+1];
        replaceIndex++;
      }
    }
    return replaceIndex;

  }

  @Test
  public void test1() {
    int[] input = new int[]{1,1,2};
    int[] expected = new int[]{1,2};
    int result = removeDuplicates(input);
    assertEquals(2, result);

    for (int i = 0; i < result; i++) {
      assertEquals(expected[i], input[i]);
    }
  }

  @Test
  public void test2() {
    int[] input = new int[]{0,0,1,1,1,2,2,3,3,4};
    int[] expected = new int[]{0,1,2,3,4};
    int result = removeDuplicates(input);
    assertEquals(5, result);

    for (int i = 0; i < result; i++) {
      assertEquals(expected[i], input[i]);
    }
  }
}
