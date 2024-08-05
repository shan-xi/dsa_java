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

class Solution2 {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
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
        int[] res6 = s.findMaxSumIndex(new int[]{1, 2, 3, 2, 4, 3, 5, 1});
        System.out.printf("%d,%d\n", res6[0], res6[1]);
    }

    public int[] findMaxSumIndex(int[] arr) {
        int[] result = new int[2];
        int maxSum = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        int[] c1 = new int[arr.length];
        int[] c2 = new int[arr.length];
        c1[0] = arr[0];
        c2[0] = arr[0];
        map.put(arr[0], 0);
        for (int i = 1; i < arr.length; i++) {
            c1[i] += arr[i] + c1[i - 1];
        }
        for (int i = 1; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                int index = map.get(arr[i]);
                int value = c1[i] - c1[index] + arr[i];
                c2[i] = value;
                if (value > maxSum) {
                    maxSum = value;
                    result[0] = index;
                    result[1] = i;
                }
                if (value < c2[index]) {
                    map.put(arr[i], i);
                }
            } else {
                map.put(arr[i], i);
                c2[i] = arr[i] + arr[i - 1];
            }
        }
        if (maxSum == Integer.MIN_VALUE) {
            if (arr.length > 1) {
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] > max) {
                        max = arr[i];
                        result[0] = i;
                        result[1] = i;
                    }
                }
            }
        }
        return result;
    }
}