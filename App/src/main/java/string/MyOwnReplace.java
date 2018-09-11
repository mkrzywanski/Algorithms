package string;

public class MyOwnReplace {
    public static void main(String[] args) {
        String word = "aabb";
        System.out.println(replace(word, 'a', 'x'));
    }


    public static String replace(String word, char charToReplace, char replacement) {
        char[] chars = word.toCharArray();
        for(int i = 0; i < chars.length;i++) {
            if(chars[i] == charToReplace) {
                chars[i] = replacement;
            }
        }
        return new String(chars);
    }
}
