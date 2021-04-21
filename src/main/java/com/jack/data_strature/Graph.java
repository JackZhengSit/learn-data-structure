package com.jack.data_strature;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
  public static void main(String[] args) {
    Graph graph = new Graph(8);
    graph.addEdge(0, 1);
    graph.addEdge(0, 3);
    graph.addEdge(1, 2);
    graph.addEdge(1, 4);
    graph.addEdge(2, 5);
    graph.addEdge(3, 4);
    graph.addEdge(4, 5);
    graph.addEdge(4, 6);
    graph.addEdge(5, 7);
    graph.addEdge(6, 7);
    graph.bfs(0, 7);
    System.out.println();
    graph.dfs(0, 3);
  }

  private int v; // 顶点的个数
  private LinkedList<Integer>[] adj; // 邻接表

  public Graph(int v) {
    this.v = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; i++) {
      adj[i] = new LinkedList<>();
    }
  }

  public void addEdge(int s, int t) { // 无向图加边
    adj[s].add(t);
    adj[t].add(s);
  }

  public void bfs(int s, int t) {
    boolean[] visited = new boolean[v];
    int[] pre = new int[v];
    Queue<Integer> queue = new LinkedList<>();

    for (int i = 0; i < v; i++) {
      pre[i] = -1;
      visited[i] = false;
    }

    visited[s] = true;
    queue.add(s);
    while (!queue.isEmpty()) {
      int w = queue.poll();
      for (int i = 0; i < adj[w].size(); i++) {
        int p = adj[w].get(i);
        if (!visited[p]) {
          pre[p] = w;
          if (p == t) {
            print(pre, s, t);
            return;
          }
          visited[p] = true;
          queue.add(p);
        }
      }
    }
  }

  private void print(int[] pre, int s, int t) {
    if (pre[t] != -1 && s != t) {
      print(pre, s, pre[t]);
    }
    System.out.print(t + " ");
  }

  boolean found = false;

  public void dfs(int s, int t) {
    found = false;
    int[] pre = new int[v];
    boolean[] visited = new boolean[v];
    for (int i = 0; i < v; i++) {
      pre[i] = -1;
      visited[i] = false;
    }
    recurDfs(s, t, pre, visited);
    print(pre, s, t);
  }

  private void recurDfs(int w, int t, int[] pre, boolean[] visited) {
    if (found) return;
    visited[w] = true;
    if (w == t) {
      found = true;
      return;
    }
    for (int i = 0; i < adj[w].size(); i++) {
      int p = adj[w].get(i);
      if (!visited[p]) {
        pre[p] = w;
        recurDfs(p, t, pre, visited);
      }
    }
  }
}
