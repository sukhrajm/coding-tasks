package leetcode;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * <link>https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150<link>
 */
public class MergeSortedArray88 {

  public void merge2(int[] nums1, int m, int[] nums2, int n) {
    if (n==0) {
      return;
    }
    if (m == 0) {
      for (int i=0; i<=nums2.length-1; i++) {
        nums1[i] = nums2[i];
      }
    }
    int fillCounter = nums1.length - 1;
    int num2Counter = n-1;
    int num1Counter = m-1;
    for (int i = m-1; i>=0; i--) {
      int nums1Current = nums1[num1Counter];
      int nums2Current = nums2[num2Counter];

      if (nums1Current < nums2Current) {
        nums1[fillCounter] = nums2Current;
        fillCounter--;
        num2Counter--;
      }
      if (nums1Current > nums2Current) {
        nums1[fillCounter] = nums1[num1Counter];
        nums1[num1Counter] = nums2Current;
      }
    }

  }

  @Test
  public void testWithFullArrays() {

    int[] nums1 = new int[]{1,2,3,0,0,0};
    int[] nums2 = new int[]{2,5,6};
    merge2(nums1, 3, nums2, 3);
    assertArrayEquals(new int[]{1,2,2,3,5,6}, nums1);
  }

  @Test
  public void testWithOneFullArray() {
    int[] nums1 = new int[]{1};
    int[] nums2 = new int[]{};
    merge2(nums1, 1, nums2, 0);
    assertArrayEquals(new int[]{1}, nums1);
  }

  @Test
  public void testWithZeroValue() {
    //nums1 = [0], m = 0, nums2 = [1], n = 1
    int[] nums1 = new int[]{0};
    int[] nums2 = new int[]{1};
    merge2(nums1, 0, nums2, 1);
    assertArrayEquals(new int[]{1}, nums1);
  }

  //first pass, complex
  public void merge(int[] nums1, int m, int[] nums2, int n) {

    int[] result = new int[m + n];
    int number2Counter = 0;
    int resultFillCounter = 0;
    if (m == 0) {
      for (int i=0; i<n; i++) {
        nums1[i] = nums2[i];
      }
    }
    if (n != 0) {
      for (int i = 0; i < m; i++) {
        int number1 = nums1[i];

        if (number2Counter < nums2.length - 1) {
          int number2 = nums2[number2Counter];

          if (number1 < number2) {
            result[resultFillCounter] = number1;
            resultFillCounter++;
          }
          if (number1 == number2) {
            result[i] = number1;
            result[i + 1] = number2;
            resultFillCounter = i + 2;
            number2Counter++;
          }

        }
      }

      if (number2Counter < resultFillCounter) {
        for (int i = number2Counter; i < nums2.length; i++) {
          result[resultFillCounter] = nums2[i];
          resultFillCounter++;
        }

        for (int i = 0; i < result.length; i++) {
          nums1[i] = result[i];
        }
      }
    }
  }

}
