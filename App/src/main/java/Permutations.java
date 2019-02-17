import java.util.*;

//Permutations with and without repetitions.
public class Permutations {
    public static void main(String[] args) {
        char[] tab = {'k','o','l','k'};
        findPermutations(tab);
    }

    public static void findPermutations(char[] tab) {
        Set<String> permutations = permute(tab);
        System.out.println("Size : " + permutations.size());

        int index = 0;
        for (String text : permutations) {
            System.out.println(index + " " + text);
            index++;
        }
    }

    public static Set<String> permute(char[] tab) {
        Set<String> resultPermutations = new HashSet<>();

        if (tab.length == 1) {
            resultPermutations.add(String.valueOf(tab[0]));
            return resultPermutations;
        }

        char currentElement = tab[0];
        char[] arrayWithoutFirstElement = new char[tab.length - 1];

        for (int i = 1; i < tab.length; i++) {
            arrayWithoutFirstElement[i - 1] = tab[i];
        }

        Set<String> currentPermutations = permute(arrayWithoutFirstElement);

        for (String permutation : currentPermutations) {
            for (int j = 0; j < permutation.length() + 1; j++) {
                String begin = permutation.substring(0, j);
                String end = permutation.substring(j);
                resultPermutations.add(begin + currentElement + end);
            }
        }

        return resultPermutations;
    }
}
