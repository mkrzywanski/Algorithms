import java.util.Arrays;

public class MoveZerosToRight {
    public static void main(String[] args) {
        int[] array = {1, 0, 1, 0, 1, 1, 1, 1, 1, 0,1,0,0};
        moveZerosToRight(array);
        System.out.println(Arrays.toString(array));
    }

    public static void moveZerosToRight(int[] array) {
        int leftIndex = 0;
        int rightIndex = array.length - 1;

        while (leftIndex < rightIndex) {
            while (leftIndex < array.length && array[leftIndex] != 0) {
                leftIndex++;
            }

            while (rightIndex > -1 && array[rightIndex] == 0) {
                rightIndex--;
            }
            if (leftIndex < array.length / 2) {
                swap(array, leftIndex, rightIndex);
            }

        }
    }

    public static void swap(int[] tab, int i, int j) {
        int temp;
        temp = tab[i];
        tab[i] = tab[j];
        tab[j] = temp;

//        int x = tab[i];
//        int y = tab[j];
//        x = x ^ y;
//        y= x ^ y;
//        x = x ^ y;
//        tab[i] = x;
//        tab[j] = y;
    }
}
