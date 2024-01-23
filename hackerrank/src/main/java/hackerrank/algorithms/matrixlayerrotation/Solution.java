package hackerrank.algorithms.matrixlayerrotation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Result {

    /*
     * Complete the 'matrixRotation' function below.
     *
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY matrix
     *  2. INTEGER r
     */

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();

        int minLayers = Math.min(m, n) / 2;

        for (int layer = 0; layer < minLayers; layer++) {
            List<Integer> values = new ArrayList<>();

            // Extract the top row
            for (int i = layer; i < n - layer; i++) {
                values.add(matrix.get(layer).get(i));
            }

            // Extract the right column
            for (int i = layer + 1; i < m - layer; i++) {
                values.add(matrix.get(i).get(n - layer - 1));
            }

            // Extract the bottom row
            for (int i = n - layer - 2; i >= layer; i--) {
                values.add(matrix.get(m - layer - 1).get(i));
            }

            // Extract the left column
            for (int i = m - layer - 2; i > layer; i--) {
                values.add(matrix.get(i).get(layer));
            }

            // Perform rotation on the values
            int rotation = r % values.size();
            Collections.rotate(values, values.size() - rotation);

            // Update the matrix with the rotated values
            int index = 0;

            // Update the top row
            for (int i = layer; i < n - layer; i++) {
                matrix.get(layer).set(i, values.get(index++));
            }

            // Update the right column
            for (int i = layer + 1; i < m - layer; i++) {
                matrix.get(i).set(n - layer - 1, values.get(index++));
            }

            // Update the bottom row
            for (int i = n - layer - 2; i >= layer; i--) {
                matrix.get(m - layer - 1).set(i, values.get(index++));
            }

            // Update the left column
            for (int i = m - layer - 2; i > layer; i--) {
                matrix.get(i).set(layer, values.get(index++));
            }
        }

        // Print the rotated matrix
        for (List<Integer> row : matrix) {
            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
//        case1();
//        System.out.println();
//        case2();
//        System.out.println();
//        case3();
//        System.out.println();
        case4();
        System.out.println();
    }

    private static void case1() {
        Result.matrixRotation(Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(5, 6, 7, 8),
                Arrays.asList(9, 10, 11, 12),
                Arrays.asList(13, 14, 15, 16)
        ), 2);
    }

    private static void case2() {
        Result.matrixRotation(Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(7, 8, 9, 10),
                Arrays.asList(13, 14, 15, 16),
                Arrays.asList(19, 20, 21, 22),
                Arrays.asList(25, 26, 27, 28)
        ), 7);
    }

    private static void case3() {
        Result.matrixRotation(Arrays.asList(
                Arrays.asList(1, 1),
                Arrays.asList(1, 1)
        ), 3);
    }

    private static void case4() {
        Result.matrixRotation(Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(12, 1, 2, 5),
                Arrays.asList(11, 4, 3, 6),
                Arrays.asList(10, 9, 8, 7)
        ), 2);
    }
}

