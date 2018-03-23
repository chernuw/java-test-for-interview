package net.itspartner.test.n1;

public class Node<T> {

    public final T value;
    private Node<T> nextNode;

    public Node(T value) {
        this.value = value;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public Node<T> setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
        return nextNode;
    }
}
