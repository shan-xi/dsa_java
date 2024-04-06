package hackerrank.algorithms.absolutepermutation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/absolute-permutation/problem
 */
class Result {

    /*
     * Complete the 'absolutePermutation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     */

    public static List<Integer> absolutePermutation(int n, int k) {
        List<Integer> permutation = new ArrayList<>();

        if (k == 0) {
            for (int i = 1; i <= n; i++) {
                permutation.add(i);
            }
        } else if (n % (2 * k) == 0) {
            boolean[] visited = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                int diff1 = i - k;
                int diff2 = i + k;
                if (diff1 > 0 && !visited[diff1]) {
                    visited[diff1] = true;
                    permutation.add(diff1);
                } else if (diff2 <= n && !visited[diff2]) {
                    visited[diff2] = true;
                    permutation.add(diff2);
                } else {
                    return List.of(-1);
                }
            }
        } else {
            return List.of(-1);
        }

        return permutation;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        List<Integer> result = Result.absolutePermutation(2, 1);
        System.out.println(result);
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int t = Integer.parseInt(bufferedReader.readLine().trim());
//
//        IntStream.range(0, t).forEach(tItr -> {
//            try {
//                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//                int n = Integer.parseInt(firstMultipleInput[0]);
//
//                int k = Integer.parseInt(firstMultipleInput[1]);
//
//                List<Integer> result = Result.absolutePermutation(n, k);
//
//                bufferedWriter.write(
//                        result.stream()
//                                .map(Object::toString)
//                                .collect(joining(" "))
//                                + "\n"
//                );
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
