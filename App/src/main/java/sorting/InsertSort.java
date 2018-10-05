package sorting;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] array = {5, 3, 2, 4, 1, 1, 2};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int tempIndex = i - 1;
            int temp;
            while (tempIndex >= 0 && array[tempIndex] > value) {
                temp = array[tempIndex];
                array[tempIndex] = array[tempIndex + 1];
                array[tempIndex + 1] = temp;
                tempIndex--;
            }
        }
    }
}
