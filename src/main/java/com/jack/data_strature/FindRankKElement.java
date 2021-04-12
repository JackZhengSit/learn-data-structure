package com.jack.data_strature;

public class FindRankKElement {

  public static void main(String[] args) {
    int[] A = {3, 2, 9, 4, 7, 8, 1, 5, 5, 6};
    int k = 6;
    quickFind(A, A.length, k);
    System.out.println(A[k - 1]);
  }

  static void quickFind(int[] A, int n, int k) {
    quickFindC(A, 0, n - 1, k);
  }

  static void quickFindC(int[] A, int p, int r, int k) {
    if (p >= r || p + 1 == k) return;

    int q = partial(A, p, r);
    if (q + 1 == k) return;
    if (q + 1 > k) quickFindC(A, p, q - 1, k);
    if (q + 1 < k) quickFindC(A, q + 1, r, k);
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
