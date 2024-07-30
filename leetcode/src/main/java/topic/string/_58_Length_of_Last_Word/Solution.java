package topic.string._58_Length_of_Last_Word;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "Hello World";
        String s2 = "   fly me   to   the moon  ";
        String s3 = "luffy is still joyboy";

        System.out.println("Length of last word: " + solution.lengthOfLastWord(s1)); // Output: 5
        System.out.println("Length of last word: " + solution.lengthOfLastWord(s2)); // Output: 4
        System.out.println("Length of last word: " + solution.lengthOfLastWord(s3)); // Output: 6
    }

    public int lengthOfLastWord(String s) {
        int length = 0;
        int i = s.length() - 1;

        // Trim any trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Calculate the length of the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}
