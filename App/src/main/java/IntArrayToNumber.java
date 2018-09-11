import java.util.Arrays;

public class IntArrayToNumber {
    public static void main(String[] args) {
        int[] array = {9};
        System.out.println(convertToNumber(array));
        System.out.println(Arrays.toString(convertToNumber2(array)));
    }

    public static int convertToNumber(int[] array) {
        int multiple = 1;
        int sum = 0;

        for (int i = array.length - 1; i >= 0; i--) {
            sum += array[i] * multiple;
            multiple *= 10;
        }
        return sum + 1;
    }

    public static int[] convertToNumber2(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            int result = array[i] + 1;

            if (result != 10) {
                array[i] = result;
                return array;
            } else {
                array[i] = 0;
            }
        }

        int[] result = new int[array.length + 1];
        result[0] = 1;
        return result;
    }

}
