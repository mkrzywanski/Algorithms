public class DecimalToBinary {
    public static void main(String[] args) {
        int number = 24;
        System.out.println(decimalToBinary(number));
    }

    public static String decimalToBinary(int number) {
        StringBuilder result = new StringBuilder();

        while (number != 0) {
            int rest = number % 2;
            result.append(rest);
            number /= 2;
        }
        return result.reverse().toString();
    }


}
