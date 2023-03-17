package count_sub_islands;

// 1905. Count Sub Islands
// https://leetcode.com/problems/count-sub-islands/?envType=study-plan&id=graph-i
public class Solution {
    private class Validation {
        boolean isValid = true;
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int rows = grid1.length;
        int cols = grid1[0].length;
        int count = 0;
        Validation v = new Validation();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid2[i][j] == 1) {
                    v.isValid = true;
                    dfs(grid1, grid2, rows, cols, i, j, v);
                    if (v.isValid)
                        count++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] grid1, int[][] grid2, int rows, int cols, int i, int j, Validation valid) {
        if (grid1[i][j] != grid2[i][j]) {
            grid2[i][j] = 0;
            valid.isValid = false;
        }
        grid2[i][j] = 0;
        if (i - 1 >= 0 && grid2[i - 1][j] == 1)
            dfs(grid1, grid2, rows, cols, i - 1, j, valid);
        if (i + 1 < rows && grid2[i + 1][j] == 1)
            dfs(grid1, grid2, rows, cols, i + 1, j, valid);
        if (j - 1 >= 0 && grid2[i][j - 1] == 1)
            dfs(grid1, grid2, rows, cols, i, j - 1, valid);
        if (j + 1 < cols && grid2[i][j + 1] == 1)
            dfs(grid1, grid2, rows, cols, i, j + 1, valid);
    }

}
