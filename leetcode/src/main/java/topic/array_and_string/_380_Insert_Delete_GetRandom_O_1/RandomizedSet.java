package topic.array_and_string._380_Insert_Delete_GetRandom_O_1;

import java.util.*;

public class RandomizedSet {

    private final Map<Integer, Integer> map; // maps value to its index in the list
    private final List<Integer> list;        // stores values
    private final Random random;             // for generating random index

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();

        System.out.println(randomizedSet.insert(1));   // true
        System.out.println(randomizedSet.remove(2));   // false
        System.out.println(randomizedSet.insert(2));   // true
        System.out.println(randomizedSet.getRandom()); // 1 or 2
        System.out.println(randomizedSet.remove(1));   // true
        System.out.println(randomizedSet.insert(2));   // false
        System.out.println(randomizedSet.getRandom()); // 2
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        // Move the last element to the place of the element to delete
        int lastElement = list.get(list.size() - 1);
        int index = map.get(val);
        list.set(index, lastElement);
        map.put(lastElement, index);

        // Remove the last element
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
