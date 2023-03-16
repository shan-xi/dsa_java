package search_a_2D_matrix;

// 74. Search a 2D Matrix
// https://leetcode.com/problems/search-a-2d-matrix/?envType=study-plan&id=data-structure-i
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
