package hackerrank.algorithms.maxmin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Result {

    /*
     * Complete the 'maxMin' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */

    public static int maxMin(int k, List<Integer> arr) {
        Collections.sort(arr);
        int minUnfairness = Integer.MAX_VALUE;
        for (int i = 0; i <= arr.size() - k; i++) {
            int currentUnfairness = arr.get(i + k - 1) - arr.get(i);
            minUnfairness = Math.min(currentUnfairness, minUnfairness);
        }
        return minUnfairness;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        int k = 3;
        List<Integer> arr = new ArrayList<>();
        arr.addAll(List.of(10, 100, 300, 200, 1000, 20, 30));
        int result = Result.maxMin(k, arr);
        System.out.println(result);

//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        int k = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> arr = new ArrayList<>();
//
//        for (int i = 0; i < n; i++) {
//            int num = Integer.parseInt(bufferedReader.readLine().trim());
//            arr.add(num);
//        }
//
//        int result = Result.maxMin(k, arr);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}

