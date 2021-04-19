package com.jack.data_strature;

public class Heap {

  public static void main(String[] args) {
    int[] a = {7, 5, 19, 8, 4, 1, 20, 13, 16};
    Heap heap = new Heap(a);
    heap.printHeap();
    heap.removeMax();

    heap.printHeap();
    heap.sort();
    heap.printHeap();
  }

  int[] a; // 存储数据
  int n = 20; // 数据最大数
  int count = 0; // 已存数据数

  public Heap(int capacity) {
    a = new int[capacity + 1];
    n = capacity;
    count = 0;
  }

  public Heap(int[] a) {
    this.a = new int[a.length + 1];
    for (int i = 0; i < a.length; i++) {
      this.a[i + 1] = a[i];
    }
    this.count = a.length;
    buildHeap(this.a);
  }

  private void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public void insert(int data) {
    if (count >= n) return;
    count++;
    a[count] = data;
    int i = count;
    while (a[i / 2] < a[i] && i / 2 > 0) {
      swap(a, i, i / 2);
      i = i / 2;
    }
  }

  public void removeMax() {
    if (count == 0) return;
    a[1] = a[count];
    --count;
    heapify(a, count, 1);
  }

  private void heapify(int[] a, int n, int i) {
    while (true) {
      int maxChild = i;
      if (2 * i <= n && a[i] < a[2 * i]) maxChild = 2 * i;
      if (2 * i + 1 <= n && a[maxChild] < a[2 * i + 1]) maxChild = 2 * i + 1;
      if (maxChild == i) break;
      swap(a, i, maxChild);
      i = maxChild;
    }
  }

  private void buildHeap(int[] a) {
    for (int i = count / 2; i >= 1; i--) {
      heapify(a, count, i);
    }
  }

  public void sort() {
    int k = count;
    while (k > 1) {
      swap(a, 1, k);
      k--;
      heapify(a, k, 1);
    }
  }

  void printHeap() {
    for (int i = 1; i <= count; i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println();
  }
}
