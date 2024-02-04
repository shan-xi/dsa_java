package hackerrank.datastructure.castleonthegrid;

import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'minimumMoves' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. List<String> grid
     *  2. INTEGER startX
     *  3. INTEGER startY
     *  4. INTEGER goalX
     *  5. INTEGER goalY
     */

    public static int minimumMoves(List<String> grid, int startX, int startY, int goalX, int goalY) {
        int n = grid.size();
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = grid.get(i).toCharArray();
        }

        int[][] distances = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distances[i], -1);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        distances[startX][startY] = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = x + 1; i < n && map[i][y] == '.'; i++) {
                if (distances[i][y] == -1) {
                    distances[i][y] = distances[x][y] + 1;
                    queue.offer(new int[]{i, y});
                }
            }
            for (int i = x - 1; i >= 0 && map[i][y] == '.'; i--) {
                if (distances[i][y] == -1) {
                    distances[i][y] = distances[x][y] + 1;
                    queue.offer(new int[]{i, y});
                }
            }
            for (int j = y + 1; j < n && map[x][j] == '.'; j++) {
                if (distances[x][j] == -1) {
                    distances[x][j] = distances[x][y] + 1;
                    queue.offer(new int[]{x, j});
                }
            }
            for (int j = y - 1; j >= 0 && map[x][j] == '.'; j--) {
                if (distances[x][j] == -1) {
                    distances[x][j] = distances[x][y] + 1;
                    queue.offer(new int[]{x, j});
                }
            }
        }

        return distances[goalX][goalY];

    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            grid.add(bufferedReader.readLine());
        }

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int startX = Integer.parseInt(firstMultipleInput[0]);

        int startY = Integer.parseInt(firstMultipleInput[1]);

        int goalX = Integer.parseInt(firstMultipleInput[2]);

        int goalY = Integer.parseInt(firstMultipleInput[3]);

        int result = Result.minimumMoves(grid, startX, startY, goalX, goalY);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
