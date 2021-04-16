package com.jack.data_strature;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinaryTree {
  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    tree.buildATree();
    //    preOderPrint(tree.root);
    //    System.out.println("==============");
    //    inOderPrint(tree.root);
    //    System.out.println("==============");
    //    postOrderPrint(tree.root);
    //    System.out.println("==============");
    //    levelOrderPrint(tree.root);

    //    System.out.println(tree.find(7).data);

    //    int[] arr = {7, 8, 9, 1, 2, 6, 5, 4, 3, 3, 3};
    //    for (int i = 0; i < arr.length; i++) {
    //      tree.insert(arr[i]);
    //    }
    inOderPrint(tree.root);
    System.out.println("==============");
    System.out.println(getPre(tree.root, new TreeNode(5)).data);
  }

  public TreeNode root;

  public void insert() {}

  // 构建树
  void buildATree() {
    TreeNode root = new TreeNode(6);
    root.left = new TreeNode(4);
    root.right = new TreeNode(8);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(7);
    root.right.right = new TreeNode(9);
    root.left.left.left = new TreeNode(1);
    root.left.left.right = new TreeNode(3);
    this.root = root;
  }

  static void preOderPrint(TreeNode root) {
    if (root == null) return;
    System.out.println(root.data);
    preOderPrint(root.left);
    preOderPrint(root.right);
  }

  static void inOderPrint(TreeNode root) {
    if (root == null) return;
    inOderPrint(root.left);
    System.out.println(root.data);
    inOderPrint(root.right);
  }

  static void postOrderPrint(TreeNode root) {
    if (root == null) return;
    postOrderPrint(root.left);
    postOrderPrint(root.right);
    System.out.println(root.data);
  }

  static void levelOrderPrint(TreeNode root) {
    Deque<TreeNode> deque = new ArrayDeque<>();
    deque.add(root);
    while (!deque.isEmpty()) {
      TreeNode node = deque.poll();
      System.out.println(node.data);
      if (node.left != null) deque.add(node.left);
      if (node.right != null) deque.add(node.right);
    }
  }

  public TreeNode find(int data) {
    TreeNode p = this.root;
    while (p != null) {
      if (data < p.data) {
        p = p.left;
      }
      if (data > p.data) {
        p = p.right;
      }
      if (data == p.data) {
        return p;
      }
    }
    return null;
  }

  public static TreeNode getMax(TreeNode p) {
    while (p != null) {
      if (p.right != null) {
        p = p.right;
      } else {
        return p;
      }
    }
    return p;
  }

  public static TreeNode getMin(TreeNode p) {
    while (p != null) {
      if (p.left != null) {
        p = p.left;
      } else {
        return p;
      }
    }
    return p;
  }

  public static TreeNode getPre(TreeNode p, TreeNode target) {
    TreeNode f = null;
    while (p != null) {
      if (target.data == p.data) return f;
      f = p;
      if (target.data < p.data) p = p.left;
      if (target.data > p.data) p = p.right;
    }
    return f;
  }

  public void insert(int data) {
    if (this.root == null) {
      this.root = new TreeNode(data);
      return;
    }

    TreeNode p = this.root;
    while (p != null) {
      if (data < p.data) {
        if (p.left == null) {
          p.left = new TreeNode(data);
          return;
        }
        p = p.left;
      } else {
        if (p.right == null) {
          p.right = new TreeNode(data);
          return;
        }
        p = p.right;
      }
    }
  }

  public void delete(int data) {
    TreeNode p = this.root; // 需要删除的节点
    TreeNode f = null; // 需要删除节点的父节点

    while (p != null) {
      if (data < p.data) {
        p = p.left;
      }
      if (data > p.data) {
        p = p.right;
      }
      if (data == p.data) {
        // 第一种情况
        // 要删除的节点没有子节点
        // 直接将要删除节点的父节点种的指针置为null
        if (p.left == null && p.right == null) {
          if (f.left == p) {
            f.left = null;
          } else {
            f.right = null;
          }
        }
        // 第二种情况
        // 要删除的节点有一个子节点
        // 将父节点指向该节点的指针指向该节点的这个子节点
        if (p.left != null && p.right == null) {
          if (f.left == p) {
            f.left = p.left;
          } else {
            f.right = p.left;
          }
        }
        if (p.right != null && p.left == null) {
          if (f.left == p) {
            f.left = p.right;
          } else {
            f.right = p.right;
          }
        }
        // 第三种情况
        // 要删除的节点有两个节点
        // 找到左子节点中的最大节点，用它替换该节点，然后删除最大节点
        // 或者找到右子节点的最小节点，用它替换该节点，然后删除最小节点
        if (p.left != null && p.right != null) {
          TreeNode maxp = p; // 需要删除的最大节点
          TreeNode maxf = null; // 最大节点的父节点
          //            while()

          p.data = maxp.data;
        }
      }

      f = p;
    }
  }

  public static class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
      this.data = data;
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }
}
