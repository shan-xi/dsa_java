package best_time_to_buy_and_sell_stock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void test_case1_success() {
        Solution s = new Solution();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int a = s.maxProfit(prices);
        int e = 5;
        Assertions.assertEquals(e, a);
    }

    @Test
    public void test_case2_success() {
        Solution s = new Solution();
        int[] prices = {7, 6, 4, 3, 1};
        int a = s.maxProfit(prices);
        int e = 0;
        Assertions.assertEquals(e, a);
    }

    @Test
    public void test_case3_success() {
        Solution s = new Solution();
        int[] prices = {1, 2};
        int a = s.maxProfit(prices);
        int e = 1;
        Assertions.assertEquals(e, a);
    }

    @Test
    public void test_case4_success() {
        Solution s = new Solution();
        int[] prices = {2, 1, 2, 1, 0, 1, 2};
        int a = s.maxProfit(prices);
        int e = 2;
        Assertions.assertEquals(e, a);
    }
}
