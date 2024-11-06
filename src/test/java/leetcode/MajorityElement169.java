package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.Test;

public class MajorityElement169 {

  public int majorityElement(int[] nums) {
    double length = nums.length;
    int halfLengthRounded = (int)Math.ceil(length/2);

    Map<Integer, Integer> freq = new HashMap<>();

    for (int i=0; i<nums.length; i++) {
      Integer f = freq.get(Integer.valueOf(nums[i]));
      if (f == null) {
        f = Integer.valueOf(1);
      } else {
        f = f + 1;
      }
      if( f > halfLengthRounded) {
        return nums[i];
      }
      freq.put(Integer.valueOf(nums[i]), f);
    }

    Integer key = Collections.max(freq.entrySet(), Entry.comparingByValue()).getKey();

    return key;
  }

  @Test
  public void test1() {
    int[] nums = new int[]{3,2,3};
    int result = majorityElement(nums);
    assertEquals(3, result);
  }

  @Test
  public void test2() {
    int[] nums = new int[]{2,2,1,1,1,2,2};
    int result = majorityElement(nums);
    assertEquals(2, result);
  }
}
