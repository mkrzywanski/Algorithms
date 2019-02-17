import java.util.HashSet;
import java.util.Set;

public class FindLongestSubtringWithoutGivenChars {
    public static void main(String[] args) {
        Set<Character> characters = new HashSet<>();
        characters.add('a');
        characters.add('b');
        characters.add('c');
        String word = "awuloikaeb";
        System.out.println(findLongestSubstringWithoutChars(word, characters));
        System.out.println(solution2(word, characters));
    }

    public static String findLongestSubstringWithoutChars(String word, Set<Character> characters) {
        char[] wordChars = word.toCharArray();

        int currentLength = 0;
        int maxLength = 0;
        int beginIndex = 0;
        int endIndex = 0;
        int longestSubstringBeginIndex = 0;
        int longestSubstringEndIndex = 0;

        for (int i = 0; i < wordChars.length; i++) {
            currentLength = 0;
            beginIndex = i;
            for (int j = i; j < wordChars.length; j++) {
                if (!characters.contains(wordChars[j])) {
                    currentLength++;
                } else {
                    break;
                }
                endIndex = j + 1;
            }
            if (currentLength > maxLength) {
                maxLength = currentLength;
                longestSubstringBeginIndex = beginIndex;
                longestSubstringEndIndex = endIndex;
            }
        }
        return word.substring(longestSubstringBeginIndex, longestSubstringEndIndex);
    }

    public static String solution2(String word, Set<Character> characters) {
        char[] chars = word.toCharArray();
        int currentLength = 0;
        int maxLength = 0;
        int beginIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];
            if (characters.contains(currentChar)) {
                currentLength = 0;
                continue;
            } else {
                currentLength++;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    endIndex = i + 1;
                    beginIndex = endIndex - maxLength;
                }
            }
        }
        return word.substring(beginIndex, endIndex);
    }

}
