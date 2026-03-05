package practice3;

import practice2.P2LinkedStack;
import java.util.EmptyStackException;

// 후위 표현식 계산 메소드를 사용하기 위한 P3StackApp 클래스 상속 
public class E3InfixToPostfix extends P3StackApp {

    public E3InfixToPostfix() {
        super();
    }

    /**
     * 입력 받은 문자열이 연산자인지 확인
     * 
     * @param token 확인할 문자열
     * @return 주어진 문자열이 +, -, *, / 중 하나이면 true, 그렇지 않으면 false
     */
    private boolean isOperator(String token) {
        return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token);
    }

    /**
     * 중위 표기식을 공백을 기준으로 분리하여 배열에 저장
     * @param infix 중위 표기식 문자열
     * @return 분리된 토큰 배열
     */
    private String[] genTokenArray(String infix) {
        // 중위 표기식의 모든 공백 제거
        String transformedInfix = infix.replaceAll("\\s+", "");

        // 연산자와 괄호 앞뒤에 공백 추가
        transformedInfix = transformedInfix.replaceAll("([+\\-*/()])", " $1 ");

        // 공백을 기준으로 문자열을 분리하여 배열에 저장
        String[] tokens = transformedInfix.split("\\s+");

        return tokens;
    }

    /**
     * 연산자의 우선순위를 반환
     * @param operator 연산자
     * @return 연산자의 우선순위 (덧셈과 뺄셈은 1, 곱셈과 나눗셈은 2)
     */
    private int precedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0;
        }
    }

    /**
     * 두 연산자의 우선순위를 비교
     * 
     * @param token    현재 연산자
     * @param stackTop 스택의 상단에 있는 연산자
     * @return token이 스택 상단의 연산자보다 우선순위가 낮거나 같으면 true, 그렇지 않으면 false
     */
    private boolean isLowerOrEqual(String token, String stackTop) {
        // precedence 메소드를 이용
        return precedence(token) <= precedence(stackTop);
    }

    /**
     * 스택의 최상위 요소를 확인 (임시 팝 후 푸시)
     */
    private String stackPeek(P2LinkedStack<String> stack) {
        if (stack.isEmpty()) throw new EmptyStackException();
        String topElement = stack.pop();
        stack.push(topElement);
        return topElement;
    }

    /**
     * 중위 표기식을 후위 표기식으로 변환
     * 
     * @return 변환된 후위 표기식 문자열
     */
    public String infixToPostfix() {
        if (input == null) {
            return null;
        }

        P2LinkedStack<String> stack = new P2LinkedStack<String>(); // 변환 과정에 사용하는 스택
        StringBuilder result = new StringBuilder(); // 변환 결과를 기록할 문자열

        // 중위 표기식(input)을 분리하여 배열에 기록
        String[] tokenArray = genTokenArray(input);

        // 피연산자면 출력하고, 괄호 또는 연산자이면 스택에 기록
        for (String token : tokenArray) {
            if (isOperator(token)) { // 연산자일 때: 우선 순위 고려하여 작업
                while (!stack.isEmpty() && isOperator(stackPeek(stack)) && isLowerOrEqual(token, stackPeek(stack))) {
                    result.append(stack.pop()).append(' ');
                }
                stack.push(token);
            } else if (token.equals("(")) { // 여는 괄호일 때
                stack.push(token);
            } else if (token.equals(")")) { // 닫는 괄호일 때
                while (!stack.isEmpty() && !stackPeek(stack).equals("(")) {
                    result.append(stack.pop()).append(' ');
                }
                stack.pop(); // 여는 괄호 제거
            } else { // 피연산자일 때
                result.append(token).append(' ');
            }
        }

        // 스택에 남아있는 연산자를 모두 출력
        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(' ');
        }

        return result.toString().trim(); // 결과 문자열을 반환
    }
}
