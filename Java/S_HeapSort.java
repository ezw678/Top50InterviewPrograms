// Heap sor implementation

import java.util.Arrays;

public class S_HeapSort {

  public static void main(String[] args) {
    int [] arr =  new int[] {32, 23, 45, 87, 92, 31, 19};

    heapSort(arr);
    System.out.println(Arrays.toString(arr));
    // output: [19, 23, 31, 32, 45, 87, 92]
  }

  static void heapSort(int [] arr) {
    int n = arr.length;
    if (n <= 1) return;

    for (int i = n / 2 - 1; i >= 0; i--) {
      heapify(arr, n, i);
    }

    for (int i = n - 1; i >= 0; i--) {
      int temp = arr[i];
      arr[i] = arr[0];
      arr[0] = temp;

      heapify(arr, i, 0);
    }
  }

  static void heapify(int [] arr, int n, int i) {
    int max = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;

    if (l < n && arr[l] > arr[max])
      max = l;

    if (r < n && arr[r] > arr[max])
      max = r;

    if (max != i) {
      int temp = arr[i];
      arr[i] = arr[max];
      arr[max] = temp;

      heapify(arr, n, max);
    }
  }

}
