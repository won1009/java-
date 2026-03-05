package week7.practice;

public class E1Test {
    public static void main(String[] args) {
        E1ExtendedLinkedList<String> list1 = new E1ExtendedLinkedList<>();
        E1ExtendedLinkedList<String> list2 = new E1ExtendedLinkedList<>();
        
        System.out.print("===== list1: ");
        list1.add(0, "300");
        list1.add(0, "200");
        list1.add(0, "100");
        list1.printList();
        
        System.out.print("===== Reversed list1: ");
        list1.reverseList();
        list1.printList();
        
        System.out.print("===== list2: ");
        list2.add(0, "2");
        list2.add(0, "1");
        list2.add(0, "0");
        list2.printList();
        
        System.out.print("===== list1 + list2: ");
        list1.mergeLists(list2);
        list1.printList();
    }
}
