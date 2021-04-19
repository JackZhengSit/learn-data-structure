package com.jack.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution102 {
  public static void main(String[] args) {}

  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) return new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
    deque.add(root);
    while (!deque.isEmpty()) {
      int n = deque.size();
      List<Integer> list = new ArrayList<Integer>();
      for (int i = 0; i < n; i++) {
        TreeNode node = deque.poll();
        list.add(node.val);
        if (node.left != null) {
          deque.add(node.left);
        }
        if (node.right != null) {
          deque.add(node.right);
        }
      }
      res.add(list);
    }

    return res;
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {}

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
