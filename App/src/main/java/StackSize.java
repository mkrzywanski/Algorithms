// stack implementation with size variable
public class StackSize<T> {
    Node<T> top;
    private int size;

    private static class Node<T> {
        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node() {
            this.data = null;
            this.next = null;
        }

        Node<T> next;
        T data;
    }

    public void push(T value) {
        Node<T> node = new Node<>(value);
        if (size == 0) {
            top = node;
        } else {
            node.next = top;
            top = node;
        }
        size++;
    }

    public T pop() {
        if (size != 0) {
            T value = top.data;
            top = top.next;
            size--;
            return value;
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        StackSize<Integer> stack = new StackSize<>();
        stack.push(1);
        stack.push(2);
        stack.push(2);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println("END");
    }
}
