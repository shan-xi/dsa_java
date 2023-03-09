package com.bluex;

public class Solution {
    public static void main(String[] args) {
        Solution.print();
    }

    static void print() {
        for (int i = 1; i <= 100; i++) {
            if (i % 15 == 0) {
                System.out.println("LiveeviL");
            } else if (i % 3 == 0) {
                System.out.println("Live");
            } else if (i % 5 == 0) {
                System.out.println("eviL");
            } else {
                System.out.println(i);
            }
        }
    }
}
