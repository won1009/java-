package practice1;
//교수님 보강 영상 참고 
import java.util.EmptyStackException;

public class P1ArrayStack<E>  implements StackInterface<E>{
    private E[] stack;
    private int topIndex;
    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public P1ArrayStack() {
        stack = (E[]) new Object[DEFAULT_CAPACITY];
        topIndex = -1;	 //현재 스택의 맨 위 요소의 인덱스 
    }

    public void push(E item) { // 스택에 요소 추가, 배열이 꽉 차면 크기를 두배로 증가 
        if (topIndex == stack.length - 1) { //스택이 꽉 차있을 
           System.out.println("스택 오버플로우 발생");
           return;
           }
        stack[++topIndex] = item;
    }
    

    public E pop() { // 스택 맨 위요소를 제거하고 반환
        if (isEmpty()) {
            throw new EmptyStackException();
        }
 //       E item = stack[topIndex];
       topIndex--;
       return stack[topIndex +1];
    }

    public E top() {  // 스택 맨 위요소를 바환
        return stack[topIndex];
    }
    
    //스택을 비움
    public void popAll() {
       topIndex = -1;
       stack = (E[]) new Object[stack.length];
       
        }
    
//스택의 모든 요소 출력
    public void printStack() {
        for (int i = 0; i <= topIndex; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return topIndex == -1;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        E[] newStack = (E[]) new Object[stack.length * 2];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }
}
