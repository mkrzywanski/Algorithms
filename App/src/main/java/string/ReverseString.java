package string;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        String word = "szkoła";
        System.out.println(reverseWithStack(word));
        System.out.println(reverseRecursion(word));
        System.out.println(reverseWithLoop(word));
    }

    public static String reverseWithStack(String word) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }

        StringBuilder stringBuilder = new StringBuilder();

        while (stack.size() > 0) {
            char sign = stack.pop();
            stringBuilder.append(sign);
        }

        return stringBuilder.toString();
    }

    public static String reverseRecursion(String text) {
        if (text.length() == 1) {
            return text;
        } else {
            char firstChar = text.charAt(0);
            return reverseRecursion(text.substring(1)) + firstChar;
        }
    }

    public static String reverseWithLoop(String word) {
        char[] letters = word.toCharArray();
        char temp;
        for (int i = 0, j = letters.length - 1; i < letters.length / 2; i++, j--) {
            temp = letters[i];
            letters[i] = letters[j];
            letters[j] = temp;
        }
        return new String(letters);
    }
}
