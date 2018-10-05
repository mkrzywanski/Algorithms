import java.util.HashSet;
import java.util.Set;

public class GenerateAllPossibleSubstrings {
    public static void main(String[] args) {
        String word = "java2novice";
        Set<String> result = generateAllSubstrings(word);

        for (String s : result) {
            System.out.println(s);
        }

        System.out.println("Longest : " + findLongestNonrepeatingSubstring(result));
    }

    public static Set<String> generateAllSubstrings(String word) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < word.length() - 1; i++) {
            for (int j = i; j < word.length() + 1; j++) {
                set.add(word.substring(i, j));
            }
        }
        return set;
    }

    public static String findLongestNonrepeatingSubstring(Set<String> set) {
        String longest = "";
        Set<Character> characterHashSet = new HashSet<>();
        for (String substring : set) {
            char[] chars = substring.toCharArray();
            for (char c : chars) {
                if (characterHashSet.contains(c)) {
                    break;
                } else {
                    characterHashSet.add(c);
                }
            }
            if (substring.length() == characterHashSet.size() && longest.length() < substring.length()) {
                longest = substring;
            }
            characterHashSet.clear();
        }
        return longest;
    }
}
