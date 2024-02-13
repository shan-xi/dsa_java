package hackerrank.algorithms.count_luck;

import java.io.*;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Result {
    private static final int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private static int counted = 0;
    private static boolean[][] visited;

    public static String countLuck(List<String> matrix, int k) {
        int n = matrix.size();
        int m = matrix.get(0).length();
        visited = new boolean[n][m];
        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).charAt(j) == 'M') {
                    startX = i;
                    startY = j;
                } else if (matrix.get(i).charAt(j) == '*') {
                    endX = i;
                    endY = j;
                }
            }
        }
        dfs(matrix, startX, startY, endX, endY, count);

        if (counted == k) {
            return "Impressed";
        } else {
            return "Oops!";
        }
    }

    private static void dfs(List<String> matrix, int startX, int startY, int endX, int endY, int count) {
        if (startX == endX && startY == endY) {
            counted = count;
            return;
        }

        visited[startX][startY] = true;

        int numPath = 0;
        for (int[] dir : directions) {
            int newX = startX + dir[0];
            int newY = startY + dir[1];
            if (newX >= 0 && newX < matrix.size() && newY >= 0 && newY < matrix.get(0).length() && matrix.get(newX).charAt(newY) != 'X' && !visited[newX][newY]) {
                numPath++;
            }
        }

        if (numPath > 1) {
            count++;
        }

        for (int[] dir : directions) {
            int newX = startX + dir[0];
            int newY = startY + dir[1];
            if (newX >= 0 && newX < matrix.size() && newY >= 0 && newY < matrix.get(0).length() && matrix.get(newX).charAt(newY) != 'X' && !visited[newX][newY]) {
                numPath++;
                dfs(matrix, newX, newY, endX, endY, count);
            }
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                List<String> matrix = IntStream.range(0, n).mapToObj(i -> {
                            try {
                                return bufferedReader.readLine();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        })
                        .collect(toList());

                int k = Integer.parseInt(bufferedReader.readLine().trim());

                String result = Result.countLuck(matrix, k);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
