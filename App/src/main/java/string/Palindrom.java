package string;

import java.util.Arrays;

public class Palindrom {
    public static void main(String[] args) {
        String s1 = "Do geese see God";
        String s2 = "dog ees eseeg od";
        System.out.println(checkPalindrom(s1, s2));
        System.out.println(checkPalindrom2(s1, s2));
    }

    public static boolean checkPalindrom(String sentence1, String sentence2) {
        if (sentence1.length() != sentence2.length()) {
            return false;
        }

        sentence1 = sentence1.replace(" ", "");
        sentence2 = sentence2.replace(" ", "");

        sentence1 = sentence1.toLowerCase();
        sentence2 = sentence2.toLowerCase();

        sentence2 = reverseRecursion(sentence2);

        char[] sentence1charArray = sentence1.toCharArray();
        char[] sentence2charArray = sentence2.toCharArray();

        return Arrays.equals(sentence1charArray, sentence2charArray);
    }

    public static boolean checkPalindrom2(String sentence1, String sentence2) {
        if (sentence1.length() != sentence2.length()) {
            return false;
        }

        sentence1 = sentence1.replace(" ", "");
        sentence2 = sentence2.replace(" ", "");

        sentence1 = sentence1.toLowerCase();
        sentence2 = sentence2.toLowerCase();

        for (int i = 0, j = sentence2.length() - 1; i < sentence1.length() / 2; i++, j--) {
            if (sentence1.charAt(i) != sentence2.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    public static String reverseRecursion(String text) {
        if (text.length() == 1) {
            return text;
        } else {
            char firstChar = text.charAt(0);
            return reverseRecursion(text.substring(1)) + firstChar;
        }
    }
}
