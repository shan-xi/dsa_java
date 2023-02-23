package com.pic;

import java.util.Arrays;

public class Sum {
    int sumValue(int[] values) {
        Arrays.sort(values);
        return (values[values.length - 1] + values[0]) * values.length / 2;
    }

    public static void main(String[] args) {
        int a[] = new int[100];
        for (int i = 0; i < 100; i++) {
            a[i] = i + 1;
        }
        System.out.println(new Sum().sumValue(a));
    }
}
