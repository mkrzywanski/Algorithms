import java.util.Arrays;

public class CheckIfTwoStringsAreRotation {
    public static void main(String[] args) {
        String word1 = "abcd";
        String word2 = "dabc";

        System.out.println(checkIfRotations(word1, word2));
        System.out.println(checkIfRotation2(word1, word2));

        char[] array = {'a', 'b', 'c'};

        rotate(array);
        rotate(array);

        System.out.println(Arrays.toString(array));
    }

    public static boolean checkIfRotations(String word1, String word2) {
        int end = word1.length() - 1;
        for (int i = 0; i < word1.length(); i++) {
            char sign = word1.charAt(end);
            String word1WithoutLastChar = word1.substring(0, end);

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(sign);
            stringBuilder.append(word1WithoutLastChar);

            if (stringBuilder.toString().equals(word2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkIfRotation2(String word1, String word2) {
        char[] chars = word1.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            rotate(chars);
            if (new String(chars).equals(word2)) {
                return true;
            }
        }
        return false;
    }

    private static void rotate(char[] array) {
        if (array.length == 0) {
            return;
        }

        char prev = array[0];
        for (int i = 0; i < array.length; i++) {
            int nextIndex = (i + 1) % array.length;
            char sign = array[nextIndex];
            array[nextIndex] = prev;
            prev = sign;
        }
    }
}
