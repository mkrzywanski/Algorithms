package string;

public class LongestCommonSubsequence {
    //Invoking method with text strings in different order gives two longest subsequences
    //Another solution would be changing conditional statements inside while loop to move to the left column first instead to higher row.
    public static String longestCommonSubsequence(String firstWord, String secondWord) {
        int subsequenceArrayRowsAmount = firstWord.length() + 1;
        int subsequenceArrayColumnsAmount = secondWord.length() + 1;

        int[][] sequenceCounters = new int[subsequenceArrayRowsAmount][subsequenceArrayColumnsAmount];
        for (int i = 1; i < subsequenceArrayRowsAmount; i++) {
            for (int j = 1; j < subsequenceArrayColumnsAmount; j++) {
                if (firstWord.charAt(i - 1) == secondWord.charAt(j - 1)) {
                    sequenceCounters[i][j] = sequenceCounters[i - 1][j - 1] + 1;
                } else {
                    sequenceCounters[i][j] = Math.max(sequenceCounters[i - 1][j], sequenceCounters[i][j - 1]);
                }
            }
        }

        int longestCommonSubsequenceLength = sequenceCounters[firstWord.length()][secondWord.length()];

        int rowIndex = firstWord.length();
        int columnIndex = secondWord.length();

        StringBuilder stringBuilder = new StringBuilder();

        while (rowIndex > 0 && columnIndex > 0) {
            if (sequenceCounters[rowIndex - 1][columnIndex] == longestCommonSubsequenceLength) {
                rowIndex -= 1;
                continue;
            } else if (sequenceCounters[rowIndex][columnIndex - 1] == longestCommonSubsequenceLength) {
                columnIndex -= 1;
                continue;
            }
            stringBuilder.append(firstWord.charAt(rowIndex - 1));
            rowIndex--;
            columnIndex--;
            longestCommonSubsequenceLength = sequenceCounters[rowIndex][columnIndex];
        }

        return reverseString(stringBuilder.toString());
    }

    public static void main(String[] args) {
        String s1 = "abaabbaaa";
        String s2 = "babab";

        System.out.println(longestCommonSubsequence(s1, s2));
        System.out.println(longestCommonSubsequence(s2, s1));

        s1 = "politechnika";
        s2 = "toaleta";

        System.out.println(longestCommonSubsequence(s1, s2));
        System.out.println(longestCommonSubsequence(s2, s1));


    }

    public static String reverseString(String text) {
        if(text.length() == 1) {
            return text;
        } else {
            char firstChar = text.charAt(0);
            return reverseString(text.substring(1)) + firstChar;
        }
    }
}
