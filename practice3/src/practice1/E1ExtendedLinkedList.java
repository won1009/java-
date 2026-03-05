package practice1;
public class E1ExtendedLinkedList<E> extends P1LinkedList<E> {
    /**
     * 생성자: E1ExtendedLinkedList 객체를 초기화
     */
    public E1ExtendedLinkedList() {
        super(); // 부모 클래스의 생성자 호출
    }

    /**
     * 두 개의 연결 리스트를 병합하는 메소드
     * 이 메소드는 otherList의 모든 요소를 현재 리스트의 끝에 추가
     * otherList는 병합 후 초기화
     *
     * @param otherList 이 리스트와 병합할 다른 리스트
     */
    public void mergeLists(E1ExtendedLinkedList<E> otherList) {
        if (otherList.isEmpty()) // 다른 리스트가 비어있으면 아무 작업도 수행하지 않음
            return;

        if (isEmpty()) { // 현재 리스트가 비어있는 경우
            dummy = otherList.dummy; // 현재 리스트의 dummy를 다른 리스트의 dummy로 설정
        } else {
            Node<E> current = dummy;
            while (current.next != null) { // 현재 리스트의 끝 노드까지 이동
                current = current.next;
            }
            current.next = otherList.dummy.next; // 현재 리스트의 끝에 다른 리스트를 연결
        }

        // 다른 리스트 초기화
        otherList.dummy.next = null;
        otherList.numItems = 0;
    }

    /**
     * 리스트의 요소 순서를 반전시키는 메소드
     * 이 메소드는 리스트 내의 노드들의 순서를 반대로 뒤집음
     */
    public void reverseList() {
        Node<E> previous = null; // 이전 노드를 기억하기 위한 변수
        Node<E> current = dummy.next; // 현재 노드를 가리키는 변수
        Node<E> next; // 다음 노드를 임시로 저장하기 위한 변수

        while (current != null) {
            next = current.next; // 현재 노드의 다음 노드를 임시로 저장
            current.next = previous; // 현재 노드의 다음 노드를 이전 노드로 설정하여 반전

            previous = current; // previous를 현재 노드로 이동
            current = next; // current를 다음 노드로 이동
        }

        dummy.next = previous; // 마지막 노드가 새로운 head가 됨
    }

}
