import java.util.LinkedList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        char[] chars = {'a', 'v', 'c', 'd'};
        List<List<String>> combinations = combinations(chars, 4);
        for (List<String> l : combinations) {
            for (String s : l) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public static List<List<String>> combinations(final char[] chars, int k) {
        List<List<String>> combinations = new LinkedList<>();
        for (int currentBinaryCombination = 0; currentBinaryCombination < (1 << chars.length); currentBinaryCombination++) {
            List<String> combination = new LinkedList<>();
            for (int charIndex = 0; charIndex < chars.length; charIndex++) {
                if ((currentBinaryCombination & (1 << charIndex)) > 0) {
                    combination.add(String.valueOf(chars[charIndex]));
                }
            }
            if (combination.size() == k) {
                combinations.add(combination);
            }
        }
        return combinations;
    }
}
