package integer_to_roman;

import java.util.*;

public class Solution {
    public String intToRoman(int num) {

        /**
         * Symbol       Value
         * I             1
         * V             5
         * X             10
         * L             50
         * C             100
         * D             500
         * M             1000
         */

        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);

        StringBuilder symbol = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            while (num >= entry.getValue()) {
                symbol.append(entry.getKey());
                num -= entry.getValue();
            }
        }
        return symbol.toString();

//        Map<Integer, String> map = new HashMap<>();
//        map.put(1, "I");
//        map.put(2, "II");
//        map.put(3, "III");
//        map.put(4, "IV");
//        map.put(5, "V");
//        map.put(6, "VI");
//        map.put(7, "VII");
//        map.put(8, "VIII");
//        map.put(9, "IX");
//        map.put(10, "X");
//        map.put(20, "XX");
//        map.put(30, "XXX");
//        map.put(40, "XL");
//        map.put(50, "L");
//        map.put(60, "LX");
//        map.put(70, "LXX");
//        map.put(80, "LXXX");
//        map.put(90, "XC");
//        map.put(100, "C");
//        map.put(200, "CC");
//        map.put(300, "CCC");
//        map.put(400, "CD");
//        map.put(500, "D");
//        map.put(600, "DC");
//        map.put(700, "DCC");
//        map.put(800, "DCCC");
//        map.put(900, "CM");
//        map.put(1000, "M");
//        map.put(2000, "MM");
//        map.put(3000, "MMM");

//        int remain = num;
//        int number_of_digit = 0;
//        StringBuilder sb = new StringBuilder();
//        List<String> list = new ArrayList<>();
//        while (remain > 0) {
//            int t = (int) (remain % 10 * Math.pow(10, number_of_digit));
//            if (map.get(t) != null) {
//                list.add(map.get(t));
//            }
//            remain = remain / 10;
//            number_of_digit++;
//        }
//        for (int i = list.size() - 1; i >= 0; i--) {
//            sb.append(list.get(i));
//        }
//        list = null;
//        return sb.toString();


    }
}
