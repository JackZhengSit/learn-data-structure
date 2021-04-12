package com.jack.data_strature;

public class Bsearch {

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5, 6, 8, 8, 8, 11, 18};
    //    QuickSort.quickSort(a, a.length);
    System.out.println(bSearch(a, a.length, 8));
  }

  static int bSearch(int[] a, int n, int val) {
    //    return bSearchC(a, 0, n - 1, val);
    //    return bSearchRecurrent(a, 0, n - 1, val);
    //    return bSearchFirst(a, 0, n - 1, val);
    return bSearchLast(a, 0, n - 1, val);
  }

  static int bSearchC(int[] a, int low, int high, int val) {

    while (low <= high) {
      //      int mid = (low + high) / 2;
      int mid = low + ((high - low) >> 1);
      if (a[mid] == val) return mid;
      if (a[mid] > val) high = mid - 1;
      if (a[mid] < val) low = mid + 1;
    }
    return -1;
  }

  static int bSearchRecurrent(int[] a, int low, int high, int val) {
    if (low > high) return -1;
    int mid = low + ((high - low) >> 1);
    if (a[mid] == val) return mid;
    else if (a[mid] < val) return bSearchRecurrent(a, mid + 1, high, val);
    else return bSearchRecurrent(a, low, mid - 1, val);
  }

  static int bSearchFirst(int[] a, int low, int high, int val) {

    while (low <= high) {
      int mid = low + ((high - low) >> 1);
      if (a[mid] < val) low = mid + 1;
      else if (a[mid] > val) high = mid - 1;
      else {
        if (mid == 0 || a[mid - 1] != val) return mid;
        else high = mid - 1;
      }
    }
    return -1;
  }

  static int bSearchLast(int[] a, int low, int high, int val) {
    while (low <= high) {
      int mid = low + ((high - low) >> 2);
      if (a[mid] < val) low = mid + 1;
      else if (a[mid] > val) high = mid - 1;
      else {
        if (mid == a.length - 1 || a[mid + 1] != val) return mid;
        else low = mid + 1;
      }
    }
    return -1;
  }
}
