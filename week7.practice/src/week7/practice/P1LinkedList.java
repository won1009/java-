package week7.practice;
//0415 실습용 과제 
public class P1LinkedList<E> implements LinkedListInterface<E> {
    
    // 더미 노드 버전을 기준으로 구현
    protected Node<E> dummy; // 더미 노드 (인덱스: -1)
    protected int numItems; // 리스트에 저장된 원소의 수
    
    public P1LinkedList() {
        numItems = 0;
        dummy = new Node<>(null, null); // 더미 노드 초기화
    }

    /**
     * getNode
     * k 번째 노드를 반환하는 보조 메소드
     * @param k 찾고자 하는 노드의 인덱스
     * @return 찾은 노드, 또는 null(범위 외)
     */
    private Node<E> getNode(int k) {
        if(k < -1 || k > numItems-1) {
        	return null; 
        }else if (k == -1){
        	return dummy;
        }
        Node<E> currentNode = dummy;
        
        for( int i =0 ; i <= k; i++) {
        	currentNode = currentNode.next;
        	}
        return currentNode;
        }

    
    
    /**
     * 더미 노드를 사용하여 리스트에 요소를 추가하는 메소드
     * @param i 삽입할 위치의 인덱스
     * @param x 삽입할 요소
     * @return 요소가 성공적으로 추가되면 true, 그렇지 않으면 false
     */
    @Override
    public boolean add(int i, E x) {
    	if(i < 0 || i >numItems) { //에러처리범위, 배열이numItem-까지 존재하는데 i는 보다 작을 때 널 값 반환하고 numitems가 될 때는 널값 반환 안 해도 됨 이유에 대해 생각 
    		System.out.println("(add) 잘못된 입력");
    		return false;
    	}
    	
    	Node<E> newNode = new Node<>(x);
    	Node<E> prevNode = getNode(i - 1);

    	newNode.next = prevNode.next;
    	prevNode.next = newNode;
    	
    	numItems++;
    	return true;
    }

    /**
     * 리스트의 끝에 요소를 추가하는 메소드
     * @param x 추가할 요소
     */
    @Override
    public void append(E x) {
	Node<E> previousNode = getNode(numItems - 1);
	Node<E> newNode = new Node<>(x);
	previousNode.next = newNode;
	numItems++;
    }

    /**
     * 지정된 인덱스의 요소를 반환하는 메소드
     * @param i 요소의 인덱스
     * @return 비어 있는 노드 또는 잘못된 인덱스 경우 null
     */
    @Override
    public E get(int i) {
	if (getNode(i) == null || i < 0 || i > numItems - 1) {
	    System.out.println("(get) 잘못된 입력입니다.");
	    return null;
	}
	return getNode(i).item;
    }

    /**
     * 지정된 인덱스의 요소를 새로운 요소로 설정하는 메소드
     * @param i 요소의 인덱스
     * @param x 새로 설정할 요소
     */
    @Override
    public void set(int i, E x) {
	if (i < 0 || i > numItems - 1) {
	    System.out.println("(set) 잘못된 입력입니다.");
	    return;
	}
	getNode(i).item = x;
    }

    /**
     * 리스트에서 주어진 요소의 인덱스를 반환하는 메소드
     * 요소가 리스트에 없으면 -12345을 반환
     * @param x 찾고자 하는 요소
     * @return 요소의 인덱스, 또는 -12345
     */
    @Override
    public int indexOf(E x) {
//        for (int i = 0; i < numItems -1; i++) {
//            if (((Comparable)getNode(i).item).compareTo(x) == 0) {
//            	return i; //값을 비교해서 겟노드가 아이템과 같으면 i를 리턴하겠다
//            }
//        }       
//   }
  
    Node<E> node = dummy;
    for (int i = 0; i <= numItems -1; i++) {
        node = node.next;
        if (((Comparable) node.item).compareTo(x) == 0) {
            return i; // 값과 같은 요소를 찾았을 때 인덱스를 반환
        }
    }
    return -12345; // 값을 찾지 못한 경우
}

    /**
     * 리스트가 비어 있는지 확인하는 메소드
     * @return 비어 있으면 true, 그렇지 않으면 false
     */
    @Override
    public boolean isEmpty() {
	return numItems == 0;
    }

    /**
     * 리스트의 길이를 반환하는 메소드
     * @return 리스트의 길이
     */
    @Override
    public int len() {
	return numItems;
    }

    /**
     * 리스트의 모든 요소를 제거하는 메소드
     */
    @Override
    public void clear() {
	dummy = new Node<>(null, null);
	numItems = 0;
    }

    
    /**
     * 지정된 인덱스의 요소를 리스트에서 제거하는 메소드
     * @param i 제거할 요소의 인덱스
     * @return 제거가 성공적으로 이루어지면 true, 그렇지 않으면 false
     */
    @Override
    public boolean remove(int i) {
        if (isEmpty() || i < 0 || i >= numItems) {
            System.out.println("(remove) 잘못된 입력입니다.");
            return false;
        }
        
        // 제거할 요소의 이전 노드를 찾습니다.
        Node<E> previousNode = getNode(i - 1);
        previousNode.next= previousNode.next.next;
      
        // 제거한 후 리스트의 크기를 감소시킵니다.
        numItems--;

        return true;
    }

    /**
     * 주어진 요소를 리스트에서 제거하는 메소드
     * @param x 제거할 요소
     * @return 제거가 성공적으로 이루어지면 true, 그렇지 않으면 false
     */
    @Override
    public boolean removeItem(E x) {
	if (indexOf(x) == -12345) {
	    System.out.println("x가 존재하지 않습니다.");
	    return false;
	}
	remove(indexOf(x));
	return false;
    }

    /**
     * 리스트의 요소들을 출력하는 메소드
     * 출력 예시: (100,200,300)
     */
    public void printList() {
	if (isEmpty()) {
	    System.out.println("공백 리스트입니다.");
	    return;
	}
	
	Node<E> node = dummy.next;
	System.out.print("(");
	for( int i = 0; i< numItems - 1; i++) {
		System.out.print(get(i)+ ",");
		node = node.next;
		}
	System.out.println(node.item + ")");
    }
    
    /**
     * 리스트의 요소들을 출력하는두번째 메소드
     * for 문에서 리스트를 순회
     * 출력 예시: ( 100 200 300 )
     */
    public void printList2() {
	if (isEmpty()) {
	    System.out.println("공백 리스트입니다.");
	    return;
	}
	// TODO: 구현 필요
    }
}

