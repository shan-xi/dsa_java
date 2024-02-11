package hackerrank.algorithms.recursivedigitsum;

import java.io.*;

class Result {

    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */
    public static int superDigit(String n, int k) {
        // Calculate the initial sum of digits
        long sum = calculateSum(n) * k;
        // Calculate the super digit of the sum
        return calculateSuperDigit(sum);
    }

    private static long calculateSum(String n) {
        long sum = 0;
        for (char c : n.toCharArray()) {
            sum += Character.getNumericValue(c);
        }
        return sum;
    }

    private static int calculateSuperDigit(long num) {
        // If the number is already a single digit, return it
        if (num < 10) {
            return (int) num;
        }
        // Calculate the sum of digits recursively
        long sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        // Recursively calculate the super digit of the sum
        return calculateSuperDigit(sum);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
