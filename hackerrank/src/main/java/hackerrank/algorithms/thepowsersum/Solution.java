package hackerrank.algorithms.thepowsersum;

import java.io.IOException;

class Result {

    /*
     * Complete the 'powerSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER X
     *  2. INTEGER N
     */

    public static int powerSum(int X, int N) {
        return findPowerSum(X, N, 1);
    }

    private static int findPowerSum(int remaining, int N, int currentNum) {
        if (remaining == 0) {
            return 1;
        }
        if (remaining < 0 || currentNum > remaining) {
            return 0;
        }
        int include = findPowerSum(remaining - (int) Math.pow(currentNum, N), N, currentNum + 1);
        int exclude = findPowerSum(remaining, N, currentNum + 1);
        return include + exclude;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        int X = 10;

        int N = 2;

        int result = Result.powerSum(X, N);
        System.out.println(result);
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int X = Integer.parseInt(bufferedReader.readLine().trim());
//
//        int N = Integer.parseInt(bufferedReader.readLine().trim());
//
//        int result = Result.powerSum(X, N);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}

