public class SumArrayRecursive {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(sumArrayRecursively(arr, 0));
        System.out.println(sumArrayRecursivelyFromBeginning(arr, arr.length - 1));
    }

    public static int sumArrayRecursively(int[] arr, int index) {
        if (index == arr.length - 1) {
            return arr[index];
        } else {
            return arr[index] + sumArrayRecursively(arr, index + 1);
        }
    }

    public static int sumArrayRecursivelyFromBeginning(int[] arr, int index) {
        if (index == 0) {
            return arr[index];
        } else {
            return arr[index] + sumArrayRecursivelyFromBeginning(arr, index - 1);
        }
    }
}
