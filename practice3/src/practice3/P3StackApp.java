package practice3;

import practice2.P2LinkedStack;

public class P3StackApp {

    protected String input; // 스택 응용 메소드에 입력하는 문자열

    public P3StackApp() { // 생성자
	this.input = null;
    }

    public String get() {
	return this.input;
    }

    public void set(String input) {
	this.input = input;
    }

    // 괄호 쌍 찾기
    public boolean bracketTest() {
	P2LinkedStack<Character> stack = new P2LinkedStack<>();
	if(input == null) {
	    System.out.println("null이 입력되었습니다.");
	    return false;
	}
	
	//stack.printStack();
	// 입력 받은 문자열(input)의 띄어쓰기 제거
	String compressedInput = input.replace(" ", "");
	// 문자열을 분해하여 한글자 씩 저장한 배열을 생성하여 한칸 씩 순회
	for (Character current : compressedInput.toCharArray()) {
	    if (current == '(' || current == '{' || current == '[') {
		stack.push(current);
		//stack.printStack();
	    } else if (current == ')' || current == '}' || current == ']') {
		if (!isPair(stack.pop(), current)) {
		    return false;
		}
		//stack.printStack();
	    }
	}
	boolean result = stack.isEmpty();
	stack.popAll();
	return result;
    }

    // 여는 괄호와 닫는 괄호의 타입이 맞는지 확인하는 보조 메소드
    protected boolean isPair(Character open, Character close) {
	if (open == null || close == null) {
	    return false;
	}
	return (open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']');
    }

    // 회문 검사
    public boolean palindromeCheck() {
	P2LinkedStack<Character> stack = new P2LinkedStack<>();
	if(input == null) {
	    System.out.println("null이 입력되었습니다.");
	    return false;
	}
	
	//stack.printStack();

	String compressedInput = input.replaceAll("[^a-zA-Z0-9]", "");
	int mid = compressedInput.length() / 2;
	for (int i = 0; i < mid; i++) {
	    char ch = compressedInput.charAt(i);
	    stack.push(Character.toUpperCase(ch));
	    //stack.printStack();
	}

	if (compressedInput.length() % 2 == 1) {
	    mid++;
	}

	for (int i = mid; i < compressedInput.length(); i++) {
	    char ch = compressedInput.charAt(i);
	    char upperCh = Character.toUpperCase(ch);
	    if (stack.pop().compareTo(upperCh) != 0) {
		return false;
	    }
	}

	boolean result = stack.isEmpty();
	stack.popAll();
	return result;
    }

    // 후위 표기식 계산
    public Integer postfixEval() {
	if(input == null) {
	    System.out.println("null이 입력되었습니다.");
	    return -12345;
	}
	
	P2LinkedStack<Integer> stack = new P2LinkedStack<Integer>();
	String tokenArray[] = input.split(" ");
	// token 배열의 원소를 ch로 지정하여 순회
	for (String ch : tokenArray) {
	    // ch가 연산자가 아닌경우
	    if (!(ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/"))) {
		Integer num = 0;
		try { // ch가 숫자가 아니면 종료
		    num = Integer.valueOf(ch);
		} catch (NumberFormatException e) {
		    System.out.println("올바르지 않은 후위 표기식입니다.");
		    return -12345; // 변환에 실패하면 정수가 아님
		}
		stack.push(num);
//		stack.printStack();
	    } else { // ch가 연산자인 경우
		int x = stack.pop();
		int y = stack.pop();
		switch (ch) {
		case "+":
		    stack.push(y + x);
		    break;
		case "-":
		    stack.push(y - x);
		    break;
		case "*":
		    stack.push(y * x);
		    break;
		case "/":
		    if (x == 0) {
			System.out.println("0으로 나눌 수 없습니다.");
			return -12345;
		    }
		    stack.push(y / x);
		    break;
		}
	    }
	}
	int result = stack.pop();
	if (!stack.isEmpty()) {
	    System.out.println("올바르지 않은 후위 표기식입니다.");
	    return -12345;
	}
	stack.popAll();
	return result;
    }
}
