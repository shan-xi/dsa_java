package hackerrank.algorithms.biggerisgreatter;

import java.io.IOException;

/**
 * https://www.hackerrank.com/challenges/bigger-is-greater/problem
 */
class Result {

    /*
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     */

    public static String biggerIsGreater(String w) {
        char[] arr = w.toCharArray();

        // find pivot
        int i = w.length() - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) {
            i--;
        }

        if (i == 0) {
            return "no answer";
        }

        // find rightmost greater than pivot
        int j = w.length() - 1;
        while (arr[j] <= arr[i - 1]) {
            j--;
        }

        // swap pivot and rightmost
        char temp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = temp;

        // reverse subPrefix
        j = w.length() - 1;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        return String.valueOf(arr);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        String result = Result.biggerIsGreater("abdc");
        System.out.println(result);
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int T = Integer.parseInt(bufferedReader.readLine().trim());
//
//        IntStream.range(0, T).forEach(TItr -> {
//            try {
//                String w = bufferedReader.readLine();
//
//                String result = Result.biggerIsGreater(w);
//
//                bufferedWriter.write(result);
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
