package hackerrank.algorithms.new_year_chaos;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class Result {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int bribes = 0;
        int n = q.size();

        for (int i = n - 1; i >= 0; i--) {
            int expectedPosition = i + 1; // Expected position of the current person
            int currentPosition = q.get(i); // Current position of the current person

            // Check if the current person has moved more than two positions forward
            if (currentPosition > expectedPosition + 2) {
                System.out.println("Too chaotic");
                return;
            }

            // Count the number of bribes for the current person
            for (int j = Math.max(0, currentPosition - 2); j < i; j++) {
                if (q.get(j) > currentPosition) {
                    bribes++;
                }
            }
        }

        System.out.println(bribes);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        Result.minimumBribes(Arrays.asList(2, 1, 5, 3, 4));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        int t = Integer.parseInt(bufferedReader.readLine().trim());
//
//        IntStream.range(0, t).forEach(tItr -> {
//            try {
//                int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                        .map(Integer::parseInt)
//                        .collect(toList());
//
//                Result.minimumBribes(q);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        bufferedReader.close();
    }
}
