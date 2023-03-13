package number_of_islands;

//200. Number of Islands
//https://leetcode.com/problems/number-of-islands/description/?envType=study-plan&id=graph-i
public class Solution {
    public int numIsLands(char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, rows, columns);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c, int rows, int columns) {
        grid[r][c] = '0';
        if (r < rows - 1 && grid[r + 1][c] == '1')
            dfs(grid, r + 1, c, rows, columns);
        if (c < columns - 1 && grid[r][c + 1] == '1')
            dfs(grid, r, c + 1, rows, columns);
        if (r - 1 >= 0 && grid[r - 1][c] == '1')
            dfs(grid, r - 1, c, rows, columns);
        if (c - 1 >= 0 && grid[r][c - 1] == '1')
            dfs(grid, r, c - 1, rows, columns);
    }
}
