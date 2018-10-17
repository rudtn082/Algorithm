package Algorithm;

import Node.Node;

public class Insert {
	public Insert() {
		
	}
	public Node Insert(Node node, Node insert_node) {
		Node temp_node = null;
		Node x = node;
		while(x != null) {
			temp_node = x;
			if(insert_node.getData() < x.getData())
				x = x.getLeft();
			else x = x.getRight();
		}
		if(temp_node == null)
			node = insert_node;
		else if(insert_node.getData() < temp_node.getData())
			temp_node.setLeft(insert_node);
		else
			temp_node.setRight(insert_node);
		return node;
	}
}
