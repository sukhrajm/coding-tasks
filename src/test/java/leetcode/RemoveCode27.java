package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RemoveCode27 {

  public int removeElement(int[] nums, int val) {

    int countOfNotEqual = 0;

    for (int i=0; i<nums.length; i++) {
      int current = nums[i];
      if (current != val) {
        nums[countOfNotEqual] = current;
        countOfNotEqual++;
      }
    }
    return countOfNotEqual;
  }

  @Test
  public void test1() {

    int[] a = new int[]{3,2,2,3};
    int val = 3;
    int k = removeElement(a, val);
    assertEquals(2, k);
  }

  @Test
  public void test2() {
    int[] a = new int[]{0,1,2,2,3,0,4,2};
    int val = 2;

    int k = removeElement(a, val);
    assertEquals(5, k);
  }

}
