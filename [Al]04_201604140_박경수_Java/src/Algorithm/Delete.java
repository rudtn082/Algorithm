package Algorithm;

import Node.Node;

public class Delete {
	public static void Delete(Node node, Node delete_node) {
		if(delete_node.getLeft() == null)
			Transplant(node, delete_node, delete_node.getRight());
		else if(delete_node.getRight() == null)
			Transplant(node, delete_node, delete_node.getLeft());
		else {
			Node temp_node = Minimum.Minimum(delete_node.getRight());
			if(temp_node.getParent() != delete_node) {
				temp_node.setRight(delete_node.getRight());
				temp_node.getRight().setParent(temp_node);
			}
			Transplant(node, delete_node, temp_node);
			temp_node.setLeft(delete_node.getLeft());
			temp_node.getLeft().setParent(temp_node);
		}
			
	}
	
	public static void Transplant(Node node1, Node node2, Node node3) {
		if(node2.getParent() == null)
			node1 = node3;
		else if(node2 == node2.getParent().getLeft())
			node2.getParent().setLeft(node3);
		else
			node2.getParent().setRight(node3);
		
		if(node3 != null)
			node3.setParent(node2.getParent());
	}
}
