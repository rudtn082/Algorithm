package Algorithm;

import Node.Node;

public class Insert {
	private static int repeat = 0;
	public Node Insert(Node node, Node insert_node) {
		Node temp_node = null;
		Node x = node;
		while(x != null) {
			temp_node = x;
			if(insert_node.getData() < x.getData())
				x = x.getLeft();
			else x = x.getRight();
			repeat++;
		}
		insert_node.setParent(temp_node);
		if(temp_node == null)
			node = insert_node;
		else if(insert_node.getData() < temp_node.getData())
			temp_node.setLeft(insert_node);
		else
			temp_node.setRight(insert_node);
		return node;
	}
	
	public static int get_repeat() {
		return repeat;
	}
	
	public static void init_repeat() {
		repeat = 0;
	}
	
}
