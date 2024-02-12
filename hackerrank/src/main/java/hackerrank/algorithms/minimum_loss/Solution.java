package hackerrank.algorithms.minimum_loss;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

class Result {

    /*
     * Complete the 'minimumLoss' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts LONG_INTEGER_ARRAY price as parameter.
     */

    public static int minimumLoss(List<Long> price) {
        TreeMap<Long, Integer> priceMap = new TreeMap<>();
        for (int i = 0; i < price.size(); i++) {
            priceMap.put(price.get(i), i);
        }

        long minLoss = Long.MAX_VALUE;

        for (int currentIndex = 0; currentIndex < price.size(); currentIndex++) {
            Long higherPrice = priceMap.higherKey(price.get(currentIndex));
            if (higherPrice != null) {
                int higherIndex = priceMap.get(higherPrice);
                long currentPrice = price.get(currentIndex);
                if (higherPrice > currentPrice && higherIndex < currentIndex) {
                    if (minLoss > higherPrice - currentPrice) {
                        minLoss = higherPrice - currentPrice;
                    }
                }
            }
        }
        return (int) minLoss;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println(Result.minimumLoss(Arrays.asList(20L, 15L, 8L, 2L, 12L)));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Long> price = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Long::parseLong)
//                .collect(toList());
//
//        int result = Result.minimumLoss(price);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
