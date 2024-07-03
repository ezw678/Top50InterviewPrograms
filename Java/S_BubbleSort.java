// Write a program to implement the bubble sort algorithm in Java. You can use basic
// operators and functions, but sorting functions from Java API is not allowed.

import java.util.Arrays;

public class S_BubbleSort {

  public static void main(String[] args) {
    int [] arr =  new int[] {32, 23, 45, 87, 92, 31, 19};

    bubbleSort(arr);
    System.out.println(Arrays.toString(arr));
    // output: [19, 23, 31, 32, 45, 87, 92]
  }

  static void bubbleSort(int [] arr) {
    boolean swapping = true;
    while (swapping) {
      swapping = false;
      for (int i = 0; i < arr.length - 1; i++) {
        if (arr[i] > arr[i + 1]) {
          int temp = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = temp;
          swapping = true;
        }
      }
    }
  }

}
