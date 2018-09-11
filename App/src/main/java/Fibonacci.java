import java.util.Stack;

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

        for (int i = 2; i < n + 1; i++) {
            sum = a1 + a2;
            a1 = a2;
            a2 = sum;
        }

        return sum;
    }

    public static int[] fibonacciTab(int n) {
        if (n == 0) {
            return new int[]{0};
        }

        if (n == 1) {
            return new int[]{1};
        }
        int[] tab = new int[n + 1];
        tab[0] = 0;
        tab[1] = 1;


        for (int i = 2; i < n + 1; i++) {
            tab[i] = tab[i - 1] + tab[i - 2];
        }

        return tab;
    }

    public static int fibonacciFormula(int n) {
        return (int) ((Math.pow(((1 + Math.sqrt(5)) / 2), n) - Math.pow(((1 - Math.sqrt(5)) / 2), n)) / Math.sqrt(5));
    }

    public static int fibonacciStack(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int sum = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(n);

        while (stack.size() > 0) {
            int currentValue = stack.pop();
            if (currentValue == 1) {
                sum += 1;
            } else if (currentValue != 0) {
                stack.push(currentValue - 1);
                stack.push(currentValue - 2);
            }
        }

        return sum;

    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(fibonacciRecursive(n));
        System.out.println(fibonacciLoop(n));
        System.out.println(fibonacciFormula(n));
        System.out.println(fibonacciStack(n));
    }
}
