package topic.array_and_string._12_Integer_to_Roman;

public class Solution {
    // Main method to test the solution
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println(solution.intToRoman(3));    // Output: "III"
        System.out.println(solution.intToRoman(58));   // Output: "LVIII"
        System.out.println(solution.intToRoman(1994)); // Output: "MCMXCIV"
    }

    public String intToRoman(int num) {
        // Roman numeral values and corresponding symbols
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        // StringBuilder to build the result Roman numeral string
        StringBuilder roman = new StringBuilder();

        // Convert the integer to Roman numeral
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                roman.append(symbols[i]);
            }
        }

        return roman.toString();
    }
}
