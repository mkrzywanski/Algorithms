package google;

import java.util.ArrayList;
import java.util.List;

public class WordSquares {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("BALL");
        strings.add("AREA");
        strings.add("LEAD");
        strings.add("LADY");
        System.out.println(check(strings));
    }
    public static boolean check(List<String> words) {
        int wordIndex = 0;
        for(String word : words) {
            int firstWordCharIndex = 0;
            int secondWordCharIndex = wordIndex;
            for (String word2 : words) {
                if (!(word.charAt(firstWordCharIndex) == word2.charAt(secondWordCharIndex))) {
                    return false;
                }
                firstWordCharIndex++;
            }
            wordIndex++;
        }
        return true;
    }
}
