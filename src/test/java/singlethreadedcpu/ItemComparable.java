package singlethreadedcpu;

import java.util.Comparator;
import singlethreadedcpu.SingleThreadedCpu.Item;

public class ItemComparable implements Comparable<ItemComparable> {

  int enqueueTime;
  int processingTime;
  int index;

  public ItemComparable(int index, int enqueueTime, int processingTime) {
    this.enqueueTime = enqueueTime;
    this.processingTime = processingTime;
    this.index = index;
  }

//int[][] tasks = new int[][]{{1,2}, {2,4}, {3,2}, {4,1}};
  @Override
  public int compareTo(ItemComparable o) {
// return -1 for less, 0 for equal, and 1 for greater
    //0 means they are the same
    int enqueueComparision = Integer.compare(enqueueTime, o.enqueueTime);
    int procComparison = Integer.compare(processingTime, o.processingTime);

    if (enqueueComparision == 0 && procComparison == 0) {
      return Integer.compare(index, o.index);
    }

    //return -1 for less, 0 for equal, and 1 for greater
    return Comparator.comparing((ItemComparable i) -> i.processingTime)
        .thenComparing(p -> p.enqueueTime)
        .thenComparingInt(p -> p.index)
        .compare(this, o);
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

    return enqueueTime == item.enqueueTime && processingTime == item.processingTime && index == item.index;
  }
}
