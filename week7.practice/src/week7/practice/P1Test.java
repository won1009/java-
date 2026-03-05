package week7.practice;

public class P1Test {
    public static void main(String[] args) {
    	P1LinkedList<Integer> list = new P1LinkedList<>();

   

	/*
    //add code 실행할 땐 P1LinkedList<String> list = new P1LinkedList<>(); 으로 바꾼 후 실행 
	list.add(0, "Kim");
	list.add(0, "Lee");
	list.add(0, "Park");
	list.add(3, "Choi");
	list.add(2, "Son");
	list.printList();
	list.clear();
*/
	
	// 한줄씩 주석 지우면서 결과 예측하기
	// P1LinkedList<Integer> list = new P1LinkedList<>();
	list.append(300);
	list.add(0,200);
	list.add(0,100);
	list.set(0, 10);
	list.remove(2);
	list.add(0, 1);
	list.append(500);
	list.removeItem(200);
	//list.removeItem(300);
	list.printList();
	list.printList2();
	
	
	// 노드 구현 일반 버전과 심플 버전
//		Node<Integer> a = new Node<Integer>(100);
//		a.item = 200; // set 호출 대신 바로 리터럴 지정
//		System.out.println(a.item); // get 호출 대신 바로 item에 접근
	//
//		NormalNode<Integer> b = new NormalNode<>(100);
//		b.setItem(200);
//		System.out.println(b.getItem());
    }
}
