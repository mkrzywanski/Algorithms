public class SumOfFirst1000PrimeNumbers {
    public static void main(String[] args) {
        System.out.println(sumOf1000PrimeNumbers());
    }

    public static int sumOf1000PrimeNumbers() {
        int numbersCounter = 0;
        int currentNumber = 2;
        int primeSum = 0;
        while (numbersCounter < 1000) {
            if (isPrime(currentNumber)) {
                primeSum += currentNumber;
                numbersCounter++;
            }
            currentNumber++;
        }
        return primeSum;
    }

    public static boolean isPrime(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
