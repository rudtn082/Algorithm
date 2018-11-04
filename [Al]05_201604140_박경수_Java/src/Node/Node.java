package Node;

public class Node {
	int data;
	int color; //0�� ����, 1�� ��
	private Node left;
	private Node right;
	private Node parent;
    
    public Node(){
    	this.color = 0;
        this.data = 0;
        this.setLeft(null);
        this.setRight(null);
    }
    
    public Node(int data){
    	this.color = 0;
        this.data = data;
        this.setLeft(null);
        this.setRight(null);
    }
    
    // ������ȸ
    public void inorder(Node node) {
    	if (node.left != null)
    		inorder(node.left);
        System.out.println(node.data);
        if (node.right != null)
    		inorder(node.right);
    }
    
    // get, set�Լ�
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
	
	public int getColor() {
		return this.color;
	}

	public void setColor(int Color) {
		this.color = Color;
	}
}
