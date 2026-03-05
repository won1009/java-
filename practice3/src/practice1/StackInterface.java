package practice1;

public interface StackInterface<E> {
    public void push(E newItem); // 원소 newItem 삽입하기
    public E top(); // 스택 탑 원소 알려주기
    public E pop(); // 스택 탑 원소 삭제하면서 알려주기
    public boolean isEmpty(); // 스택이 비었는지 확인하기
    public void popAll(); // 스택 비우기
}
