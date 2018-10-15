package Node;

public class Node {
	String data;
	Node left;
	Node right;
	Node root;
    
    public Node(){
        this.left = null;
        this.right = null;
        this.root = null;
    }
    
    public Node(String data){
        this.data = data;
        this.left = null;
        this.right = null;
        this.root = null;
    }
    
    public Object getData(){
        return data;
    }
}
