package sorting;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 5, 6,2};
        countSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void countSort(int[] array) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }

        int[] countArray = new int[max - min + 1];

        for (int i = 0; i < array.length; i++) {
            int index = array[i] - min;
            countArray[index] += 1;
        }
        int index = 0;
        for (int i = 0; i < countArray.length; i++) {
            int count = countArray[i];
            int value = i + min;
            for (int j = 0; j < count; j++) {
                array[index] = value;
                index++;
            }
        }
    }
}
