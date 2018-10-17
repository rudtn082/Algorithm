package Node;

public class Node {
	int data;
	private Node left;
	private Node right;
	private Node parent;
    
    public Node(){
        this.data = 0;
        this.setLeft(null);
        this.setRight(null);
    }
    
    public Node(int data){
        this.data = data;
        this.setLeft(null);
        this.setRight(null);
    }
    
    // 중위순회
    public void inorder(Node node) {
    	if (node.left != null)
    		inorder(node.left);
        System.out.println(node.data);
        if (node.right != null)
    		inorder(node.right);
    }
    
    // get, set함수
    public int getData(){
        return data;
    }

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}
}
