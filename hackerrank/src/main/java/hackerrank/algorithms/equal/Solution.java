package hackerrank.algorithms.equal;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* This is a suck question, don't waste your time. Hackerrnak is really suck.*/

class Result {

    /*
     * Complete the 'equal' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int equal(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);

        // Initialize minimum operations required to Integer.MAX_VALUE
        int minOperations = Integer.MAX_VALUE;

        // Try each element as the target
        for (int target = arr.get(0); target >= arr.get(0) - 4; target--) {
            int operations = 0;
            // Calculate operations required for each element to reach the target
            for (int num : arr) {
                int diff = num - target;
                int a = diff / 5;
                int b = (diff %= 5) / 2;
                int c = diff % 2;
                operations += a + b + c;
            }
            // Update the minimum operations
            minOperations = Math.min(minOperations, operations);
        }
        // Return the minimum operations required
        return minOperations;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        int result = Result.equal(Arrays.asList(2, 2, 3, 7));
        System.out.println(result);
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int t = Integer.parseInt(bufferedReader.readLine().trim());
//
//        IntStream.range(0, t).forEach(tItr -> {
//            try {
//                int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                        .map(Integer::parseInt)
//                        .collect(toList());
//
//                int result = Result.equal(arr);
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
