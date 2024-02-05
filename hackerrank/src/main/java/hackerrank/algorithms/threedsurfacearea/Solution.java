package hackerrank.algorithms.threedsurfacearea;

import java.io.IOException;
import java.util.List;

class Result {

    /*
     * Complete the 'surfaceArea' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY A as parameter.
     */

    public static int surfaceArea(List<List<Integer>> A) {
        int count = 0;
        int H = A.size();
        int W = A.get(0).size();
        count += H * W * 2;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                int cell = A.get(i).get(j);
                if (i - 1 < 0) {
                    count += cell;
                }
                if (i + 1 >= H) {
                    count += cell;
                }
                if (j - 1 < 0) {
                    count += cell;
                }
                if (j + 1 >= W) {
                    count += cell;
                }

                if (i - 1 >= 0) {
                    int up = A.get(i - 1).get(j);
                    if (cell > up) {
                        count += cell - up;
                    }
                }

                if (i + 1 < H) {
                    int down = A.get(i + 1).get(j);
                    if (cell > down) {
                        count += cell - down;
                    }
                }
                if (j - 1 >= 0) {
                    int left = A.get(i).get(j - 1);
                    if (cell > left) {
                        count += cell - left;
                    }
                }

                if (j + 1 < W) {
                    int right = A.get(i).get(j + 1);
                    if (cell > right) {
                        count += cell - right;
                    }
                }
            }
        }

        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        List<List<Integer>> A = List.of(
                List.of(1, 3, 4),
                List.of(2, 2, 3),
                List.of(1, 2, 4)
        );
        int result = Result.surfaceArea(A);
        System.out.println(result);
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//        int H = Integer.parseInt(firstMultipleInput[0]);
//
//        int W = Integer.parseInt(firstMultipleInput[1]);
//
//        List<List<Integer>> A = new ArrayList<>();
//
//        IntStream.range(0, H).forEach(i -> {
//            try {
//                A.add(
//                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                                .map(Integer::parseInt)
//                                .collect(toList())
//                );
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        int result = Result.surfaceArea(A);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
