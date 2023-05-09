package skewedtree;
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Main {
    Node node;

    public Main() {
        this.node = null;
    }

    private Node rightRotate(Node node) {
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;
        return temp;
    }

    private Node convertToSkewedTree(Node node) {
        if (node == null) {
            return null;
        }
        node.right = convertToSkewedTree(node.right);
        node = rightRotate(node);
        node.right = convertToSkewedTree(node.right);
        return node;
    }

    private void printAscendingOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        printAscendingOrder(node.right);
    }

    public static void main(String[] args) {
        Main tree = new Main();
        tree.node = new Node(50);
        tree.node.left = new Node(30);
        tree.node.right = new Node(60);
        tree.node.left.left = new Node(10);
        tree.node.right.left = new Node(55);

        tree.node = tree.convertToSkewedTree(tree.node);
        tree.printAscendingOrder(tree.node);
    }
}
