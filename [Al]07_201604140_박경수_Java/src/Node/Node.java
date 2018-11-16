package Node;

public class Node {
	private int number;
	private String ID;
	private Node parent;
	private Node Next;
    
    public Node(){
        this.number = 0;
        this.setID(null);
        parent = null;
        Next = null;
    }
    
    public Node(int data){
        this.number = data;
        this.setID(null);
        parent = null;
        Next = null;
    }
    
    // get, setÇÔ¼ö
    public int getnumber(){
        return number;
    }
    
	public void setnumber(int number) {
		this.number = number;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public Node getNext() {
		return Next;
	}

	public void setNext(Node Next) {
		this.Next = Next;
	}
}
