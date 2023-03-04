package merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (arg1, arg2) -> Integer.compare(arg1[0], arg2[0]));
        ArrayList<int[]> list = new ArrayList<>();
        int record_start = intervals[0][0];
        int record_end = intervals[0][1];
        if (intervals.length == 1) {
            return intervals;
        }
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            // overlap
            if (record_end >= start) {
                if (record_end <= end) {
                    record_end = end;
                }
            } else {
                // not overlap
                list.add(new int[]{record_start, record_end});
                record_start = start;
                record_end = end;
            }
            if (i == intervals.length - 1) {
                list.add(new int[]{record_start, record_end});
            }
        }
        return list.toArray(new int[list.size()][]);
    }

// LeetCode solution memory usage is worse than my code, runtime the same

//    public int[][] merge(int[][] intervals) {
//        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
//        LinkedList<int[]> merged = new LinkedList<>();
//        for (int[] interval : intervals) {
//            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
//                merged.add(interval);
//            } else {
//                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
//            }
//        }
//        return merged.toArray(new int[merged.size()][]);
//    }
}
