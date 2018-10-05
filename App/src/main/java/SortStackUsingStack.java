import java.util.Stack;

public class SortStackUsingStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.add(5);
        stack.add(2);
        stack.add(5);
        stack.add(4);

        stack = sortStack(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static Stack<Integer> sortStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();

        tempStack.push(stack.pop());

        while (!stack.isEmpty()) {
            int value = stack.pop();

            if(value > tempStack.peek()) {
                tempStack.push(value);
            } else {
                while (!tempStack.isEmpty() && tempStack.peek() > value) {
                    stack.push(tempStack.pop());
                }
                tempStack.push(value);
            }
        }

        return tempStack;
    }
}
