package hackerrank.algorithms.andproduct;

import java.io.IOException;

/**
 * https://www.hackerrank.com/challenges/and-product/problem
 */
class Result {

    /*
     * Complete the 'andProduct' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. LONG_INTEGER a
     *  2. LONG_INTEGER b
     */

    public static long andProduct(long a, long b) {
        long result = a;
        for (long i = a + 1; i <= b; i++) {
            result &= i;
            if (result == 0) {
                break;
            }
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println(Result.andProduct(10, 14));
        System.out.println(Result.andProduct(12, 15));
        System.out.println(Result.andProduct(2, 3));
        System.out.println(Result.andProduct(8, 13));
        System.out.println(Result.andProduct(17, 23));
        System.out.println(Result.andProduct(11, 15));

//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        IntStream.range(0, n).forEach(nItr -> {
//            try {
//                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//                long a = Long.parseLong(firstMultipleInput[0]);
//
//                long b = Long.parseLong(firstMultipleInput[1]);
//
//                long result = Result.andProduct(a, b);
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
