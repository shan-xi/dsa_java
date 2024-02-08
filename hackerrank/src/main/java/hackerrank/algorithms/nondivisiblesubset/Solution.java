package hackerrank.algorithms.nondivisiblesubset;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Result {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i : s) {
            int remainder = i % k;
            freqMap.put(remainder, freqMap.getOrDefault(remainder, 0) + 1);
        }

        int count = 0;

        for (int i = 1; i <= k / 2; i++) {
            if (i == k - i) {
                count += freqMap.getOrDefault(i, 0) > 0 ? 1 : 0;
            } else {
                count += Math.max(freqMap.getOrDefault(i, 0), freqMap.getOrDefault((k - i), 0));
            }
        }
        count += freqMap.containsKey(0) ? 1 : 0;

        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        int result = Result.nonDivisibleSubset(3, List.of(1, 7, 2, 4));
//        int result = Result.nonDivisibleSubset(7, List.of(278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436));
        System.out.println(result);
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//        int n = Integer.parseInt(firstMultipleInput[0]);
//
//        int k = Integer.parseInt(firstMultipleInput[1]);
//
//        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        int result = Result.nonDivisibleSubset(k, s);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
