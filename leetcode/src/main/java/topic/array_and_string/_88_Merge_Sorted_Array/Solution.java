package topic.array_and_string._88_Merge_Sorted_Array;

class Solution {
    public static void main(String[] args) {
        Solution msa = new Solution();

        int[] nums1 = {1, 2, 3, 0, 0, 0};  // Array nums1 has space to accommodate nums2
        int[] nums2 = {2, 5, 6};

        msa.merge(nums1, 3, nums2, 3);

        // Print the merged array
        System.out.println("Merged array: ");
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}