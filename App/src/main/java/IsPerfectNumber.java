public class IsPerfectNumber {
    public static void main(String[] args) {
        int number = 28;
        System.out.println(isPerfectNumber(number));
    }

    public static boolean isPerfectNumber(int number) {
        int divisorsSum = 0;
        for (int i = 1; i < number - 1; i++) {
            if (number % i == 0) {
                divisorsSum += i;
            }
        }
        return number == divisorsSum;
    }
}
