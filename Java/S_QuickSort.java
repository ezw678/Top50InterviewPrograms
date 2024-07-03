// You need to write a Java program to sort an array of integers using a quick sort
// algorithm. You cannot use any library method, e.g. JDK or a third party library,
// which means, you need to first implement the quicksort algorithm and then sort
// the array.

import java.util.Arrays;

public class S_QuickSort {

  public static void main(String[] args) {
    int [] arr =  new int[] {32, 23, 45, 87, 92, 31, 19};

    quickSort(arr);
    System.out.println(Arrays.toString(arr));
    // output: [19, 23, 31, 32, 45, 87, 92]
  }

  static void quickSort(int [] arr) {
    if (arr.length <= 1) return;

    quickSort(arr, 0, arr.length - 1);
  }

  static void quickSort(int [] arr, int left, int right) {
    if (left >= right) return;

    int partition_index = partition(arr, left, right);

    quickSort(arr, left, partition_index - 1);
    quickSort(arr, partition_index + 1, right);
  }

  static int partition(int [] arr, int left, int right) {
    int pivot = arr[right];

    int i = left - 1;
    for (int j = left; j < right; j++) {
      if (arr[j] < pivot) {
        i++;
        if (i < j)
          swap(arr, i, j);
      }
    }

    i++;
    if (i < right)
      swap(arr, i, right);

    return i;
  }

  static void swap(int [] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

}
