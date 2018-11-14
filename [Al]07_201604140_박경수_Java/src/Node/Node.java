package Node;

public class Node {
	private int data;
	private char ID;
	private Node parent;
    
    public Node(){
        this.data = 0;
        this.setID(' ');;
    }
    
    public Node(int data){
        this.data = data;
        this.setID(' ');
    }
    
    // get, setÇÔ¼ö
    public int getdata(){
        return data;
    }
    
	public void setdata(int data) {
		this.data = data;
	}

	public char getID() {
		return ID;
	}

	public void setID(char ID) {
		this.ID = ID;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}
}
