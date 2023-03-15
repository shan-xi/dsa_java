package reshape_the_matrix;

// 566. Reshape the Matrix
// https://leetcode.com/problems/reshape-the-matrix/description/?envType=study-plan&id=data-structure-i
public class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r * c != mat.length * mat[0].length) {
            return mat;
        }
        int[][] result = new int[r][c];
        int p = 0;
        int q = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int v = mat[i][j];

                if (q >= result[0].length) {
                    q = 0;
                    p++;
                }
                result[p][q++] = v;
            }
        }
        return result;
    }
}
