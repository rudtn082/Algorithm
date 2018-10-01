package List;
public class Double_Linked_List {
	private Node head;
	private Node tail;
	private int size = 0;
	
	private class Node {
	    private String data;
	    private Node next;
	    private Node prev;
	 
	    public Node(String input) {
	        this.data = input;
	        this.next = null;
	        this.prev = null;
	    }
	 
	    // 노드의 내용 확인
	    public String toString() {
	        return String.valueOf(this.data);
	    }
	}
	
	// 앞에 add하는 함수
	public void addFirst(String input) {
	    Node newNode = new Node(input);
	    // 새로운 노드의 다음 노드로 head지정
	    newNode.next = head;
	    // 기존에 노드가 있다면 head의 이전노드는 새로운 노드
	    if (head != null)
	        head.prev = newNode;
	    // head로 새로운 노드를 지정
	    head = newNode;
	    size++;
	    // head의 다음 노드가 없다면 head가 곧 tail
	    if (head.next == null) {
	        tail = head;
	    }
	}
	
	// 뒤에 add하는 함수
	public void addLast(String input) {
	    Node newNode = new Node(input);
	    // 리스트의 노드가 없다면 첫번째 노드를 추가
	    if (size == 0) {
	        addFirst(input);
	    } else {
	        // tail의 다음 노드로 생성한 노드를 지정합니다.
	        tail.next = newNode;
	        // 새로운 노드의 이전 노드로 tail을 지정합니다.
	        newNode.prev = tail;
	        // 마지막 노드를 갱신합니다.
	        tail = newNode;
	        // 엘리먼트의 개수를 1 증가 시킵니다.
	        size++;
	    }
	}
	
	// k 위치에 add하는 함수
	public void add(int k, String input) {
	    if (k == 0) {
	        addFirst(input);
	    } else {
	    	// k 위치에 add해야하므로 k-1번째 노드를 찾는다.
	        Node temp1 = node(k - 1);
	        Node temp2 = temp1.next;
	        Node newNode = new Node(input);
	        temp1.next = newNode;
	        newNode.next = temp2;
	        // temp2가 null이 아닐경우
	        if (temp2 != null)
	            temp2.prev = newNode;
	        newNode.prev = temp1;
	        size++;
	        // temp2가 null일 경우
	        if (newNode.next == null) {
	            tail = newNode;
	        }
	    }
	}
	
	// 노드를 찾는 함수
	Node node(int index) {
	    if (index < size / 2) {
	        // head부터 next를 이용해서 인덱스에 해당하는 노드를 찾습니다.
	        Node x = head;
	        for (int i = 0; i < index; i++)
	            x = x.next;
	        return x;
	    } else {
	        // tail부터 prev를 이용해서 인덱스에 해당하는 노드를 찾습니다.
	        Node x = tail;
	        for (int i = size - 1; i > index; i--)
	            x = x.prev;
	        return x;
	    }
	}
	
	// 첫 노드 삭제 함수
	public String removeFirst() {
	    Node temp = head;
	    head = temp.next;
	    String removeData = temp.data;
	    temp = null;
	    if (head != null)
	        head.prev = null;
	    size--;
	    return removeData;
	}
	
	// k 위치 노드 삭제 함수
	public String remove(int k) {
	    if (k == 0)
	        return removeFirst();
	    Node temp = node(k - 1);
	    // temp.next삭제 전 변수에 보관
	    Node removeNode = temp.next;
	    temp.next = temp.next.next;
	    // 삭제할 노드의 다음노드가 있을 경우 노드 연결
	    if (temp.next != null) {
	        temp.next.prev = temp;
	    }
	    String removeData = removeNode.data;
	    // 삭제할 노드의 다음노드가 없을 경우 temp가 tail
	    if (removeNode == tail) {
	        tail = temp;
	    }
	    removeNode = null;
	    size--;
	    return removeData;
	}
	
	// 마지막 노드 삭제 함수
	public String removeLast() {
	    return remove(size - 1);
	}
	
	// k번째 data 가져오기 함수
	public String get(int k) {
	    Node temp = node(k);
	    return temp.data;
	}
	
	// 특정 data 찾기 함수
	public int indexOf(String data) {
	    Node temp = head;
	    int index = 0;
	    while (temp.data != data) {
	        temp = temp.next;
	        index++;
	        if (temp == null)
	            return -1;
	    }
	    return index;
	}
	
	// 링크드리스트 길이를 리턴하는 함수
	public int length() {
		Node temp = head;
		int index = 0;
		while (temp != null) {
			temp = temp.next;
			index++;
		}
		return index;
	}
	
	// 전체 데이터를 출력하는 함수
	public void print_data() {
		Node temp = head;
		int index = 0;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
			index++;
		}
	}
	
}

