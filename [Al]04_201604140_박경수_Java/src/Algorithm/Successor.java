package Algorithm;

import Node.Node;

//노드의 오른쪽 서브트리 가운데 최소값
public class Successor {
	public static Node Successor(Node node) {
		if(node.getRight() != null)
			return Minimum.Minimum(node.getRight());
		Node node_p = null;
		node_p.setRight(node);
		while(node_p != null && node == node_p.getRight()) {
			node = node_p;
			Node node_pp = null;
			node_pp.setRight(node_p); 
		}
		return node_p;
	}
}
