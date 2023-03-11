package matrix;

public class TwoPassCheck {
    public int solution(int[][] m) {

        int count1 = 0;
        for (int[] i : m) {
            int temp = 0;
            for (int j : i) {
                temp += j;
            }
            if (temp > 1) {
                count1 += temp;
            }
        }

        int count2 = 0;
        for (int j = 0; j < m[0].length; j++) {
            int temp = 0;
            for (int[] ints : m) {
                temp += ints[j];
            }
            if (temp > 1) {
                count2 += temp;
            }
        }

        return Math.max(count1, count2);
    }
}
