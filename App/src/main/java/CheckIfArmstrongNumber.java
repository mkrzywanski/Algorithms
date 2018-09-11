import java.util.LinkedList;
import java.util.List;

public class CheckIfArmstrongNumber {
    public static void main(String[] args) {
        int number = 153;
        System.out.println(checkIfArmstrongNumber(number));
    }

    public static boolean checkIfArmstrongNumber(int number) {
        int sum = 0;
        List<Integer> list = new LinkedList<>();
        int temp = number;
        while (temp > 10) {
            int digit = temp % 10;
            list.add(digit);
            temp /= 10;
        }
        list.add(temp);

        for (Integer i : list) {
            sum += Math.pow(i, list.size());
        }
        return sum == number;
    }
}
