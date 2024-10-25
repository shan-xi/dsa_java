package topic.array_and_string._121_Best_Time_to_Buy_and_Sell_Stock;

public class Solution {
    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit for prices1: " + solution.maxProfit(prices1));  // Output: 5

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Max Profit for prices2: " + solution.maxProfit(prices2));  // Output: 0
    }

    //    public int maxProfit(int[] prices) {
//        if (prices.length == 1) return 0;
//        int p = 0;
//        int a = prices[0];
//        int b = prices[0];
//        for (int i = 1; i < prices.length; i++) {
//            if (prices[i] < b) {
//                b = prices[i];
//                a = prices[i];
//            } else {
//                a = Math.max(a, prices[i]);
//            }
//            p = Math.max(p, a - b);
//        }
//        return p;
//    }
    public int maxProfit(int[] prices) {
        // Edge case: if there are no prices or only one price, return 0 profit
        if (prices == null || prices.length < 2) return 0;

        // Initialize minimum price and maximum profit
        int minPrice = prices[0];
        int maxProfit = 0;

        // Iterate through prices starting from the second day
        for (int i = 1; i < prices.length; i++) {
            // Calculate the profit if selling on day i
            int profit = prices[i] - minPrice;

            // Update maxProfit if the current profit is greater
            maxProfit = Math.max(maxProfit, profit);

            // Update minPrice to the lowest price encountered so far
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }
}
