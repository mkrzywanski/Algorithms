import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 6, 7, 8};
        int[] arr2 = {1, 2, 5, 7, 8};
        System.out.println(Arrays.toString(mergeSortedArray(arr1, arr2)));
    }

    public static int[] mergeSortedArray(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];

        int a1Index = 0;
        int a2Index = 0;
        int resultIndex = 0;

        while (a1Index < array1.length && a2Index < array2.length) {
            if (array1[a1Index] < array2[a2Index]) {
                result[resultIndex] = array1[a1Index];
                a1Index++;
            } else {
                result[resultIndex] = array2[a2Index];
                a2Index++;
            }
            resultIndex++;
        }

        while (a1Index < array1.length) {
            result[resultIndex] = array1[a1Index];
            resultIndex++;
            a1Index++;
        }
        while (a2Index < array2.length) {
            result[resultIndex] = array2[a2Index];
            resultIndex++;
            a2Index++;
        }
        return result;
    }
}
