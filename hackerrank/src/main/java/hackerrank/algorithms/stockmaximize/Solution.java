package hackerrank.algorithms.stockmaximize;

import java.io.IOException;
import java.util.List;

class Result {

    /*
     * Complete the 'stockmax' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY prices as parameter.
     */

    public static long stockmax(List<Integer> prices) {
        long maxProfit = 0;
        int n = prices.size();
        int maxPrice = prices.get(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            if (prices.get(i) > maxPrice) {
                maxPrice = prices.get(i);
            } else {
                maxProfit += maxPrice - prices.get(i);
            }
        }
        return maxProfit;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println(Result.stockmax(List.of(5, 3, 2)));
        System.out.println(Result.stockmax(List.of(1, 2, 100)));
        System.out.println(Result.stockmax(List.of(1, 3, 1, 2)));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int t = Integer.parseInt(bufferedReader.readLine().trim());
//
//        IntStream.range(0, t).forEach(tItr -> {
//            try {
//                int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//                List<Integer> prices = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                        .map(Integer::parseInt)
//                        .collect(toList());
//
//                long result = Result.stockmax(prices);
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
