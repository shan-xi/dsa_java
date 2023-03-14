package max_area_of_island;

import java.util.ArrayList;
import java.util.List;

//695. Max Area of Island
//https://leetcode.com/problems/max-area-of-island/?envType=study-plan&id=graph-i
public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxAreaCount = 0;
        List<int[]> records = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, records);
                    if (records.size() > maxAreaCount) {
                        maxAreaCount = records.size();
                    }
                    records.clear();
                }
            }
        }

        return maxAreaCount;
    }

    private void dfs(int[][] grid, int i, int j, List<int[]> records) {
        records.add(new int[]{i, j});
        grid[i][j] = 0;
        if (i - 1 >= 0 && grid[i - 1][j] == 1)
            dfs(grid, i - 1, j, records);
        if (i + 1 < grid.length && grid[i + 1][j] == 1)
            dfs(grid, i + 1, j, records);
        if (j - 1 >= 0 && grid[i][j - 1] == 1)
            dfs(grid, i, j - 1, records);
        if (j + 1 < grid[0].length && grid[i][j + 1] == 1)
            dfs(grid, i, j + 1, records);
    }


}
