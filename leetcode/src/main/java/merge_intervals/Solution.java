package merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (arg1, arg2) -> Integer.compare(arg1[0], arg2[0]));
        List<int[]> list = new ArrayList<>();
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
}
