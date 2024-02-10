package hackerrank.algorithms.constructthearray;

import java.io.IOException;

class Result {

    /*
     * Complete the 'countArray' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER x
     */

    public static long countArray(int n, int k, int x) {
        final long MOD = 1000000007;
        long[] endingWithX = new long[n];
        long[] endingWithoutX = new long[n];
        endingWithX[0] = (x == 1) ? 1 : 0;
        endingWithoutX[0] = (x == 1) ? 0 : 1;
        for (int i = 1; i < n; i++) {
            endingWithX[i] = endingWithoutX[i - 1] % MOD;
            endingWithoutX[i] = (endingWithX[i - 1] * (k - 1) + endingWithoutX[i - 1] * (k - 2)) % MOD;
        }
        return endingWithX[n - 1];
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        long answer = Result.countArray(4, 3, 2);
        System.out.println(answer);
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//        int n = Integer.parseInt(firstMultipleInput[0]);
//
//        int k = Integer.parseInt(firstMultipleInput[1]);
//
//        int x = Integer.parseInt(firstMultipleInput[2]);
//
//        long answer = Result.countArray(n, k, x);
//
//        bufferedWriter.write(String.valueOf(answer));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
