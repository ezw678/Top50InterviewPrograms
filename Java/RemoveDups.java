//Remove duplicates from an array

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class RemoveDups {

  public static void main(String[] args) {
    Integer [] intArr = {1, 2, 3, 5, 3};
    System.out.println(Arrays.toString(removeDups(intArr)));

    String [] strArr = {"tom", "betty", "joe", "betty"};
    System.out.println(Arrays.toString(removeDups(strArr)));

    Character [] chrArr = {'t', 'b', 'j', 'b'};
    System.out.println(Arrays.toString(removeDups(chrArr)));

  }

  static <T> T[] removeDups (T [] arr) {
    Map<T, T> map = new HashMap<>();
    List<T> list = new ArrayList<>();

    for (int i = 0; i < arr.length; i++) {
      T curr = arr[i];
      if (!map.containsKey(curr)) {
        list.add(curr);
        map.put(curr, curr);
      }
    }

    @SuppressWarnings("unchecked")
    T [] res = (T[]) new Object[list.size()];
    for (int i = 0; i < list.size(); i++)
      res[i] = list.get(i);

    return res;
  }

}
