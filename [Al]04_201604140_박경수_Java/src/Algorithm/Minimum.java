package Algorithm;

import Node.Node;

public class Minimum {
	public static Node Minimum(Node node) {
		while(node.getLeft() != null)
			node = node.getLeft();
		return node;
	}
}
