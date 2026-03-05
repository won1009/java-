package practice1;
public class P1IntegerList implements IntegerListInterface {
    protected Integer[] item; // 원소들이 저장되는 배열
    protected int numItems; // 원소의 갯수
    private static final int DEFAULT_CAPACITY = 64; // 기본 크기

    // 생성자 1
    public P1IntegerList() {
	this(DEFAULT_CAPACITY);
    }

    // 생성자 2
    public P1IntegerList(int n) {
	item = new Integer[n];
	numItems = 0;
    }

    @Override
    public boolean add(int i, Integer x) {
	if (i > numItems || i < 0) {
	    System.out.println("(add) 잘못된 입력입니다.");
	    return false;
	} else if(numItems == item.length ) {
	    System.out.println("(add) 오버플로우가 발생합니다.");
	    return false;
	}
	numItems++;

//	for (int j = numItems - 1; j > i; j--) {
//	    item[j] = item[j - 1];
//	}

	// item i번째부터 끝(numitems - 2)까지 원소를 item i + 1부터 numItems - 1까지로 복사
	System.arraycopy(item, i, item, i + 1, numItems - 1);

	item[i] = x;
	return true;
    }

    @Override
    public void append(Integer x) {
	if (numItems >= item.length) {
	    System.out.println("(append) 오버플로우가 발생합니다.");
	    return;
	}

	numItems++;
	item[numItems - 1] = x;
    }

    @Override
    public void clear() {
	item = new Integer[item.length];
	numItems = 0;
    }

    @Override
    public Integer get(int i) {
	if (i < 0 || i > numItems - 1) {
	    System.out.println("(get) 잘못된 입력입니다.");
	    return null;
	}
	return item[i];
    }

    @Override
    public boolean isEmpty() {
	return numItems == 0;
    }

    @Override
    public int indexOf(Integer x) {
	int k = -1;
	for (int i = 0; i <= numItems - 1; i++) {
	    if (item[i].compareTo(x) == 0) { // item[i] == x 는 작동 안함 Integer는 참조 타입
		return i;
	    }
	}
	return k;
    }

    @Override
    public int len() {
	return numItems;
    }

    @Override
    public boolean remove(int i) {
	if (isEmpty() || i < 0 || i > numItems - 1) {
	    System.out.println("(remove) 잘못된 입력입니다.");
	    return false;
	}

	numItems--;

//	for (int j = i; j <= numItems - 1; j++) {
//	    item[j] = item[j + 1];
//	}

	System.arraycopy(item, i + 1, item, i, numItems - i);

	item[numItems] = null;
	return true;
    }

    @Override
    public boolean removeItem(Integer x) {
	int k = indexOf(x);
	if (k == -1) {
	    return false;
	} else {
	    remove(k);
	    return true;
	}
    }

    @Override
    public void set(int i, Integer x) {
	if (i < 0 || i > numItems - 1) {
	    System.out.println("(set) 잘못된 입력입니다.");
	    return;
	}
	item[i] = x;
    }
}
