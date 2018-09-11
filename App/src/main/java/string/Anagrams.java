package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {
    public static void main(String[] args) {
        String s1 = "krasa";
        String s2 = "raska";
        System.out.println(checkAnagrams(s1, s2));
        System.out.println(checkAnagrams2(s1, s2));
    }

    public static boolean checkAnagrams2(String text1, String text2) {
        if (text1.length() != text2.length()) {
            return false;
        }

        text1 = text1.replace(" ", "");
        text2 = text2.replace(" ", "");

        text1 = text1.toLowerCase();
        text2 = text2.toLowerCase();

        char[] charArrayText1 = text1.toCharArray();
        char[] charArrayText2 = text2.toCharArray();

        Arrays.sort(charArrayText1);
        Arrays.sort(charArrayText2);

        return Arrays.equals(charArrayText1, charArrayText2);

    }

    public static boolean checkAnagrams(String text1, String text2) {
        if (text1.length() != text2.length()) {
            return false;
        }

        text1 = text1.replace(" ", "");
        text2 = text2.replace(" ", "");

        text1 = text1.toLowerCase();
        text2 = text2.toLowerCase();

        Map<Character, Integer> characterMapText1 = createSignMapFromText(text1);
        Map<Character, Integer> characterMapText2 = createSignMapFromText(text2);

        return characterMapText1.equals(characterMapText2);

    }

    public static Map<Character, Integer> createSignMapFromText(String text) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char sign = text.charAt(i);
            Integer value = map.get(sign);
            if (value != null) {
                map.put(sign, ++value);
            } else {
                map.put(sign, 1);
            }
        }

        return map;
    }
}
