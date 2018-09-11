package string;

//This is how to implement a method to convert numeric string to integer without using Java API
public class NumericStringToInt {
    public static void main(String[] args) {
        String stringNumber = "1234774745";
        int result = convertToInt(stringNumber);
        System.out.println(result);
    }

    public static int convertToInt(String numberString) {
        int result = 0;
        int power = numberString.length() - 1;
        char[] chars = numberString.toCharArray();
        for (char digit : chars) {
            int digitInt = digit - 48;
            int difference = digitInt * (int) Math.pow(10, power);
            result += difference;
            power--;
        }
        return result;
    }
}
