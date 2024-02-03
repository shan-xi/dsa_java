package TSMC;

/**
 * 這個題目是關於一個數字圖形工具中的“桶填充”工具的應用。在這個問題中，你需要使用這個工具來重新塗色一個由字母代表不同顏色的二維數組表示的圖片。
 * 桶填充工具可以一次性地填充相鄰的（水平或垂直相連，但不包括對角線相連）並且顏色相同的單元格。你需要找出最少需要多少次填充操作來完全重新塗色整個圖片。
 */
public class FloodFill {


    public static void main(String[] args) {
        int[][] map = {
                {1, 2, 2},
                {2, 2, 2},
                {2, 2, 3}
        };
        System.out.println(floodFillCount(map));
    }

    private static int floodFillCount(int[][] map) {
        var x = map.length;
        var y = map[0].length;
        var count = 0;
        var visited = new boolean[x][y];
        for (var i = 0; i < x; i++) {
            for (var j = 0; j < y; j++) {
                if (!visited[i][j]) {
                    int color = map[i][j];
                    fill(map, visited, i, j, color);
                    count++;
                }
            }
        }

        return count;
    }

    private static void fill(int[][] map, boolean[][] visited, int i, int j, int color) {
        if (i < 0 || j < 0 || i > map.length - 1 || j > map[0].length - 1) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        if (map[i][j] != color) {
            return;
        }
        visited[i][j] = true;
        fill(map, visited, i + 1, j, color);
        fill(map, visited, i, j + 1, color);
        fill(map, visited, i - 1, j, color);
        fill(map, visited, i, j - 1, color);
    }
}
