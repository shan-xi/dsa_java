package topic._1418_Display_Table_of_Food_Orders_in_a_Restaurant;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        // Create a list of orders
        List<List<String>> orders = new ArrayList<>();
        orders.add(Arrays.asList("David", "3", "Ceviche"));
        orders.add(Arrays.asList("Corina", "10", "Beef Burrito"));
        orders.add(Arrays.asList("David", "3", "Fried Chicken"));
        orders.add(Arrays.asList("Carla", "5", "Water"));
        orders.add(Arrays.asList("Carla", "5", "Ceviche"));
        orders.add(Arrays.asList("Rous", "3", "Ceviche"));

        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Call the displayTable method
        List<List<String>> resultTable = solution.displayTable(orders);

        // Print the result in a readable format
        for (List<String> row : resultTable) {
            System.out.println(String.join(", ", row));
        }
    }

    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeMap<Integer, TreeMap<String, Integer>> treeMap = new TreeMap<>();
        TreeSet<String> foodItemSet = new TreeSet<>();
        for (List<String> order : orders) {
            int tableNumber = Integer.parseInt(order.get(1));
            treeMap.putIfAbsent(tableNumber, new TreeMap<>());
            String foodItem = order.get(2);
            foodItemSet.add(foodItem);
            TreeMap<String, Integer> foodCount = treeMap.get(tableNumber);
            foodCount.put(foodItem, foodCount.getOrDefault(foodItem, 0) + 1);
        }

        List<List<String>> result = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("Table");
        header.addAll(foodItemSet);
        result.add(header);
        for (Map.Entry<Integer, TreeMap<String, Integer>> t : treeMap.entrySet()) {
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(t.getKey()));
            for (String s : foodItemSet) {
                TreeMap<String, Integer> foodCount = t.getValue();
                row.add(String.valueOf(foodCount.getOrDefault(s, 0)));
            }
            result.add(row);
        }
        return result;
    }
}
