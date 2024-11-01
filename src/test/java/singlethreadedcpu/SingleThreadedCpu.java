package singlethreadedcpu;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import org.junit.Test;

public class SingleThreadedCpu {

  public int[] getOrder(int[][] tasks) {

    Set<Item> set = new HashSet();
    Set<ItemComparable> set2 = new TreeSet<>();

    for (int i = 0; i < tasks.length; i++) {
//      System.out.println("i = " + i);
//      System.out.println("tasks[i][0] = " + tasks[i][0]);
//      System.out.println("tasks[i][1] = " + tasks[i][1]);
      Item processingItem = new Item(i, tasks[i][0], tasks[i][1]);

      ItemComparable x = new ItemComparable(i, tasks[i][0], tasks[i][1]);
      set.add(processingItem);
      set2.add(x);
    }

//    int[] result2 = set2.stream().sorted().mapToInt(m -> m.index).toArray();
    int[] result = set.stream().mapToInt(m -> m.index).toArray();

    return result;
  }

  @Test
  public void testSingleThreadedCpu() {
    int[][] tasks = new int[][]{{1,2}, {2,4}, {3,2}, {4,1}};
    //[1,2] [3,2] [4,1] [2,4]
    int[] result = getOrder(tasks);
    int[] expected = new int[]{0,2,3,1};
    assertArrayEquals(expected, result);
  }

  @Test
  public void test2dArray() {
    int[][] exampleVariableOne = {{0, 1, 2, 3, 4}, {4, 5, 6, 7, 8}};
    // nested for loops are necessary for
    // iterating through a 2D array
    for (int countOne = 0; countOne < exampleVariableOne.length; countOne++) {
      for (int countTwo = 0; countTwo < exampleVariableOne[countOne].length; countTwo++) {
        System.out.print("Index [" + countOne + "][" + countTwo + "]: ");
        System.out.println(exampleVariableOne[countOne][countTwo]);
      }
    }
    assert true;
  }

  class Item {

    int enqueueTime;
    int processingTime;
    int index;

    public Item(int index, int enqueueTime, int processingTime) {
      this.enqueueTime = enqueueTime;
      this.processingTime = processingTime;
      this.index = index;
    }

    @Override
    public int hashCode() {
      int hash = 7;
      hash = 31 * hash + index;
      hash = 31 * hash + enqueueTime;
      hash = 31 * hash + processingTime;
      return hash;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o)
        return true;
      if (o == null || getClass() != o.getClass())
        return false;
      Item item = (Item) o;
      return enqueueTime == item.enqueueTime && processingTime == item.processingTime
          && index == item.index;
    }
  }

}

