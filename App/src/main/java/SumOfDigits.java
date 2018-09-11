public class SumOfDigits {
    public static void main(String[] args) {
        int number = 1234;
        System.out.println(sumOfDigits(number));
    }

    public static int sumOfDigits(int number) {
        if (number < 10) {
            return number;
        }

        int currentNumber = number % 10;

        return currentNumber + sumOfDigits(number / 10);
    }
}
