package com.jack.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Solution827 {
  public static void main(String[] args) {
    int[][] a = {{1, 0}, {0, 1}};
    Solution827 s = new Solution827();
    System.out.println(s.largestIsland(a));
  }

  //  public int largestIsland(int[][] grid) {
  //
  //    if (grid.length == 0) return 0;
  //
  //    int maxIsland = 0;
  //
  //    int gridSize = grid.length * grid[0].length;
  //    int seaSize = 0;
  //
  //    for (int r = 0; r < grid.length; r++) {
  //      for (int c = 0; c < grid[0].length; c++) {
  //        if (grid[r][c] == 0) {
  //          grid[r][c] = 1;
  //          maxIsland = Math.max(maxIsland, maxIsland(grid));
  //          grid[r][c] = 0;
  //        } else {
  //          gridSize++;
  //        }
  //      }
  //    }
  //    if (seaSize == gridSize) {
  //      maxIsland = gridSize;
  //    }
  //
  //    return maxIsland;
  //  }
  //
  //  private int maxIsland(int grid[][]) {
  //    int max = 0;
  //    for (int r = 0; r < grid.length; r++) {
  //      for (int c = 0; c < grid[0].length; c++) {
  //        if (grid[r][c] == 1) {
  //          max = Math.max(max, dfs(r, c, grid));
  //        }
  //      }
  //    }
  //    resetGrid(grid);
  //    return max;
  //  }
  //
  //  private void resetGrid(int[][] grid) {
  //    for (int r = 0; r < grid.length; r++) {
  //      for (int c = 0; c < grid[0].length; c++) {
  //        if (grid[r][c] == 2) {
  //          grid[r][c] = 1;
  //        }
  //      }
  //    }
  //  }
  //
  //  private int dfs(int r, int c, int[][] grid) {
  //    if (!isInGrid(r, c, grid)) {
  //      return 0;
  //    }
  //    if (grid[r][c] != 1) {
  //      return 0;
  //    } else {
  //      grid[r][c] = 2;
  //      return dfs(r - 1, c, grid)
  //          + dfs(r + 1, c, grid)
  //          + dfs(r, c - 1, grid)
  //          + dfs(r, c + 1, grid)
  //          + 1;
  //    }
  //  }
  //
  //  private boolean isInGrid(int r, int c, int[][] grid) {
  //    return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
  //  }

  public int largestIsland(int[][] grid) {

    if (grid.length == 0) return 0;

    LinkedList<Integer> islands = new LinkedList<>(); // every island's size
    islands.add(0);
    islands.add(0);

    computeEveryIslandSize(grid, islands);

    int seaSize = 0;

    int largestIsland = 0;
    // iterate '0' find the max island which is mergeed by 0->1
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[0].length; c++) {
        if (grid[r][c] == 0) {
          int isl = linkedIslandSize(r, c, grid, islands);
          largestIsland = Math.max(largestIsland, isl);
        } else {
          seaSize++;
        }
      }
    }

    if (seaSize == grid.length * grid[0].length) largestIsland = grid.length * grid[0].length;

    return largestIsland;
  }

  private int linkedIslandSize(int r, int c, int[][] grid, LinkedList<Integer> islands) {

    // store linked islands index
    Set<Integer> set = new HashSet<>();

    int linkedIslandSize = 1;

    // grid[r][c]' up
    if (isInGrid(r - 1, c, grid) && grid[r - 1][c] >= 2) {
      set.add(grid[r - 1][c]);
    }

    // down
    if (isInGrid(r + 1, c, grid) && grid[r + 1][c] >= 2) {
      set.add(grid[r + 1][c]);
    }

    // left
    if (isInGrid(r, c - 1, grid) && grid[r][c - 1] >= 2) {
      set.add(grid[r][c - 1]);
    }

    // right
    if (isInGrid(r, c + 1, grid) && grid[r][c + 1] >= 2) {
      set.add(grid[r][c + 1]);
    }

    for (int i : set) {
      linkedIslandSize += islands.get(i);
    }

    return linkedIslandSize;
  }

  private void computeEveryIslandSize(int[][] grid, LinkedList<Integer> islands) {
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[0].length; c++) {
        if (grid[r][c] == 1) {
          int island = dfs(r, c, grid, islands.size());
          islands.add(island);
        }
      }
    }
  }

  private int dfs(int r, int c, int[][] grid, int islandSizeIndex) {
    if (!isInGrid(r, c, grid)) {
      return 0;
    }
    if (grid[r][c] != 1) {
      return 0;
    } else {
      grid[r][c] = islandSizeIndex;
      return dfs(r - 1, c, grid, islandSizeIndex)
          + dfs(r + 1, c, grid, islandSizeIndex)
          + dfs(r, c - 1, grid, islandSizeIndex)
          + dfs(r, c + 1, grid, islandSizeIndex)
          + 1;
    }
  }

  private boolean isInGrid(int r, int c, int[][] grid) {
    return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
  }
}
