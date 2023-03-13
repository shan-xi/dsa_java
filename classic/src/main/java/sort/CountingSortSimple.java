package sort;

public class CountingSortSimple {
    public void sort(int[] elements) {
        int maxValue = findMax(elements);
        int[] counts = new int[maxValue + 1];

        for (int element : elements) {
            counts[element]++;
        }

        int targetPos = 0;
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                elements[targetPos++] = i;
            }
        }
    }

    private int findMax(int[] elements) {
        int max = 0;
        for (int element : elements) {
            if (element < 0) {
                throw new IllegalArgumentException("not support");
            }
            if (element > max) {
                max = element;
            }
        }
        return max;
    }
}
