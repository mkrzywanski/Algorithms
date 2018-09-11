package google;

public class CheckShuffle {
    public static void main(String[] args) {
        String first = "abc";
        String second = "def";
        String third = "dabecf";
        System.out.println(isShuffle(first, second, third));
    }

    public static boolean isShuffle(String word1, String word2, String potentialShuffle) {
        if (word1.length() + word2.length() != potentialShuffle.length()) {
            return false;
        }

        int w1index = 0;
        int w2index = 0;

        char[] w1chars = word1.toCharArray();
        char[] w2chars = word2.toCharArray();
        char[] potentialShuffleChars = potentialShuffle.toCharArray();

        for (int i = 0; i < potentialShuffleChars.length; i++) {
            char sign = potentialShuffleChars[i];
            if (w1index < w1chars.length && sign == w1chars[w1index]) {
                w1index++;
            } else if (w2index < w2chars.length && sign == w2chars[w2index]) {
                w2index++;
            } else {
                return false;
            }
        }
        return true;
    }
}
