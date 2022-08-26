// merge sort implementations

import java.util.Arrays;

public class S_MergeSort {

  public static void main(String[] args) {
    int [] arr =  new int[] {32, 23, 87, 45, 92, 16, 31, 19};
    int [] arr2 = arr.clone();

    mergeSort(arr);
    System.out.println(Arrays.toString(arr));
    // output: [16, 19, 23, 31, 32, 45, 87, 92]

    mergeSort2(arr2);
    System.out.println(Arrays.toString(arr2));
    // output: [16, 19, 23, 31, 32, 45, 87, 92]
  }

  // solution 1
  static void mergeSort (int [] arr) {
    int n = arr.length;
    if (n < 2) return;

    int mid = n / 2;

    int [] arr_l = Arrays.copyOfRange(arr, 0, mid);
    int [] arr_r = Arrays.copyOfRange(arr, mid, n);

    mergeSort (arr_l);
    mergeSort(arr_r);
    merge(arr, arr_l, arr_r);
  }

  static void merge(int [] arr, int [] arr_l, int [] arr_r) {
    int l = 0, r = 0, k = 0;

    while (l < arr_l.length && r < arr_r.length) {
      if (arr_l[l] <= arr_r[r]) {
        arr[k] = arr_l[l];
        l++;
      } else {
        arr[k] = arr_r[r];
        r++;
      }
      k++;
    }

    while (l < arr_l.length) {
      arr[k] = arr_l[l];
      l++;
      k++;
    }

    while (r < arr_r.length) {
      arr[k] = arr_r[r];
      r++;
      k++;
    }
  }

  // solution 2
  static void mergeSort2(int [] arr) {
    if (arr.length <= 1) return;

    mergeSort2(arr, 0, arr.length - 1);
  }

  static void mergeSort2(int [] arr, int l, int r) {
    if (l >= r) return;

    int mid = (l + r) / 2;

    mergeSort2(arr, l, mid);
    mergeSort2(arr, mid + 1, r);
    merge2(arr, l, mid, r);
  }

  static void merge2 (int [] arr, int l, int mid, int r) {
    int [] t1 = Arrays.copyOfRange(arr, l, mid + 1);
    int [] t2 = Arrays.copyOfRange(arr, mid + 1, r + 1);

    int len1 = t1.length;
    int len2 = t2.length;

    int i = 0, j = 0, k = l;
    while (i < len1 && j < len2) {
      if (t1[i] <= t2[j]) {
        arr[k] = t1[i];
        i++;
      } else {
        arr[k] = t2[j];
        j++;
      }
      k++;
    }

    while (i < len1) {
      arr[k] = t1[i];
      i++;
      k++;
    }

    while (j < len2) {
      arr[k] = t2[j];
      k++;
      j++;
    }
  }

}