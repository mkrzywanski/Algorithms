package sorting.selectionSort;

import java.util.Arrays;
import java.util.Comparator;

public class SelectionSortAlgorithm {
    private Comparator<Integer> comparator;

    public SelectionSortAlgorithm(Comparator<Integer> comparator) {
        this.comparator = comparator;
    }

    public int[] sort(int[] array) {
        int[] sortedArray = new int[array.length];

        int length = array.length;

        for(int i = 0; i < length; i++) {
            int index = findElementIndex(array);
            sortedArray[i] = array[index];
            array = deleteElementAt(array, index);
        }
        return sortedArray;
    }

    private int findElementIndex(int[] array) {
        int maxValue = array[0];
        int maxIndex = 0;
        for(int i = 0; i < array.length; i++) {
            if(comparator.compare(maxValue, array[i]) >= 1) {
                maxIndex = i;
                maxValue = array[i];
            }
        }
        return maxIndex;
    }

    private int[] deleteElementAt(int[] array, int index) {
        int[] result = new int[array.length-1];
        for(int i = 0, j = 0; j < result.length;i++, j++) {
            if(i == index) {
                i++;
            }
            result[j] = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {4,3,1,6,8,9,9,9};

        Comparator<Integer> naturalOrderComparator = Comparator.naturalOrder();
        SelectionSortAlgorithm selectionSortAlgorithm = new SelectionSortAlgorithm(naturalOrderComparator);

        array = selectionSortAlgorithm.sort(array);

        System.out.println(Arrays.toString(array));
    }
}
