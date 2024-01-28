package hackerrank.algorithms.thetimeinwords;

import java.io.*;

class Result {

    /*
     * Complete the 'timeInWords' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER h
     *  2. INTEGER m
     */
    private static final String[] numbers = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen"
    };

    private static final String[] multiplesOfTen = {
            "", "", "twenty", "thirty", "forty", "fifty"
    };

    /*
     * Complete the 'timeInWords' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER h
     *  2. INTEGER m
     */

    public static String timeInWords(int h, int m) {
        if (m == 0) {
            return numbers[h] + " o' clock";
        } else if (m == 15) {
            return "quarter past " + numbers[h];
        } else if (m == 30) {
            return "half past " + numbers[h];
        } else if (m == 45) {
            return "quarter to " + numbers[h + 1];
        } else if (m == 1) {
            return "one minute past " + numbers[h];
        } else if (m < 30) {
            return convertToWords(m) + " minutes past " + numbers[h];
        } else {
            return convertToWords(60 - m) + " minutes to " + numbers[h + 1];
        }
    }

    private static String convertToWords(int m) {
        if (m < 20) {
            return numbers[m];
        } else {
            return multiplesOfTen[m / 10] + (m % 10 == 0 ? "" : " " + numbers[m % 10]);
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
