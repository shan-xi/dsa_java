package topic.array_and_string._238_Product_of_Array_Except_Self;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = {1, 2, 3, 4};
        int[] result = solution.productExceptSelf(nums);

        for (int val : result) {
            System.out.print(val + " ");
        }
        // Output: 24 12 8 6
    }

    public int[] productExceptSelf(int[] nums) {
        int productWithOutZero = 0;
        boolean productWithZero = false;
        boolean moreThanOneZero = false;
        for (int num : nums) {
            if (num != 0) {
                if (productWithOutZero == 0) {
                    productWithOutZero = num;
                } else {
                    productWithOutZero = productWithOutZero * num;
                }
            } else {
                if (productWithZero) {
                    moreThanOneZero = true;
                }
                productWithZero = true;
            }
        }
        if (moreThanOneZero) {
            Arrays.fill(nums, 0);
        } else {
            if (productWithZero) {
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == 0) {
                        nums[i] = productWithOutZero;
                    } else {
                        nums[i] = 0;
                    }
                }
            } else {
                for (int i = 0; i < nums.length; i++) {
                    nums[i] = productWithOutZero / nums[i];
                }
            }
        }
        return nums;
    }
}
