package sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {7, 2, 4, 7, 3, 1, 4, 6, 5, 8, 3, 9, 2, 6, 7, 6, 3};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

    }

    public static void swapElements(int[] array, int firstElementIndex, int secondElementIndex) {
        int temp;
        temp = array[firstElementIndex];
        array[firstElementIndex] = array[secondElementIndex];
        array[secondElementIndex] = temp;
    }

    public static void quickSort(int[] array, int leftIndex, int rightIndex) {
        int pivotIndex = (rightIndex + leftIndex) / 2;
        int pivotElement = array[pivotIndex];

        swapElements(array, pivotIndex, rightIndex);

        int i = leftIndex, j = leftIndex;

        while (i < rightIndex) {
            if (array[i] < pivotElement) {
                swapElements(array, i, j);
                j++;
            }
            i++;
        }

        swapElements(array, j, rightIndex);

        if (leftIndex < j - 1)
            quickSort(array, leftIndex, j - 1);
        if (rightIndex > j + 1)
            quickSort(array, j + 1, rightIndex);
    }


}
