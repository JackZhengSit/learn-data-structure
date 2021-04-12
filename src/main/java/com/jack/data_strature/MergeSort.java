package com.jack.data_strature;

public class MergeSort {
  public static void main(String[] args) {
    int[] A = {1, 5, 6, 2, 3, 4, 10, 1, 2};

    mergeSort(A, A.length);
    for (int i = 0; i < A.length; i++) {
      System.out.println(A[i]);
    }
  }

  static void mergeSort(int[] A, int n) {
    mergeSortC(A, 0, n - 1);
  }

  static void mergeSortC(int[] A, int p, int r) {
    // 结束条件
    if (p >= r) return;

    int q = (p + r) / 2;

    // 递归过程
    mergeSortC(A, p, q);
    mergeSortC(A, q + 1, r);

    merge(A, p, q, r);
  }

  static void merge(int[] A, int p, int q, int r) {

    if (p == r) return;

    // 比较A[p,q]与A[q+1,r]两个数组中谁小，谁依次放在B中
    int[] B = new int[r - p + 1];
    int i = p, j = q + 1, k = 0;
    while (i <= q && j <= r) {
      if (A[i] <= A[j]) {
        B[k++] = A[i++];
      } else {
        B[k++] = A[j++];
      }
    }

    // 判断哪个数组中有剩余
    int start = i, end = q;
    if (j <= r) {
      start = j;
      end = r;
    }

    // 将剩下的放入B中
    while (start <= end) {
      B[k++] = A[start++];
    }

    // 将B中的有序值放回A
    for (int i1 = 0; i1 <= r - p; i1++) {
      A[p + i1] = B[i1];
    }
  }
}
