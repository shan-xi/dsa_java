package topic.two_pointers._151_Reverse_Words_in_a_String;

public class Solution2 {
    // Main method to test the solution
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        // Test cases
        System.out.println(solution.reverseWords("the sky is blue")); // Output: "blue is sky the"
        System.out.println(solution.reverseWords("  hello world  ")); // Output: "world hello"
        System.out.println(solution.reverseWords("a good   example")); // Output: "example good a"
    }

    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].isEmpty()) continue;
            if (!sb.isEmpty()) {
                sb.append(" ");
            }
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}

