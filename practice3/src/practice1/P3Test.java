package practice1;

public class P3Test {

    public static void main(String[] args) {
//	P3CBLinkedList<Integer> list = new P3CBLinkedList<>();
	E3ECBLinkedList<Integer> list = new E3ECBLinkedList<Integer>();
	
	list.append(200);
	list.append(20);
	list.append(2); 
	list.add(0, 0); 
	list.set(0, 1);
	list.removeItem(20);
	list.append(10);
	list.printList();
	
	int j = 6;
	for(int i = 1; i <= j; i++) {
	    list.rotateList(1);
	    System.out.print(i + "번 회전 결과:");
	    list.printList();
	}
    }
}
