package practice1;

public interface IntegerListInterface {
    public Integer get(int i); // 리스트의 i 번째 원소 알려주기

    public void set(int i, Integer x); // 리스트의 i 번째 원소를 x로 설정하기

    public boolean add(int i, Integer x); // 원소 삽입 : 리스트의 i 번째 자리에 원소 x 삽입

    public void append(Integer x); // 원소 삽입 : 리스트의 맨 뒤에 원소 x 추가

    public int indexOf(Integer x); // 원소 x가 리스트의 몇 번째 원소인지 알려주기

    public boolean isEmpty(); // 리스트가 비었는지 알려주기

    public boolean remove(int i); // 원소 삭제 : 리스트의 i 번째 원소 삭제

    public boolean removeItem(Integer x); // 원소 삭제 : 리스트에서 원소 x를 찾아 삭제

    public int len(); // 리스트의 원소 개수 알려주기

    public void clear(); // 리스트 청소
}
