public class Fibonacci {
    public static int fibonacciRecursive(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fibonacciRecursive(n - 2) + fibonacciRecursive(n - 1);
    }

    public static int fibonacciLoop(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int a1 = 0, a2 = 1;
        int sum = 1;

        for (int i = 1; i < n; i++) {
            sum += a1 + a2;
            a1 = a2;
            a2 = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 13;
        System.out.println(fibonacciRecursive(n));
        System.out.println(fibonacciLoop(n));
    }
}
