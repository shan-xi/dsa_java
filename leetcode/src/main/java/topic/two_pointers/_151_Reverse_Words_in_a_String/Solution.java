package topic.two_pointers._151_Reverse_Words_in_a_String;

public class Solution {
    // Main method to test the solution
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println(solution.reverseWords("the sky is blue")); // Output: "blue is sky the"
        System.out.println(solution.reverseWords("  hello world  ")); // Output: "world hello"
        System.out.println(solution.reverseWords("a good   example")); // Output: "example good a"
    }

    public String reverseWords(String s) {
        // Step 1: Trim leading and trailing spaces and convert to char array
        char[] str = s.trim().toCharArray();
        int n = str.length;

        // Step 2: Reverse the entire string
        reverse(str, 0, n - 1);

        // Step 3: Reverse each word in the reversed string
        reverseEachWord(str);

        // Step 4: Clean up spaces and return the final string
        return cleanSpaces(str);
    }

    // Helper method to reverse a segment of the array
    private void reverse(char[] str, int left, int right) {
        while (left < right) {
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;
            right--;
        }
    }

    // Helper method to reverse each word in the array
    private void reverseEachWord(char[] str) {
        int n = str.length;
        int start = 0, end = 0;

        while (start < n) {
            // Move `end` to the end of the current word
            while (end < n && str[end] != ' ') end++;
            // Reverse the current word
            reverse(str, start, end - 1);
            // Move to the next word
            start = end + 1;
            end++;
        }
    }

    // Helper method to remove extra spaces
    private String cleanSpaces(char[] str) {
        int n = str.length;
        int i = 0, j = 0;

        while (j < n) {
            // Skip spaces
            while (j < n && str[j] == ' ') j++;
            // Copy characters
            while (j < n && str[j] != ' ') str[i++] = str[j++];
            // Skip spaces and leave a single space
//            while (j < n && str[j] == ' ') j++;
            if (j < n) str[i++] = ' ';
        }

        return new String(str).substring(0, i);
    }
}
