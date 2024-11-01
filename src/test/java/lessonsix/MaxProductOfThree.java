package lessonsix;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/**
 * https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/
 */
public class MaxProductOfThree {

  int[] smallest = null;

  //-3,1,2,-2,5,6
  public int solution(int[] A) {

    //
    return -1;
  }

  @Test
  public void testSolution() {
    int[] a = new int[]{-3, 1, 2, -2, 5, 6};
    int result = solution(a);
    assertEquals(result, 3);
  }

  @Test
  public void testOne() {
    Map<DataKey, Integer> hm = getAllData();

    DataKey dk = new DataKey("Pankaj", 1);
    System.out.println("test " + dk.hashCode());

    Integer value = hm.get(dk);

    System.out.println(value);

  }

  private static Map<DataKey, Integer> getAllData() {
    Map<DataKey, Integer> hm = new HashMap<>();

    DataKey dk = new DataKey("Pankaj", 1);
    System.out.println("getalldata() " + dk.hashCode());

    hm.put(dk, 10);

    return hm;
  }

}


  class DataKey {

    private String name;
    private int id;

    // getter and setter methods


    public DataKey(String name, int id) {
      this.name = name;
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public int getId() {
      return id;
    }

    @Override
    public String toString() {
      return "DataKey [name=" + name + ", id=" + id + "]";
    }

  }
