package hackerrank.algorithms.extractlongfactorials;

import java.io.IOException;
import java.math.BigInteger;

class Result {

    /*
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void extraLongFactorials(int n) {

        BigInteger b = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            b = b.multiply(BigInteger.valueOf(i));
        }
        System.out.println(b);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        Result.extraLongFactorials(25);
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        Result.extraLongFactorials(n);
//
//        bufferedReader.close();
    }
}
