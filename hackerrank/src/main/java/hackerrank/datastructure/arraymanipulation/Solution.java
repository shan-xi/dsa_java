package hackerrank.datastructure.arraymanipulation;

import java.io.IOException;
import java.util.List;

class Result {

    /*
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        long[] arr = new long[n + 2];
        for (var query : queries) {
            var a = query.get(0);
            var b = query.get(1);
            var k = query.get(2);
            arr[a] += k;
            arr[b + 1] -= k;
        }
        long max = Integer.MIN_VALUE;
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += arr[i];
            max = Math.max(max, sum);
        }
        return max;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        case1();
        case2();
    }

    private static void case1() {
        int n = 10;
        var queries = List.of(List.of(1, 5, 3), List.of(4, 8, 7), List.of(6, 9, 1));
        long result = Result.arrayManipulation(n, queries);
        System.out.println(result);
    }

    private static void case2() {
        int n = 5;
        var queries = List.of(List.of(1, 2, 100), List.of(2, 5, 100), List.of(3, 4, 100));
        long result = Result.arrayManipulation(n, queries);
        System.out.println(result);
    }
}
