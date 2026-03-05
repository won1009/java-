package practice3;

import practice1.LinkedListInterface;

public class P3CBLinkedList<E> implements LinkedListInterface<E> {
    protected int numItems; // 리스트에 저장된 원소의 수
    protected BidirectionalNode<E> dummy; // 더미 노드, 리스트의 시작과 끝을 연결

    /**
     * 원형 이중 연결 리스트를 초기화하는 생성자
     */
    public P3CBLinkedList() {
        // TODO: 구현 필요
    }

    /**
     * 주어진 인덱스에 해당하는 노드를 반환하는 메소드
     * 인덱스가 중간 값보다 작으면 앞에서부터, 크면 뒤에서부터 탐색을 시작
     * @param index 노드의 인덱스
     * @return 해당 노드 또는 null (범위 외 경우)
     */
    protected BidirectionalNode<E> getNode(int index) {
        // TODO: 구현 필요
        return null; // 구현 후 제거
    }

    /**
     * 리스트의 모든 원소를 출력하는 메소드
     */
    public void printList() {
        // TODO: 구현 필요
    }

    /**
     * 더미 노드를 사용하여 리스트에 요소를 추가하는 메소드
     * @param i 삽입할 위치의 인덱스
     * @param x 삽입할 요소
     * @return 요소가 성공적으로 추가되면 true, 그렇지 않으면 false
     */
    @Override
    public boolean add(int i, E x) {
        // TODO: 구현 필요
        return false; // 구현 후 제거
    }

    /**
     * 리스트의 끝에 요소를 추가하는 메소드
     * @param x 추가할 요소
     */
    @Override
    public void append(E x) {
        // TODO: 구현 필요
    }

    /**
     * 리스트의 모든 요소를 제거하고 초기 상태로 리셋하는 메소드
     */
    @Override
    public void clear() {
        // TODO: 구현 필요
    }

    /**
     * 주어진 인덱스의 원소를 반환하는 메소드
     * @param i 원소의 인덱스
     * @return 해당 원소 또는 null (범위 외 경우)
     */
    @Override
    public E get(int i) {
        // TODO: 구현 필요
        return null; // 구현 후 제거
    }

    /**
     * 주어진 원소의 인덱스를 찾는 메소드
     * @param x 찾고자 하는 원소
     * @return 원소의 인덱스 또는 -12345 (찾지 못한 경우)
     */
    @Override
    public int indexOf(E x) {
        // TODO: 구현 필요
        return -12345; 
    }

    /**
     * 리스트가 비어 있는지 확인하는 메소드
     * @return 리스트가 비어있으면 true, 그렇지 않으면 false
     */
    @Override
    public boolean isEmpty() {
        // TODO: 구현 필요
        return true; // 구현 후 제거
    }

    /**
     * 리스트의 길이를 반환하는 메소드
     * @return 리스트의 길이
     */
    @Override
    public int len() {
        // TODO: 구현 필요
        return 0; // 구현 후 제거
    }

    /**
     * 지정된 인덱스의 원소를 제거하는 메소드
     * @param i 제거할 원소의 인덱스
     * @return 제거가 성공적으로 이루어지면 true, 그렇지 않으면 false
     */
    @Override
    public boolean remove(int i) {
        // TODO: 구현 필요
        return false; // 구현 후 제거
    }

    /**
     * 주어진 요소를 리스트에서 제거하는 메소드
     * @param x 제거할 요소
     * @return 제거가 성공적으로 이루어지면 true, 그렇지 않으면 false
     */
    @Override
    public boolean removeItem(E x) {
        // TODO: 구현 필요
        return false; // 구현 후 제거
    }

    /**
     * 지정된 인덱스의 원소를 새로운 값으로 설정하는 메소드
     * @param i 설정할 원소의 인덱스
     * @param x 새로 설정할 원소
     */
    @Override
    public void set(int i, E x) {
        // TODO: 구현 필요
    }
}

