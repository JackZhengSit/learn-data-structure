package com.jack.data_strature;

public class Heap {

  int[] a; // 存储数据
  int n; // 数据最大数
  int count; // 已存数据数

  public Heap(int capacity) {
    a = new int[capacity + 1];
    n = capacity;
    count = 0;
  }

  public void swap(int[] a, int i, int j) {
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

  void heapify() {}
}
