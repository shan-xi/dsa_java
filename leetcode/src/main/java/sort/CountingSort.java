package sort;

public class CountingSort {
    private static final int MAX_VALUE_TO_SORT = Integer.MAX_VALUE / 2;
    private static final int MIN_VALUE_TO_SORT = Integer.MIN_VALUE / 2;

    public void sort(int[] elements) {
        Boundaries boundaries = findBoundaries(elements);
        int[] counts = new int[boundaries.max - boundaries.min + 1];

        for (int element : elements) {
            counts[element - boundaries.min]++;
        }

        int targetPos = 0;
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                elements[targetPos++] = i + boundaries.min;
            }
        }
    }

    private Boundaries findBoundaries(int[] elements) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int element : elements) {
            if (element > MAX_VALUE_TO_SORT) {
                throw new IllegalArgumentException("Element " + element + " is greater than maximum " + MAX_VALUE_TO_SORT);
            }
            if (element < MIN_VALUE_TO_SORT) {
                throw new IllegalArgumentException("Element " + element + " is less than minimum " + MIN_VALUE_TO_SORT);
            }
            if (element > max) {
                max = element;
            }
            if (element < min) {
                min = element;
            }
        }

        return new Boundaries(min, max);
    }

    private static class Boundaries {
        private final int min;
        private final int max;

        public Boundaries(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
}
