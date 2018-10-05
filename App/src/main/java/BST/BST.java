package BST;

public class BST {

    public static void main(String[] args) {
        int[] array = {10, 5, 1, 7, 40, 50};
        BST integerBST = new BST();
        integerBST.constructBST(array);
    }

    private static class Node {
        Integer value;
        Node left;
        Node right;
    }

    private Node root;

    public void constructBST(int[] array) {
        this.root = bstRecursive(array, 0, array.length - 1);
    }

    private Node bstRecursive(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex) {
            Node newNode = new Node();
            newNode.value = array[leftIndex];
            return newNode;
        } else if (leftIndex > rightIndex) {
            return null;
        }
        Node currentRoot = new Node();
        currentRoot.value = array[leftIndex];

        int biggerIndex = leftIndex + 1;
        while (array[biggerIndex] < currentRoot.value) {
            biggerIndex++;
        }

        Node left = bstRecursive(array, leftIndex + 1, biggerIndex - 1);
        Node right = bstRecursive(array, biggerIndex, rightIndex);

        currentRoot.left = left;
        currentRoot.right = right;

        return currentRoot;
    }
}
