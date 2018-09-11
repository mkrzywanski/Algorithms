import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LengthOfNotRepeatedNumbersArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 1, 2, 1,6};
        System.out.println(lengthOfNotRepeatedNumbers(array));
        System.out.println(lengthOfDistinctElementsWithMap(array));
    }

    public static int lengthOfNotRepeatedNumbers(int[] array) {
        Arrays.sort(array);

        int currentNumberCount = 0;
        int distinctNumbers = 0;
        int previousElement = array[0];
        for (int i = 1; i < array.length; i++) {
            int currentElement = array[i];
            if (currentElement == previousElement) {
                currentNumberCount++;
            } else {
                if (currentNumberCount == 1 || currentNumberCount == 0) {
                    distinctNumbers++;
                }
                currentNumberCount = 0;
            }
            previousElement = currentElement;
        }
        return distinctNumbers;
    }

    public static int lengthOfDistinctElementsWithMap(int[] array) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < array.length; i++) {
            int currentElement = array[i];
            if(hashMap.containsKey(currentElement)) {
                int value = hashMap.get(currentElement);
                hashMap.put(currentElement, value + 1);
            } else {
                hashMap.put(currentElement, 1);
            }
        }

        int distinctNumbers = 0;
        for(Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if(entry.getValue() == 1) {
                distinctNumbers++;
            }
        }

        return distinctNumbers;
    }
}
