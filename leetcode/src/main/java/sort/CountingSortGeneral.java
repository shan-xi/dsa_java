package sort;

public class CountingSortGeneral {
    public void sort(int[] elements) {
        int maxValue = findMax(elements);
        int[] counts = new int[maxValue + 1];

        for (int ele : elements) {
            counts[ele]++;
        }

        for (int i = 1; i <= maxValue; i++) {
            counts[i] += counts[i - 1];
        }

        int[] target = new int[elements.length];
        for (int i = elements.length - 1; i >= 0; i--) {
            int element = elements[i];
            target[--counts[element]] = element;
        }

        System.arraycopy(target, 0, elements, 0, elements.length);
    }

    private int findMax(int[] elements) {
        int max = 0;
        for (int ele : elements) {
            if (ele < 0) {
                throw new IllegalArgumentException("not support");
            }
            if (ele > max) {
                max = ele;
            }
        }
        return max;
    }
}
