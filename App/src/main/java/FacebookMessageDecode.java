import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FacebookMessageDecode {
    static Map<Integer, Character> map = new HashMap<>();

    public static void main(String[] args) {
        initializeMap();
        Set<String> result = decode("1234");
        System.out.println("Size : " + result.size());
        for (String s : result) {
            System.out.println(s);
        }
    }

    private static Set<String> decode(String message) {
        Set<String> result = new HashSet<>();
        if (message.length() == 0) {
            result.add("");
            return result;
        }
        if (message.length() == 1) {
            Character characterMapping = map.get(Integer.valueOf(message));
            result.add(String.valueOf(characterMapping));
            return result;
        }

        String restMessage = message.substring(1);

        Set<String> subresult = decode(restMessage);

        Character firstDigit = message.charAt(0);
        Integer firstDigitInt = Character.getNumericValue(firstDigit);
        Character firstDigitToChar = map.get(firstDigitInt);

        for (String s : subresult) {
            result.add(firstDigitToChar + s);
        }

        String twoDigits = message.substring(0, 2);
        Integer twoDigitsMapping = Integer.valueOf(twoDigits);
        Character twoDigitsToChar = map.get(twoDigitsMapping);

        if (twoDigitsToChar != null) {
            restMessage = message.substring(2);
            subresult = decode(restMessage);
            for (String s : subresult) {
                result.add(twoDigitsToChar + s);
            }
        }

        return result;
    }

    static void initializeMap() {
        for (int i = 'a'; i <= 'z'; i++) {
            map.put(i - 96, (char) i);
        }
    }

}
