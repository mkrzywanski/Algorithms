public class FindSumIndex {
    public static void main(String[] args) {
        int[] array = {1, 1, 2, 1, 1, 3};
        System.out.println(findIndex(array));
    }

    public static int findIndex(int[] array) {
        int sumLeft = array[0];
        int sumRight = array[array.length - 1];

        int i = 1;
        int j = array.length - 2;
        while (i < j) {
            if (sumLeft < sumRight) {
                sumLeft += array[i];
                i++;
            } else {
                sumRight += array[j];
                j--;
            }
        }
        if (sumLeft == sumRight) {
            return i;
        }
        return -1;
    }
}
