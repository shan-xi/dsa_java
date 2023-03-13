package flood_fill;

import java.util.ArrayDeque;
import java.util.Queue;

//733. Flood Fill
//https://leetcode.com/problems/flood-fill/?envType=study-plan&id=graph-i
public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length;
        int cols = image[0].length;
        if (image[sr][sc] == color) {
            return image;
        }
        dfs(image, sr, sc, rows, cols, image[sr][sc], color);
        return image;
    }

    private void dfs(int[][] image, int row, int col, int rows, int cols, int originalColor, int newColor) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || image[row][col] != originalColor) {
            return;
        }
        image[row][col] = newColor;
        dfs(image, row - 1, col, rows, cols, originalColor, newColor);
        dfs(image, row + 1, col, rows, cols, originalColor, newColor);
        dfs(image, row, col - 1, rows, cols, originalColor, newColor);
        dfs(image, row, col + 1, rows, cols, originalColor, newColor);
    }


//    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//        if (image[sr][sc] == color) {
//            return image;
//        }
//        Queue<int[]> q = new ArrayDeque<>();
//        q.offer(new int[]{sr, sc});
//        int originColor = image[sr][sc];
//        while (q.size() > 0) {
//            int[] pos = q.poll();
//            image[pos[0]][pos[1]] = color;
//
//            if (pos[0] - 1 >= 0 && image[pos[0] - 1][pos[1]] == originColor) {
//                q.offer(new int[]{pos[0] - 1, pos[1]});
//            }
//            if (pos[0] + 1 < image.length && image[pos[0] + 1][pos[1]] == originColor) {
//                q.offer(new int[]{pos[0] + 1, pos[1]});
//            }
//            if (pos[1] - 1 >= 0 && image[pos[0]][pos[1] - 1] == originColor) {
//                q.offer(new int[]{pos[0], pos[1] - 1});
//            }
//            if (pos[1] + 1 < image[0].length && image[pos[0]][pos[1] + 1] == originColor) {
//                q.offer(new int[]{pos[0], pos[1] + 1});
//            }
//        }
//
//        return image;
//    }
}
