import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.println(binarySearch(array, 2));
        System.out.println(binarySearchRecursive(array, 2, 0, array.length - 1));
    }

    public static int binarySearch(int[] array, int value) {
        int leftIntervalIndex = 0;
        int rightIntervalIndex = array.length - 1;

        Arrays.sort(array);

        while (leftIntervalIndex <= rightIntervalIndex) {
            int middleIndex = (rightIntervalIndex + leftIntervalIndex) / 2;
            int middleValue = array[middleIndex];
            if (rightIntervalIndex == leftIntervalIndex && middleValue != value) {
                return -1;
            }

            if (middleValue == value) {
                return middleIndex;
            } else if (value < middleValue) {
                rightIntervalIndex = middleIndex;
            } else {
                leftIntervalIndex = middleIndex + 1;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] array, int value, int leftIndex, int rightIndex) {
        int middleIndex = (rightIndex + leftIndex) / 2;
        int middleValue = array[middleIndex];

        if (rightIndex == leftIndex && middleValue != value) {
            return -1;
        }

        if (middleValue == value) {
            return middleIndex;
        } else if (value < middleValue) {
            rightIndex = middleIndex;
        } else {
            leftIndex = middleIndex + 1;
        }

        return binarySearchRecursive(array, value, leftIndex, rightIndex);
    }
}
