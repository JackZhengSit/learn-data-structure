package com.jack.data_strature;

import java.util.Arrays;

public class QuickSort {

  public static void main(String[] args) {
    int[] A = {6, 11, 3, 9, 8, 5, 4, 2, 5};
    quickSort(A, A.length);
    Arrays.stream(A).forEach(System.out::println);
  }

  static void quickSort(int[] A, int n) {
    quickSortC(A, 0, n - 1);
  }

  static void quickSortC(int[] A, int p, int r) {
    if (p >= r) return;

    int q = partial(A, p, r);
    quickSortC(A, p, q - 1);
    quickSortC(A, q + 1, r);
  }

  static int partial(int[] A, int p, int r) {
    int pivot = A[r];
    int i = p;
    for (int j = p; j <= r; j++) {
      if (pivot > A[j]) {
        swap(A, i, j);
        i++;
      }
    }
    swap(A, i, r);
    return i;
  }

  static void swap(int[] A, int i, int j) {
    int temp = A[j];
    A[j] = A[i];
    A[i] = temp;
  }
}
