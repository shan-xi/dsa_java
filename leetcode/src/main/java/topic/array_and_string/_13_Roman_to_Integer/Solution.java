package topic.array_and_string._13_Roman_to_Integer;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Expected output is 3
        String roman1 = "III";
        System.out.println("Roman: " + roman1 + " => Integer: " + solution.romanToInt(roman1));  // Output: 3

        // Test Case 2: Expected output is 58
        String roman2 = "LVIII";
        System.out.println("Roman: " + roman2 + " => Integer: " + solution.romanToInt(roman2));  // Output: 58

        // Test Case 3: Expected output is 1994
        String roman3 = "MCMXCIV";
        System.out.println("Roman: " + roman3 + " => Integer: " + solution.romanToInt(roman3));  // Output: 1994

        // Test Case 4: Expected output is 9
        String roman4 = "IX";
        System.out.println("Roman: " + roman4 + " => Integer: " + solution.romanToInt(roman4));  // Output: 9

        // Test Case 5: Expected output is 4
        String roman5 = "IV";
        System.out.println("Roman: " + roman5 + " => Integer: " + solution.romanToInt(roman5));  // Output: 4
    }

    public int romanToInt(String s) {
        int total = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = romanCharToInt(s.charAt(i));

            if (currentValue < prevValue) {
                total -= currentValue;
            } else {
                total += currentValue;
            }

            prevValue = currentValue;
        }

        return total;
    }

    private int romanCharToInt(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}
