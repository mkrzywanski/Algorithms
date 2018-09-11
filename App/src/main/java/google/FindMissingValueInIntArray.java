package google;

import java.util.Arrays;
//?????????????????????
public class FindMissingValueInIntArray {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 5};
        System.out.println(findMissingElementSum(array));
    }

    public static int findMissingElement(int[] array) {
        Arrays.sort(array);
        int leftIndex = 0;
        int rightIndex = array.length - 1;

        while (leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            int midValue = array[midIndex];

            int beforeMid = array[midIndex-1];
            if(midIndex != midValue) {
                if(beforeMid == midIndex -1) {
                    return midIndex;
                }
            }

            if(midValue != midIndex) {
                leftIndex = midIndex;
            } else {
                rightIndex = leftIndex + 1;
            }


        }
        return 1;
    }

    public static int findMissingElementSum(int[] array) {
        Arrays.sort(array);

        int sumArray = 0;
        int sumIndex = 0;
        for (int i = 0; i < array.length; i++) {
            sumArray += array[i];
            sumIndex += i;
        }
        return sumArray - sumIndex;
    }
}
