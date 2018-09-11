package string;

import java.util.HashSet;
import java.util.Set;

public class StringOfGivenLengthFromLetters {
    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c', 'd'};
        Set<String> result = generateStrings(chars, 5);
        for (String s : result) {
            System.out.println(s);
        }
        System.out.println("Size : " + result.size());
    }

    public static Set<String> generateStrings(final char[] letters, int length) {
        Set<String> result = new HashSet<>();
        if (length == 1) {
            for (char letter : letters) {
                result.add(String.valueOf(letter));
            }
            return result;
        }

        length--;

        for (int i = 0; i < letters.length; i++) {
            char currentLetter = letters[i];
            Set<String> temp = generateStrings(letters, length);
            for (String s : temp) {
                result.add(String.valueOf(currentLetter) + s);
            }
        }
        return result;
    }
}
