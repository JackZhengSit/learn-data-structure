package com.jack.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution23 {
  public static void main(String[] args) {
    Solution23 s = new Solution23();
    int[][] input = {{1, 4, 5}, {1, 3, 4}, {2, 6}};
    //    int[][] input = {{1}, {0}};
    ListNode[] lists = s.buildInput(input);
    ListNode output = s.mergeKLists1(lists);
    while (output != null) {
      System.out.println(output.val + " ");
      output = output.next;
    }
  }

  public ListNode mergeKLists1(ListNode[] lists) {
    ListNode h = new ListNode();
    ListNode p = h;

    Queue<ListNode> queue =
        new PriorityQueue<>(
            lists.length,
            new Comparator<ListNode>() {
              @Override
              public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
              }
            });
    int emptyCount = 0;

    for (int i = 0; i < lists.length; i++) {
      if (lists[i] == null) {
        emptyCount++;
      } else {
        queue.add(lists[i]);
      }
    }
    while (emptyCount < lists.length) {
      ListNode minNode = queue.poll();
      p.next = minNode;
      p = p.next;
      if (minNode.next == null) emptyCount++;
      else queue.add(minNode.next);
    }

    return h.next;
  }

  private ListNode[] buildInput(int[][] a) {
    ListNode[] nodes = new ListNode[a.length];
    for (int i = 0; i < a.length; i++) {
      nodes[i] = new ListNode();
      ListNode p = nodes[i];
      for (int j = 0; j < a[i].length; j++) {
        p.next = new ListNode(a[i][j]);
        p = p.next;
      }
      nodes[i] = nodes[i].next;
    }
    return nodes;
  }

  public ListNode mergeKLists(ListNode[] lists) {

    // define the max heap size
    int maxLength = 0;
    for (int i = 0; i < lists.length; i++) {
      int len = 0;
      ListNode p = lists[i];
      while (p != null) {
        len++;
        p = p.next;
      }
      maxLength = Math.max(maxLength, len);
    }

    int heapSize = maxLength > lists.length ? maxLength + 1 : lists.length + 1;
    ListNode[] heap = new ListNode[heapSize]; // user heap store element which is minium in list
    int n = heapSize; // heap max size
    int count = 0; // heap size
    ListNode h = new ListNode(); // return list
    ListNode p = h;

    int emptyCount = 0;

    for (int i = 0; i < lists.length; i++) {
      if (lists[i] == null) {
        emptyCount++;
      } else {
        ListNode node = lists[i];
        insert(heap, ++count, node);
      }
    }

    while (emptyCount < lists.length) {

      ListNode minNode = deleteMin(heap, count);
      count--;
      p.next = new ListNode(minNode.val);
      p = p.next;
      if (minNode.next == null) emptyCount++;
      else insert(heap, ++count, minNode.next);
    }

    return h.next;
  }

  // insert a data in heap a at index i
  private void insert(ListNode[] a, int i, ListNode node) {
    a[i] = node;
    while (i / 2 > 0 && a[i].val < a[i / 2].val) { // min heap
      swap(a, i, i / 2);
      i = i / 2;
    }
  }

  // delete top of the heap
  private ListNode deleteMin(ListNode[] a, int count) {
    ListNode r = a[1];
    a[1] = a[count];
    heapify(a, --count, 1);
    return r;
  }

  // heapify the heap
  private void heapify(ListNode[] a, int count, int i) {
    while (true) {
      int minChild = i;
      if (2 * i <= count && a[i].val > a[2 * i].val) minChild = 2 * i;
      if (2 * i + 1 <= count && a[minChild].val > a[2 * i + 1].val) minChild = 2 * i + 1;
      if (minChild == i) break;
      swap(a, minChild, i);
      i = minChild;
    }
  }

  private void swap(ListNode[] a, int i, int j) {
    ListNode temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}

class ListNode {
  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}
