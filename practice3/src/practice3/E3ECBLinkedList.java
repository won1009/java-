package practice3;

public class E3ECBLinkedList<E> extends P3CBLinkedList<E> {

    // 생성자
    public E3ECBLinkedList() {
        super();
    }

    /**
     * 리스트의 원소들을 k 위치만큼 오른쪽으로 회전
     * k가 리스트의 크기보다 큰 경우도 처리
     *
     * @param k 회전할 위치의 수
     */
    public void rotateList(int k) {
        // 리스트가 비어있거나 k가 0인 경우 회전 필요 없음
        if (isEmpty() || k == 0) {
            return; // 회전 필요 없음
        }

        // 실제 회전량 계산 (k가 리스트 크기보다 클 경우 리스트 크기로 나눈 나머지 사용)
        k = k % size();

        // k가 음수일 경우 양수 회전으로 변환
        if (k < 0) {
            k = size() + k; // 음수 회전은 반대 방향 회전과 동일
        }

        // 나머지 연산 후 k가 0이면 회전 불필요
        if (k == 0) {
            return;
        }

     // 회전 후 새로운 tail과 head 노드 찾기
        Node<E> current = head;
        for (int i = 0; i < size() - k; i++) {
            current = current.next;
        }


        // 포인터 조정하여 회전 수행
        tail.next = head; // 기존 tail을 기존 head로 연결
        head = current.next; // 새로운 head는 뒤에서 k번째 노드
        current.next = null; // 뒤에서 k번째 노드를 새로운 tail로 설정
        tail = current; // tail 포인터 업데이트
    }
}