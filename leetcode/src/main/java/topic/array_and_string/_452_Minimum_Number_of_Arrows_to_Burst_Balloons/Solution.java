package topic.array_and_string._452_Minimum_Number_of_Arrows_to_Burst_Balloons;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] points1 = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(solution.findMinArrowShots(points1)); // Output: 2

        int[][] points2 = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        System.out.println(solution.findMinArrowShots(points2)); // Output: 4

        int[][] points3 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        System.out.println(solution.findMinArrowShots(points3)); // Output: 2
    }

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        // Sort by the end of each interval
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            // If the current balloon starts after the previous arrow's end, shoot a new arrow
            if (points[i][0] > end) {
                arrows++;
                end = points[i][1];
            }
        }

        return arrows;
    }
}
