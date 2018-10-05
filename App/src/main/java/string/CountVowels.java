package string;

import java.util.HashSet;
import java.util.Set;

public class CountVowels {
    public static void main(String[] args) {

    }

    public static void countVowels(String word) {
        int vowelsCount = 0;
        int other = 0;

        Set<Character> vowels = new HashSet<>();

        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('y');
        vowels.add('o');

        for(char c : word.toCharArray()) {
            if(vowels.contains(c)) {
                vowelsCount++;
            } else {
                other++;
            }
        }
        System.out.println("Vowels : " + vowelsCount);
        System.out.println("Not vowels : " + other);
    }
}
