//generic stack implementation with end sentinel
public class Stack<T> {
    private Node<T> top = new Node<>();

    private static class Node<T> {
        public Node(T data) {
            this.data = data;
            this.previous = null;
        }

        public Node() {
            this.data = null;
            this.previous = null;
        }

        Node<T> previous;
        T data;

        boolean isEndNode() {
            return this.data == null && this.previous == null;
        }
    }

    public void push(T value) {
        Node<T> node = new Node<>(value);
        node.previous = top;
        top = node;
    }

    public T pop() {
        T value = top.data;
        if(!top.isEndNode()) {
            top = top.previous;
        }
        return value;
    }

    public boolean isEmpty() {
        return top.isEndNode();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println("END");
    }
}
