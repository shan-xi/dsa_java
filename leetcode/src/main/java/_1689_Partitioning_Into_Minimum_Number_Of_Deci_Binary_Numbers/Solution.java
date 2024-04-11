package _1689_Partitioning_Into_Minimum_Number_Of_Deci_Binary_Numbers;

public class Solution {
    public static void main(String[] args) {
        var s = new Solution();
        System.out.println(s.minPartitions("32"));
        System.out.println(s.minPartitions("82734"));
        System.out.println(s.minPartitions("27346209830709182346"));
    }

    public int minPartitions(String n) {
        int maxDigit = 0;
        for (char c : n.toCharArray()) {
            maxDigit = Math.max(maxDigit, c - '0');
        }
        return maxDigit;
    }
}
