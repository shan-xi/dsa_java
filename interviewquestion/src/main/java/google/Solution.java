package google;

//Given N numbers: a[0], a[1], ..., a[N-1]
//find i <= j such that a[i] = a[j] and sum a[i] + a[i+1] + ... + a[j-1] + a[j] is maximized.
//
//        [1,3,1,3,2]
//
//
//i = 1, j = 3
//
//        [1,3,1,3,1,2]
//
//map
//1 0
//        3 1
//        2 5
//
//when i = 2, 5 (0, 2)
//when i = 3, 7 (1, 3)
//when i = 4, 9 (0, 4) max update max start and end
//
//[1,-3,1,3,1,2]
//map
//1  0
//        -3 1
//        3  3
//
//i = 0, current sum = 1
//i = 1, current sum = -2
//i = 2, current sum = -1
//i = 3, current sum = 2
//i = 4, current sum = 3
//
//        [1,3]

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] res = s.findMaxSumIndex(new int[]{1, 3, 1, 3, 2}); // 1 3
        System.out.printf("%d,%d\n", res[0], res[1]);
        int[] res2 = s.findMaxSumIndex(new int[]{1, 3, 1, 3, 1, 2}); // 0 4
        System.out.printf("%d,%d\n", res2[0], res2[1]);
        int[] res3 = s.findMaxSumIndex(new int[]{1, -3, 1, 3, 1, 2}); // 2 4
        System.out.printf("%d,%d\n", res3[0], res3[1]);
        int[] res4 = s.findMaxSumIndex(new int[]{1, 3}); // 1 1
        System.out.printf("%d,%d\n", res4[0], res4[1]);
        int[] res5 = s.findMaxSumIndex(new int[]{1}); // 0 0
        System.out.printf("%d,%d\n", res5[0], res5[1]);
    }

    public int[] findMaxSumIndex(int[] arr) {
        int[] result = new int[2];
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) { // outer loop n

            Map<Integer, Integer> map = new HashMap<>(); // keep array value and index
            for (int j = i; j < arr.length; j++) { //n

                // duplicate
                if (map.get(arr[j]) != null) {
                    // sum value
                    int start = map.get(arr[j]); // first occurs index
                    int tempSum = 0;
                    for (int k = start; k <= j; k++) {
                        tempSum += arr[k];
                    }
                    // update max status
//                    System.out.printf("start=%d, end=%d, tempSum=%d, maxSum=%d\n", start, j, tempSum, maxSum);
                    if (tempSum > maxSum) {
                        maxSum = tempSum;
                        result[0] = start;
                        result[1] = j;
                    }
                } else { // first occurs
                    map.put(arr[j], j);
                }
            }
            // no duplicate from different index
            if (maxSum == Integer.MIN_VALUE) {
                int tempSum = 0;
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    tempSum = entry.getKey();
                    if (tempSum >= maxSum) {
                        maxSum = tempSum;
                        result[0] = entry.getValue();
                        result[1] = entry.getValue();
                    }
                }
            }
        }
        return result;
    }
}