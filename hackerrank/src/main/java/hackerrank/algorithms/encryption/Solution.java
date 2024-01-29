package hackerrank.algorithms.encryption;

import java.io.*;

class Result {

    /*
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
        s = s.replaceAll("\\s+", "");
        int len = s.length();
        int rows = (int) Math.floor(Math.sqrt(len));
        int columns = (int) Math.ceil(Math.sqrt(len));
        if (rows * columns < len) {
            rows++;
        }
        char[][] grid = new char[rows][columns];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (index < len) {
                    grid[i][j] = s.charAt(index++);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < columns; j++) {
            for (int i = 0; i < rows; i++) {
                if (grid[i][j] != 0) {
                    sb.append(grid[i][j]);
                }
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
