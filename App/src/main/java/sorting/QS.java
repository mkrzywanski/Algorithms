package sorting;

import java.util.Arrays;

public class QS {
    public static void main(String[] args) {
        int[] tab = {1, 2, 5, 6, 74, 3, 4, 5, 6, 7, 3};
        qs(tab, 0, tab.length - 1);
        System.out.println(Arrays.toString(tab));
    }

    public static void qs(int[] tab, int low, int high) {
        int i = low;
        int j = high;

        int pivot = tab[(low + high) / 2];

        while (i <= j) {
            while (tab[i] < pivot) {
                i++;
            }
            while (tab[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(tab, i, j);
                i++;
                j--;
            }
        }

        if (low < j) {
            qs(tab, low, j);
        }

        if (high > i) {
            qs(tab, i, high);
        }
    }

    public static void swap(int[] tab, int i, int j) {
        int temp;
        temp = tab[i];
        tab[i] = tab[j];
        tab[j] = temp;
    }
}
