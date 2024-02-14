package hackerrank.algorithms.goodland_electricity;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class Result {

    /*
     * Complete the 'pylons' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */

    public static int pylons(int k, List<Integer> arr) {
        // Write your code here
        int n = arr.size();
        int pylonsCount = 0;
        int index = 0; // the index of grid

        while (index < n) {
            int nextPylon = -1;

            // Search for the next pylon to place
            for (
                    int i = Math.min(index + k - 1, n - 1); //  start from the (current + interval) or last one in grid
                    i >= Math.max(index - k + 1, 0); // stop at previous pylons or less than 0
                    i--) {
                if (arr.get(i) == 1) {
                    nextPylon = i;
                    pylonsCount++;
                    break;
                }
            }

            // If no pylon is found in the range, it's impossible to cover all cities
            if (nextPylon == -1) {
                return -1;
            }

            // Update index to the next uncovered city
            index = nextPylon + k;
        }

        return pylonsCount;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println(Result.pylons(2, Arrays.asList(0, 1, 1, 1, 1, 0)));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//        int n = Integer.parseInt(firstMultipleInput[0]);
//
//        int k = Integer.parseInt(firstMultipleInput[1]);
//
//        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        int result = Result.pylons(k, arr);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
