package string;

//Second word is an ananym of the first one if it is the same as the first word when we reverse it.
public class Ananyms {

    public static void main(String[] args) {
        String s1 = "Dog";
        String s2 = "God";
        System.out.println(checkAnanym(s1, s2));
    }

    public static boolean checkAnanym(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();

        word2 = reverseRecursion(word2);

        return word1.equals(word2);
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
