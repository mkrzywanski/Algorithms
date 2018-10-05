import java.util.HashSet;
import java.util.Set;

public class VariationsWithoutRepetitions {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};

        Set<String> combinations = variations(arr, 2);

        System.out.println("Size : " + combinations.size());
        for (String combination : combinations) {
            System.out.println(combination);
        }
    }

    public static Set<String> variations(int[] array, int k) {
        Set<String> resultVariations = new HashSet<>();
        if (k == 1) {
            for (int i = 0; i < array.length; i++) {
                String variation = String.valueOf(array[i]);
                resultVariations.add(variation);
            }
        } else {
            k--;
            for (int i = 0; i < array.length; i++) {
                int currentElement = array[i];
                int[] arrayWithoutCurrentElement = removeElementByIndex(array, i);
                Set<String> variations = variations(arrayWithoutCurrentElement, k);
                for (String variation : variations) {
                    resultVariations.add(String.valueOf(currentElement) + variation);
                }
            }
        }
        return resultVariations;
    }


    public static int[] removeElementByIndex(int[] array, int index) {
        int[] resultArray = new int[array.length - 1];

        int arrayIndex = 0;
        int resultArrayIndex = 0;

        while (resultArrayIndex < resultArray.length) {
            if (index != arrayIndex) {
                resultArray[resultArrayIndex] = array[arrayIndex];
                arrayIndex++;
                resultArrayIndex++;
            } else {
                arrayIndex++;
            }
        }

        return resultArray;
    }
}
