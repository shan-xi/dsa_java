package com.innova;

import java.util.Stack;

/**
 * Given one integer
 * for each digit in this integer,
 * print “foo”+digit as output
 * for example,
 * input: 2278   =>  output “foo2foo2foo7foo8”.
 * Don’t use String object
 */
public class Solution {
    public static String print(int i) {

        /**
         * 2278 % 10 = 8
         * 2278 / 10 = 227
         *
         * 227 % 10 = 7
         * 227 / 10 = 22
         *
         * 22 & 10 = 2
         * 22 / 10 = 2
         *
         * 2 % 10 = 2
         * 2 / 10 = 0
         */

        Stack<Integer> stack = new Stack<>();
        int r = i;
        while (r != 0) {
            stack.push(r % 10);
            r = r / 10;
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append("foo").append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(print(2278));
        System.out.println(print(22780));
    }
}
