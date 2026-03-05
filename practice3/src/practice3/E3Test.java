package practice3;

public class E3Test {
    public static void main(String[] args) {
	E3InfixToPostfix test = new E3InfixToPostfix();
//	String infixStr = "((47 +3) * 6 - 700)/ 4";
	String infixStr = "(3 + 4) * (5 - 2)";
	//String infixStr = "2 * (3 + 4) / (1 - 5)";

			
			
	test.set(infixStr);
	System.out.println("입력한 중위 표기식: " + test.get());
	
	String postfixStr = test.infixToPostfix();
	test.set(postfixStr);
	System.out.println("변환된 후위 표기식: " + test.get());
	System.out.println("계산 결과: " + test.postfixEval());
    }
}
