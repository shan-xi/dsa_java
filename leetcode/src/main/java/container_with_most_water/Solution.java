package container_with_most_water;

public class Solution {
    public int maxArea(int[] height) {

        int left_index = 0;
        int right_index = height.length - 1;
        int max_left = height[left_index];
        int max_right = height[right_index];
        int area = (right_index - left_index) * Math.min(height[left_index], height[right_index]);

        while (left_index < right_index) {
            int curr_area = (right_index - left_index) * Math.min(height[left_index], height[right_index]);
            if (curr_area > area) {
                area = curr_area;
                if (height[left_index] > max_left) {
                    max_left = height[left_index];
                }
                if (height[right_index] > max_right) {
                    max_right = height[right_index];
                }
            }
            if (height[left_index] > height[right_index]) {
                right_index--;
            } else {
                left_index++;
            }
        }

        return area;
    }
}