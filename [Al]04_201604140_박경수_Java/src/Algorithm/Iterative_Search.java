package Algorithm;

import Node.Node;

public class Iterative_Search {
	public static Node Iterative_Search(Node node, int key) {
		while(node != null && key != node.getData()) {
			if(key < node.getData())
				node = node.getLeft();
			else
				node = node.getRight();
		}
		return node;
	}
}
