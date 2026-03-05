package week7.practice;

public interface LinkedListInterface<E> {
    public E get(int i); // 리스트의 i 번째 원소 알려주기

    public void set(int i, E x); // 리스트의 i 번째 원소를 x로 설정하기

    public boolean add(int i, E x); // 원소 삽입 : 리스트의 i 번째 자리에 원소 x 삽입

    public void append(E x); // 원소 삽입 : 리스트의 맨 뒤에 원소 x 추가

    public int indexOf(E x); // 원소 x가 리스트의 몇 번째 원소인지 알려주기

    public boolean isEmpty(); // 리스트가 비었는지 알려주기

    public boolean remove(int i); // 원소 삭제 : 리스트의 i 번째 원소 삭제

    public boolean removeItem(E x); // 원소 삭제 : 리스트에서 원소 x를 찾아 삭제

    public int len(); // 리스트의 원소 개수 알려주기

    public void clear(); // 리스트 청소
}
