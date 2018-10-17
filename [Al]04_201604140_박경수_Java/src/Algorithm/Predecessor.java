package Algorithm;

import Node.Node;

//����� ���� ����Ʈ�� ��� �ִ밪
public class Predecessor {
	public static Node Predecessor(Node node) {
		if(node.getLeft() != null)
			return Maximum.Maximum(node.getLeft());
		Node node_p = null;
		node_p.setLeft(node);
		while(node_p != null && node == node_p.getLeft()) {
			node = node_p;
			Node node_pp = null;
			node_pp.setLeft(node_p); 
		}
		return node_p;
	}
}
