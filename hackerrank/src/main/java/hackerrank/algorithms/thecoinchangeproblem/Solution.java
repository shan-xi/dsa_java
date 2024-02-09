package hackerrank.algorithms.thecoinchangeproblem;

import java.io.IOException;
import java.util.List;

class Result {

    /*
     * Complete the 'getWays' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. LONG_INTEGER_ARRAY c
     */

    public static long getWays(int n, List<Long> c) {
        long[] dp = new long[n + 1];

        dp[0] = 1;

        for (long coin : c) {
            for (int amount = 1; amount <= n; amount++) {
                if (amount >= coin) {
                    dp[amount] += dp[amount - (int) coin];
                }
            }
        }

        return dp[n];
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        long ways = Result.getWays(4, List.of(1L, 2L, 3L));
        System.out.println(ways);
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//        int n = Integer.parseInt(firstMultipleInput[0]);
//
//        int m = Integer.parseInt(firstMultipleInput[1]);
//
//        List<Long> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Long::parseLong)
//                .collect(toList());
//
//        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
//
//        long ways = Result.getWays(n, c);
//
//        bufferedWriter.write(String.valueOf(ways));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
