package practice2;

import java.util.EmptyStackException;

public class P2LinkedStack<T> {
    private Node<T> topNode;

    public P2LinkedStack() {
        topNode = null;
    }

    public void push(T item) {
        topNode = new Node<>(item, topNode);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T item = topNode.data;
        topNode = topNode.next;
        return item;
    }

    public T top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return topNode.data;
    }

    public void popAll() {
        topNode = null;
    }

    public void printStack() {
        Node<T> currentNode = topNode;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return topNode == null;
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;

        private Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }
}