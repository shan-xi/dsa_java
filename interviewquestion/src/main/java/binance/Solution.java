package binance;
//# Coding Challenge
//
//        ## Problem
//
//        Given an array of integers, write a method that returns an array that:
//        - Has all duplicate elements removed.
//        - Is sorted from the least value to the greatest value.
//
//        ## Examples
//
//        ```
//        uniqueSort([1, 2, 4, 3]) ➞ [1, 2, 3, 4]
//
//        uniqueSort([1, 4, 4, 4, 4, 4, 3, 2, 1, 2]) ➞ [1, 2, 3, 4]
//
//        uniqueSort([6, 7, 3, 2, 1]) ➞ [1, 2, 3, 6, 7]
//        ```

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        var s = new Solution();
        System.out.println(Arrays.toString(s.uniqueSort(new int[]{1, 2, 4, 3})));
        System.out.println(Arrays.toString(s.uniqueSort(new int[]{1, 4, 4, 4, 4, 4, 3, 2, 1, 2})));
        System.out.println(Arrays.toString(s.uniqueSort(new int[]{6, 7, 3, 2, 1})));
    }

    int[] uniqueSort(int[] arr) {

//        List<Integer> list = new ArrayList<>(); // O(1)
        Set<Integer> set = new HashSet<>(); // O(1)

        for (int j : arr) {
//            if (set.contains(j)) continue; // O(n)
            set.add(j);
//            list.add(j);
        }  // O(n)
//        Collections.sort(list); // O(nlogn)
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);
//        return list.stream().mapToInt(a -> a).toArray(); // O(n)
        return sortedList.stream().mapToInt(a -> a).toArray(); // O(n)
    }
}
//    O(nlogn)

//class HashSet {
//
//    Map<Integer, boolean> map = new HashMap<>();
//
//    public void add(Integer element) {
//        this.map.put(element, true);
//    }
//
//    public void contains(Integer element) {
//        return this.map.containsKey(element);
//    }
//
//}
//
//// new requirement
//public class CustomInteger {
//
//    private final Integer i;
//
//    public CustomInteger(Integer i) {
//        this.i = i;
//    }
//
//    public Integer getI() {
//        return i;
//    }
//    boolean eqauls(CustomInteger another){
//        return this.i == another.i;
//    }
//    int hashcode() {
//        return i;
//    }
//}
//
//
//class Solution {
//    CustomInteger[] uniqueSort(CustomInteger[] arr){
//
//        List<CustomInteger> list = new ArrayList<>();
//
//        Set<CustomInteger> set = new HashSet<>();
//
//        for(int i=0;i<arr.length;i++){
//            if(set.contains(arr[i])) continue;
//            set.add(arr[i]);
//            list.add(arr[i]);
//        }
//
//        Collections.sort(list, (a, b) -> a.getI() - b.getI() );
//        return list.toArray();
//    }
//}
//
//
////
//
//
//class Solution {
//    CustomInteger[] uniqueSort(CustomInteger[] arr){
//
//        // List<CustomInteger> list = new ArrayList<>();
//
//        Set<CustomInteger> set = new HashSet<>();
//
//        for(int i=0;i<arr.length;i++){
//            //if(set.contains(arr[i])) continue;
//            set.add(arr[i]);
//            // list.add(arr[i]);
//        }
//
//        Collections.sort(list, (a, b) -> a.getI() - b.getI() );
//        return list.toArray();
//    }
//}
//    O(nlogn)
