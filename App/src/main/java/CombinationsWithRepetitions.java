import java.util.*;

public class CombinationsWithRepetitions {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};

        Set<String> combinations = combinations(arr, 3);

        Set<String> result = new HashSet<>();
        for(String s : combinations) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            result.add(String.valueOf(chars));
        }

        System.out.println("Size : " + result.size());
        for (String combination : result) {
            System.out.println(combination);
        }
    }

    public static Set<String> combinations(int[] array, int r) {
        Set<String> variationsWithRepetitions = variationsWithRepetitions(array, r);
        Set<String> result = new HashSet<>();
        for(String variation : variationsWithRepetitions) {
            char[] variationChars = variation.toCharArray();
            Arrays.sort(variationChars);
            result.add(String.valueOf(variationChars));
        }
        return result;
    }

    public static Set<String> variationsWithRepetitions(int[] array, int r) {
        Set<String> resultVariations = new HashSet<>();
        if (r == 1) {
            for (int i = 0; i < array.length; i++) {
                String singleElement = String.valueOf(array[i]);
                resultVariations.add(singleElement);
            }
        } else {
            r--;
            for (int i = 0; i < array.length; i++) {
                int currentElement = array[i];
                Set<String> variationsSet = variationsWithRepetitions(array, r);
                for (String variation : variationsSet) {
                    resultVariations.add(String.valueOf(currentElement) + variation);
                }
            }
        }
        return resultVariations;
    }
}
