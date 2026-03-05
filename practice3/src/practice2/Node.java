package practice2;

public class Node<E> {
    public E item;
    public Node<E> next;

    public Node(E newItem) {
	this(newItem, null);
    }

    public Node(E newItem, Node<E> nextNode) {
	item = newItem;
	next = nextNode;
    }
}