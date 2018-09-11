import java.util.HashSet;
import java.util.Set;

public class VariationsWithRepetitions {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};

        Set<String> combinations = variations(arr, 4);

        System.out.println("Size : " + combinations.size());
        for (String combination : combinations) {
            System.out.println(combination);
        }
    }

    public static Set<String> variations(int[] array, int r) {
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
                Set<String> variationsSet = variations(array, r);
                for (String variation : variationsSet) {
                    resultVariations.add(String.valueOf(currentElement) + variation);
                }
            }
        }
        return resultVariations;
    }
}
