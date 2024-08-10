package topic.array_and_string._238_Product_of_Array_Except_Self;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4};
        int[] result = solution.productExceptSelf(nums);

        for (int val : result) {
            System.out.print(val + " ");
        }
        // Output: 24 12 8 6
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Calculate left products
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Step 2: Calculate right products and update the result array
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }
}
