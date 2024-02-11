package hackerrank.algorithms.hackerlandradiotransmitters;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Result {

    /*
     * Complete the 'hackerlandRadioTransmitters' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY x
     *  2. INTEGER k
     */

    public static int hackerlandRadioTransmitters(List<Integer> x, int k) {
        Collections.sort(x);
        int transmitterCount = 0;
        int n = x.size();
        int i = 0;
        while (i < n) {
            int loc = x.get(i);
            transmitterCount++;
            while (i < n && x.get(i) <= loc + k) {
                i++;
            }
            --i;
            loc = x.get(i);
            while (i < n && x.get(i) <= loc + k) {
                i++;
            }
        }

        return transmitterCount;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println(Result.hackerlandRadioTransmitters(Arrays.asList(1, 2, 3, 4, 5), 1));
        System.out.println(Result.hackerlandRadioTransmitters(Arrays.asList(7, 2, 4, 6, 5, 9, 12, 11), 2));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//        int n = Integer.parseInt(firstMultipleInput[0]);
//
//        int k = Integer.parseInt(firstMultipleInput[1]);
//
//        List<Integer> x = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        int result = Result.hackerlandRadioTransmitters(x, k);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
