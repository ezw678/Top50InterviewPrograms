// binary search

import java.util.Arrays;

public class BinarySearch {

  public static void main(String[] args) {
    int [] arr = {1, 2, 11, 5, 18};
    int [] arr2 = arr.clone();
    int n = 5;

    System.out.println(binarySearch(arr, n));
    System.out.println(binarySearch2(arr2, n));
    // output: 2
  }

  static int binarySearch (int [] arr, int target) {
    int len = arr.length;

    Arrays.sort(arr);

    int l = 0;
    int r = len - 1;
    while (l <= r) {
      int mid = (l + r) / 2;

      if (target == arr[mid])
        return mid;
      else if (target < arr[mid]) {
        r = mid - 1;
      } else if (target > arr[mid]) {
        l = mid + 1;
      }
    }

    return -1;
  }

  static int binarySearch2 (int [] arr, int target) {
    int len = arr.length;
    if (len == 0) return -1;

    Arrays.sort(arr);

    return binarySearch2(arr, target, 0, len - 1);
  }

  static int binarySearch2 (int [] arr, int target, int left, int right) {
    if (left > right) return -1;

    int mid = (left + right) / 2;
    if (target == arr[mid])
      return mid;
    else if (target < arr[mid]) {
      return binarySearch2(arr, target, left, mid - 1);
    } else if (target > arr[mid]) {
      return binarySearch2(arr, target, mid + 1, right);
    }

    return -1;
  }

}
