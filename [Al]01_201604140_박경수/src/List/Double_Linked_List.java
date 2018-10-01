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
	 
	    // ����� ���� Ȯ��
	    public String toString() {
	        return String.valueOf(this.data);
	    }
	}
	
	// �տ� add�ϴ� �Լ�
	public void addFirst(String input) {
	    Node newNode = new Node(input);
	    // ���ο� ����� ���� ���� head����
	    newNode.next = head;
	    // ������ ��尡 �ִٸ� head�� �������� ���ο� ���
	    if (head != null)
	        head.prev = newNode;
	    // head�� ���ο� ��带 ����
	    head = newNode;
	    size++;
	    // head�� ���� ��尡 ���ٸ� head�� �� tail
	    if (head.next == null) {
	        tail = head;
	    }
	}
	
	// �ڿ� add�ϴ� �Լ�
	public void addLast(String input) {
	    Node newNode = new Node(input);
	    // ����Ʈ�� ��尡 ���ٸ� ù��° ��带 �߰�
	    if (size == 0) {
	        addFirst(input);
	    } else {
	        // tail�� ���� ���� ������ ��带 �����մϴ�.
	        tail.next = newNode;
	        // ���ο� ����� ���� ���� tail�� �����մϴ�.
	        newNode.prev = tail;
	        // ������ ��带 �����մϴ�.
	        tail = newNode;
	        // ������Ʈ�� ������ 1 ���� ��ŵ�ϴ�.
	        size++;
	    }
	}
	
	// k ��ġ�� add�ϴ� �Լ�
	public void add(int k, String input) {
	    if (k == 0) {
	        addFirst(input);
	    } else {
	    	// k ��ġ�� add�ؾ��ϹǷ� k-1��° ��带 ã�´�.
	        Node temp1 = node(k - 1);
	        Node temp2 = temp1.next;
	        Node newNode = new Node(input);
	        temp1.next = newNode;
	        newNode.next = temp2;
	        // temp2�� null�� �ƴҰ��
	        if (temp2 != null)
	            temp2.prev = newNode;
	        newNode.prev = temp1;
	        size++;
	        // temp2�� null�� ���
	        if (newNode.next == null) {
	            tail = newNode;
	        }
	    }
	}
	
	// ��带 ã�� �Լ�
	Node node(int index) {
	    if (index < size / 2) {
	        // head���� next�� �̿��ؼ� �ε����� �ش��ϴ� ��带 ã���ϴ�.
	        Node x = head;
	        for (int i = 0; i < index; i++)
	            x = x.next;
	        return x;
	    } else {
	        // tail���� prev�� �̿��ؼ� �ε����� �ش��ϴ� ��带 ã���ϴ�.
	        Node x = tail;
	        for (int i = size - 1; i > index; i--)
	            x = x.prev;
	        return x;
	    }
	}
	
	// ù ��� ���� �Լ�
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
	
	// k ��ġ ��� ���� �Լ�
	public String remove(int k) {
	    if (k == 0)
	        return removeFirst();
	    Node temp = node(k - 1);
	    // temp.next���� �� ������ ����
	    Node removeNode = temp.next;
	    temp.next = temp.next.next;
	    // ������ ����� ������尡 ���� ��� ��� ����
	    if (temp.next != null) {
	        temp.next.prev = temp;
	    }
	    String removeData = removeNode.data;
	    // ������ ����� ������尡 ���� ��� temp�� tail
	    if (removeNode == tail) {
	        tail = temp;
	    }
	    removeNode = null;
	    size--;
	    return removeData;
	}
	
	// ������ ��� ���� �Լ�
	public String removeLast() {
	    return remove(size - 1);
	}
	
	// k��° data �������� �Լ�
	public String get(int k) {
	    Node temp = node(k);
	    return temp.data;
	}
	
	// Ư�� data ã�� �Լ�
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
	
	// ��ũ�帮��Ʈ ���̸� �����ϴ� �Լ�
	public int length() {
		Node temp = head;
		int index = 0;
		while (temp != null) {
			temp = temp.next;
			index++;
		}
		return index;
	}
	
	// ��ü �����͸� ����ϴ� �Լ�
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

