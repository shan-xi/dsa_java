package topic.priority_queue._295_Find_Median_from_Data_Stream;

public class MedianFinder2 {
    private final int[] count;
    private int totalCount;

    public MedianFinder2() {
        count = new int[101]; // Since numbers are in the range [0, 100]
        totalCount = 0;
    }

    public static void main(String[] args) {
        MedianFinder2 medianFinder = new MedianFinder2();

        // Test case 1
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian()); // Output: 1.5

        // Test case 2
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian()); // Output: 2
    }

    public void addNum(int num) {
        count[num]++;
        totalCount++;
    }

    public double findMedian() {
        int mid = totalCount / 2;
        int currentCount = 0;

        if (totalCount % 2 == 1) {
            // Total count is odd, find the middle element
            for (int i = 0; i < count.length; i++) {
                currentCount += count[i];
                if (currentCount > mid) {
                    return i;
                }
            }
        } else {
            // Total count is even, find the average of the two middle elements
            int first = -1, second = -1;
            for (int i = 0; i < count.length; i++) {
                currentCount += count[i];
                if (currentCount > mid - 1 && first == -1) {
                    first = i;
                }
                if (currentCount > mid && second == -1) {
                    second = i;
                    return (first + second) / 2.0;
                }
            }
        }
        return -1; // This line should never be reached if input is correct
    }
}

