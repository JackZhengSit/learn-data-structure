package com.jack.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution973 {
  public int[][] kClosest(int[][] points, int k) {
    int[][] re = new int[k][];
    Queue<int[]> queue =
        new PriorityQueue<>(
            points.length,
            new Comparator<int[]>() {
              @Override
              public int compare(int[] a, int[] b) {
                return (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]);
              }
            });
    for (int i = 0; i < points.length; i++) {
      queue.add(points[i]);
    }
    for (int i = 0; i < k; i++) {
      int[] point = queue.poll();
      re[i] = point;
    }
    return re;
  }
}
