// Write a program to implement the insertion sort algorithm in Java. The program
// should take an unsorted array and sort it using insertion sort algorithm

import java.util.Arrays;

public class S_InsertionSort {

  public static void main(String[] args) {
    int [] arr =  new int[] {32, 23, 45, 87, 92, 31, 19};

    insertionSort(arr);
    System.out.println(Arrays.toString(arr));
    // output: [19, 23, 31, 32, 45, 87, 92]
  }

  static void insertionSort(int [] arr) {
    int len = arr.length;
    if (len == 0) return;

    int i = 0;
    while (i < len - 1) {
      if (arr[i] > arr[i + 1]) {
        int temp = arr[i + 1];
        int k = i;
        while (k >= 0 && temp < arr[k]) {
          arr[k + 1] = arr[k];
          k--;
        }
        arr[k + 1] = temp;
        i++;
      } else
        i++;
    }
  }

}
