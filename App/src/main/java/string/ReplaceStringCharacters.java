package string;

public class ReplaceStringCharacters {
    public static void main(String[] args) {
        String word = "Java";
        System.out.println(replaceChar(word, 'a', 'u'));
    }

    public static String replaceChar(String word, char signToReplace, char replacement) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = word.toCharArray();
        for(char c : chars) {
            if(c == signToReplace) {
                stringBuilder.append(replacement);
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
