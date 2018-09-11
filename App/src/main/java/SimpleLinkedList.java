public class SimpleLinkedList<T> {
    private class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head;
    private Node<T> tail;


    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void print() {
        Node<T> pointer = head;
        while (pointer != null) {
            System.out.println(pointer.value);
            pointer = pointer.next;
        }
    }

    //Reversing linkedList using stack - my own implementation of stack
    public void reverseWithStack() {
        Stack<Node<T>> stack = new Stack<>();
        Node<T> pointer = head;
        while (pointer != null) {
            stack.push(pointer);
            pointer = pointer.next;
        }

        Node<T> newHead = stack.pop();
        pointer = newHead;
        while (!stack.isEmpty()) {
            Node<T> node = stack.pop();
            pointer.next = node;
            pointer = node;
            tail = node;
        }
        tail.next = null;
        head = newHead;
    }

    public void reverseRecursive() {
        reverseRecursion(this.head);
    }

    private Node<T> reverseRecursion(Node<T> currentHead) {
        if (currentHead.next == null) {
            head = currentHead;
            return currentHead;
        }
        Node<T> currentNode = currentHead;

        Node<T> newBeggining = currentHead.next;
        Node<T> recursiveNewBegining = reverseRecursion(newBeggining);
        Node<T> pointer = recursiveNewBegining;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        pointer.next = currentNode;
        currentNode.next = null;
        tail = currentNode;
        return recursiveNewBegining;

    }

    public void reverseLoop() {
        Node<T> previous = null;
        Node<T> current = head;
        Node<T> next;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;

        }

        head = previous;
    }

    public static void main(String[] args) {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.print();
        list.reverseWithStack();
        list.reverseRecursive();
        list.reverseLoop();
        list.print();
    }
}
