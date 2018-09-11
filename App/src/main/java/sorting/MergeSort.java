package sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] array) {
        mergeSortRec(array, 0, array.length - 1);
    }

    private static void mergeSortRec(int[] array, int beginIndex, int endIndex) {
        if (beginIndex < endIndex) {
            int pivot = (beginIndex + endIndex) / 2;
            mergeSortRec(array, beginIndex, pivot);
            mergeSortRec(array, pivot + 1, endIndex);
            merge(array, beginIndex, pivot, endIndex);
        }
    }

    private static void merge(int[] array, int begin, int mid, int end) {
        int firstSequenceLength = mid - begin + 1;
        int secondSequenceLength = end - mid;

        int[] firstSequence = new int[firstSequenceLength];
        int[] secondSequence = new int[secondSequenceLength];

        for (int i = 0; i < firstSequenceLength; i++) {
            firstSequence[i] = array[begin + i];
        }

        for (int i = 0; i < secondSequenceLength; i++) {
            secondSequence[i] = array[mid + i + 1];
        }

        int i = 0;
        int j = 0;

        int arrIndex = begin;
        while (i < firstSequenceLength && j < secondSequenceLength) {
            if (firstSequence[i] < secondSequence[j]) {
                array[arrIndex] = firstSequence[i];
                i++;
            } else {
                array[arrIndex] = secondSequence[j];
                j++;
            }
            arrIndex++;
        }


        while (i < firstSequenceLength) {
            array[arrIndex] = firstSequence[i];
            i++;
            arrIndex++;
        }

        while (j < secondSequenceLength) {
            array[arrIndex] = secondSequence[j];
            j++;
            arrIndex++;
        }
    }
}
