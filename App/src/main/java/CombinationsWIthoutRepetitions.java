import java.util.*;

public class CombinationsWIthoutRepetitions {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};

        Set<String> combinations = combinations(arr, 4);

        Set<String> result = new HashSet<>();
        for(String st : combinations) {
            char[] charArray = st.toCharArray();
            Arrays.sort(charArray);
            result.add(String.valueOf(charArray));
        }

        System.out.println("Size : " + result.size());
        for (String combination : result) {
            System.out.println(combination);
        }
    }

    public static Set<String> combinations(int[] array, int r) {
        Set<String> resultCombinations = new HashSet<>();
        if (r == 1) {
            for (int i = 0; i < array.length; i++) {
                String val = String.valueOf(array[i]);
                resultCombinations.add(val);
            }
        } else {
            r--;
            for (int i = 0; i < array.length; i++) {
                int element = array[i];
                int[] newTab = cutElement(array, i);
                Set<String> combs = combinations(newTab, r);
                for (String s : combs) {
                    resultCombinations.add(String.valueOf(element) + s);
                }
            }
        }
        return resultCombinations;
    }


    public static int[] cutElement(int[] array, int index) {
        int[] newTab = new int[array.length - 1];
        int arrayIndex = 0;
        int newTabIndex = 0;
        while (newTabIndex < newTab.length) {
            if (index != arrayIndex) {
                newTab[newTabIndex] = array[arrayIndex];
                arrayIndex++;
                newTabIndex++;
            } else {
                arrayIndex++;
            }
        }
        return newTab;
    }

}
