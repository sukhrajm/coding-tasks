package leetcode;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * <link>https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150<link>
 */
public class MergeSortedArray88 {

  public void merge3(int[] nums1, int m, int[] nums2, int n) {
    int num1Counter = m-1;
    int num2Counter = n-1;
    int fillCounter = m + n - 1;

    while(num1Counter >= 0 && num2Counter >= 0) {

      if (nums1[num1Counter] > nums2[num2Counter]) {
        nums1[fillCounter] = nums1[num1Counter];
        fillCounter--;
        num1Counter--;
      } else {
        nums1[fillCounter] = nums2[num2Counter];
        fillCounter--;
        num2Counter--;
      }
    }

    while (num2Counter >=0 ) {
      nums1[fillCounter] = nums2[num2Counter];
      num2Counter--;
      fillCounter--;
    }

  }

  @Test
  public void test1() {
    int[] nums1 = new int[]{4,5,6,0,0,0};
    int m = 3;
    int[] nums2 = new int[]{1,2,3};
    int n = 3;
    merge3(nums1, m, nums2, n);
    assertArrayEquals(new int[]{1,2,3,4,5,6}, nums1);
  }

  @Test
  public void test2() {

    int[] nums1 = new int[]{1,2,3,0,0,0};
    int[] nums2 = new int[]{2,5,6};
    merge3(nums1, 3, nums2, 3);
    assertArrayEquals(new int[]{1,2,2,3,5,6}, nums1);
  }

  @Test
  public void test3() {
    int[] nums1 = new int[]{1};
    int[] nums2 = new int[]{};
    merge3(nums1, 1, nums2, 0);
    assertArrayEquals(new int[]{1}, nums1);
  }

  @Test
  public void test4() {
    //nums1 = [0], m = 0, nums2 = [1], n = 1
    int[] nums1 = new int[]{0};
    int[] nums2 = new int[]{1};
    merge3(nums1, 0, nums2, 1);
    assertArrayEquals(new int[]{1}, nums1);
  }

  public void merge2(int[] nums1, int m, int[] nums2, int n) {
    if (n==0) {
      return;
    }
    if (m == 0) {
      System.arraycopy(nums2, 0, nums1, 0, nums2.length - 1 + 1);
      return;
    }
    int fillCounter = nums1.length - 1;
    int num1Counter = m-1;
    for (int num2Counter = n-1; num2Counter>=0; num2Counter--) {
      int nums1Current = nums1[num1Counter];
      int nums2Current = nums2[num2Counter];

      if (nums1Current < nums2Current) {
        nums1[fillCounter] = nums2Current;
        fillCounter--;
      }

      if (nums1Current > nums2Current) {
        nums1[fillCounter] = nums1[num1Counter];
        nums1[num1Counter] = nums2Current;
        fillCounter--;
        if (nums1Current != 0) {
          num1Counter--;
        }
      }
    }

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
