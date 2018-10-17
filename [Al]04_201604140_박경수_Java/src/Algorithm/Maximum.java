package Algorithm;

import Node.Node;

public class Maximum {
	public static Node Maximum(Node node) {
		while(node.getRight() != null)
			node = node.getRight();
		return node;
	}
}
