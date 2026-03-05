package practice2;

public class P2Test {
    public static void main(String[] args) {
	P2LinkedStack<Integer> stack = new P2LinkedStack<>();
	stack.push(100);
	stack.push(200);
	stack.push(300);
	stack.push(400);
	stack.printStack();
	
	stack.pop();
	stack.printStack();
	
//	System.out.println(stack.pop());
//	System.out.println(stack.top());
//	
//	stack.popAll();
//	stack.printStack();
    }
}
