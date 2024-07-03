// Reverse array in place

import java.util.Arrays;

public class ReverseArrayInPlace {

  public static void main(String[] args) {
    int [] arr = {1, 2, 3, 4, 5};

    reverseArrayInPlace(arr);

    System.out.println(Arrays.toString(arr));
    // output: [5, 4, 3, 2, 1]
  }

  static void reverseArrayInPlace(int [] arr) {
    int len = arr.length;

    int temp = 0;
    int l = 0, r = len - 1;
    while (l < r) {
      temp = arr[l];
      arr[l] = arr[r];
      arr[r] = temp;
      l++;
      r--;
    }
  }

}
