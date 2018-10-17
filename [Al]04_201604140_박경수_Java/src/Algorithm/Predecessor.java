package Algorithm;

import Node.Node;

//노드의 왼쪽 서브트리 가운데 최대값
public class Predecessor {
	public static Node Predecessor(Node node) {
		if(node.getLeft() != null)
			return Maximum.Maximum(node.getLeft());
		Node node_p = null;
		node.setParent(node_p);
		while(node_p != null && node == node_p.getLeft()) {
			node = node_p;
			Node node_pp = null;
			node_pp.setParent(node_p);
		}
		return node_p;
	}
}
