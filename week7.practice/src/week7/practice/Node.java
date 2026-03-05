package week7.practice;

// 간소화 버전: 외부에서 item과 next에 직접 접근 가능
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

// 일반 버전: 외부에서 item과 next의 접근을 막고 get, set 메소드를 구현
class NormalNode<E> {
    private E item;
    private NormalNode<E> next;

    public NormalNode(E newItem) { // 생성자1
	this(newItem, null);
    }

    public NormalNode(E newItem, NormalNode<E> nextNode) { // 생성자2 (오버로딩)
	item = newItem;
	next = nextNode;
    }

    public E getItem() { // 노드에 원소를 저장
	return item;
    }

    public NormalNode<E> getNext() { // 노드의 원소를 알려줌
	return next;
    }

    public void setItem(E newItem) { // 노드의 링크를 할당
	item = newItem;
    }

    public void setNext(NormalNode<E> newNext) { // 노드의 링크를 알려줌
	next = newNext;
    }
}