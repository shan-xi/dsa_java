package hackerrank.algorithms.sherlockandcost;

import java.io.IOException;
import java.util.List;

class Result {

    /*
     * Complete the 'cost' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY B as parameter.
     */

    public static int cost(List<Integer> B) {
        // Write your code here
        int n = B.size();
        int[][] dp = new int[n][2];

        for (int i = 1; i < n; i++) {

            int a = dp[i - 1][0];
            int b = dp[i - 1][1];
            int c = Math.abs(1 - B.get(i - 1));
            int d = Math.abs(B.get(i) - B.get(i - 1));

            dp[i][0] = Math.max(a, b + c);
            dp[i][1] = Math.max(a + c, b + d);
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
//        System.out.println(Result.cost(List.of(1, 2, 3)));
        System.out.println(Result.cost(List.of(10, 1, 10, 1, 10)));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int t = Integer.parseInt(bufferedReader.readLine().trim());
//
//        IntStream.range(0, t).forEach(tItr -> {
//            try {
//                int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//                List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                        .map(Integer::parseInt)
//                        .collect(toList());
//
//                int result = Result.cost(B);
//
//                bufferedWriter.write(String.valueOf(result));
//                bufferedWriter.newLine();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
