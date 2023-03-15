package number_of_enclaves;

import java.util.ArrayList;
import java.util.List;

// 1020. Number of Enclaves
// https://leetcode.com/problems/number-of-enclaves/?envType=study-plan&id=graph-i
public class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numEnclaves(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        // Mark all the connected land squares from the boundary as visited
        for (int i = 0; i < rows; i++) {
            if (A[i][0] == 1) {
                dfs(A, i, 0);
            }
            if (A[i][cols - 1] == 1) {
                dfs(A, i, cols - 1);
            }
        }
        for (int j = 0; j < cols; j++) {
            if (A[0][j] == 1) {
                dfs(A, 0, j);
            }
            if (A[rows - 1][j] == 1) {
                dfs(A, rows - 1, j);
            }
        }
        // Count the number of unvisited land squares in the grid
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (A[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    // DFS function to mark all the connected land squares as visited
    private void dfs(int[][] A, int i, int j) {
        A[i][j] = 0;
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (x >= 0 && x < A.length && y >= 0 && y < A[0].length && A[x][y] == 1) {
                dfs(A, x, y);
            }
        }
    }
//    public int numEnclaves(int[][] grid) {
//        int rows = grid.length;
//        int cols = grid[0].length;
//        List<int[]> lands = new ArrayList<>();
//        List<int[]> boundaries = new ArrayList<>();
//        int count = 0;
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (grid[i][j] == 1) {
//                    dfs(grid, i, j, rows, cols, lands, boundaries);
//                    if (boundaries.size() == 0) {
//                        count += lands.size();
//                    }
//                }
//                lands.clear();
//                boundaries.clear();
//            }
//        }
//        return count;
//    }
//
//    private void dfs(int[][] grid, int i, int j, int rows, int cols, List<int[]> lands, List<int[]> boundaries) {
//        if (grid[i][j] == 1) {
//            if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
//                boundaries.add(new int[]{i, j});
//            }
//        }
//        if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1 || grid[i][j] != 1) {
//            return;
//        }
//
//        lands.add(new int[]{i, j});
//        grid[i][j] = 0;
//        dfs(grid, i - 1, j, rows, cols, lands, boundaries);
//        dfs(grid, i + 1, j, rows, cols, lands, boundaries);
//        dfs(grid, i, j - 1, rows, cols, lands, boundaries);
//        dfs(grid, i, j + 1, rows, cols, lands, boundaries);
//    }
}
