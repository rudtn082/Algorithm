package Algorithm;

import Node.Node;

//����� ������ ����Ʈ�� ��� �ּҰ�
public class Successor {
	public static Node Successor(Node node) {
		if(node.getRight() != null)
			return Minimum.Minimum(node.getRight());
		Node node_p = null;
		node.setParent(node_p);
		while(node_p != null && node == node_p.getRight()) {
			node = node_p;
			Node node_pp = null;
			node_pp.setParent(node_p);
		}
		return node_p;
	}
}
