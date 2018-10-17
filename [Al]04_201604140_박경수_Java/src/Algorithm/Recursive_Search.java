package Algorithm;

import Node.Node;

public class Recursive_Search {
	public static Node Recursive_Search(Node node, int key) {
		if(node == null || key == node.getData())
			return node;
		if(key < node.getData())
			return Recursive_Search(node.getLeft(), key);
		else
			return Recursive_Search(node.getRight(), key);
	}
}
