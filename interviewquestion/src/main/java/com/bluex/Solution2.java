package com.bluex;

public class Solution2 {
    public static void main(String[] args) {
        assign();
    }
    static void assign() {
        int total = ((99 + 1) * 99) / 2;
        int subtotal = total / 3;
        int suma = 0, sumb = 0, sumc = 0;
        for (int i = 99; i >= 0; i--) {
            if (suma + i <= subtotal) {
                suma += i;
            } else if (sumb + i <= subtotal) {
                sumb += i;
            } else {
                sumc += i;
            }
        }
        System.out.println(suma);
        System.out.println(sumb);
        System.out.println(sumc);
    }
}
