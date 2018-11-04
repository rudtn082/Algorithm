package Algorithm;

import Node.Node;

public class Insert {
	static final int RED = 0;
	static final int BLACK = 1;
	Node root = null;
	
	public Node Insert(Node node, Node insert_node) {
		Node temp_node = null;
		Node x = node;
		while(x != null) {
			temp_node = x;
			if(insert_node.getData() < x.getData())
				x = x.getLeft();
			else x = x.getRight();
		}
		insert_node.setParent(temp_node);
		insert_node.setColor(RED); // ���� ���� ����
		if(temp_node == null) {
			node = insert_node;
			root = node;
		}
		else if(insert_node.getData() < temp_node.getData()) {
			temp_node.setLeft(insert_node);
		}
		else {
			temp_node.setRight(insert_node);
		}
		insert_case1(insert_node);
		return node;
	}
	
	// root �� ��� ��
	public void insert_case1 (Node insert_node) {
		if(insert_node.getParent() == null)
			insert_node.setColor(BLACK);
		else
			insert_case2(insert_node);
	}
	
	// p�� ���� ���
	public void insert_case2 (Node insert_node) {
		// ���Գ���� �θ� ���� ��
		if(insert_node.getParent().getColor() == BLACK) {
			return;
		}
		else
			insert_case3(insert_node);			
	}
	
	// ���Գ���� �θ� ������ ��
	public void insert_case3 (Node insert_node) {
		Node p = insert_node.getParent(); // p
		Node pp = p.getParent(); // p^2
		Node s;
		// ���Գ�尡 �θ��� ������ �� s�� �θ��� ������
		if(p == pp.getLeft())
			s = pp.getRight(); // s
		else
			s = pp.getLeft();
		// s�� ���� ��
		if(s == null) {
			insert_case3_2(insert_node);
		}
		// s�� ������ ��
		else if(s.getColor() == RED) {
			p.setColor(BLACK);
			pp.setColor(RED);
			s.setColor(BLACK);
			// p^2�� ���ؼ� ���
			insert_case1(pp);
		}
		// s�� ���� ��
		else {
			insert_case4(insert_node);
		}
		
	}
	
	// ���Գ���� �θ� �����̰�, s��尡 ���� ��
	public void insert_case3_2 (Node insert_node) {
		Node p = insert_node.getParent(); // p
		Node pp = p.getParent(); // p^2
		
		p.setColor(BLACK);
		pp.setColor(RED);
	}
	
	// ���Գ���� �θ� �����̰�, s�� ���� ��
	public void insert_case4 (Node insert_node) {
		Node p = insert_node.getParent(); // p
		Node pp = p.getParent(); // p^2
		
		// x�� p�� ������ �ڽ��̸� p�� pp�� ���� �ڽ��� ��
		if(insert_node == p.getRight() && p == pp.getLeft()) {
			rotation_left(p);
			insert_node = insert_node.getLeft();
		}
		// x�� p�� ������ �ڽ��̸� p�� pp�� ������ �ڽ��� ��
		else if(insert_node == p.getLeft() && p == pp.getRight()) {
			rotation_right(p);
			insert_node = insert_node.getRight();
		}
		insert_case5(insert_node);
	}
	
	// ���Գ�� p, pp�� ���� ���� �� ��
	public void insert_case5 (Node insert_node) {
		Node p = insert_node.getParent(); // p
		Node pp = p.getParent(); // p^2
		
		p.setColor(BLACK);
		pp.setColor(RED);
		
		if(insert_node == p.getLeft() && p == pp.getLeft()) {
			rotation_right(pp);
		}
		else {
			rotation_left(pp);
		}
	}
	
	public void rotation_left(Node x) {
		Node y = x.getRight();
		x.setRight(y.getLeft());
		
		if(y.getLeft() != null)
			y.getLeft().setParent(x);
		
		y.setParent(x.getParent());
		
		if(x == x.getParent().getLeft()) {
			x.getParent().setLeft(y);
		}
		else {
			x.getParent().setRight(y);
		}
		
		y.setLeft(x);
		x.setParent(y);
	}
	
	public void rotation_right(Node x) {
		Node y = x.getLeft();
		x.setLeft(y.getRight());
		
		if(y.getRight() != null)
			y.getRight().setParent(x);
		
		y.setParent(x.getParent());
		
		if(x == x.getParent().getLeft()) {
			x.getParent().setLeft(y);
		}
		else {
			x.getParent().setRight(y);
		}
		
		y.setRight(x);
		x.setParent(y);
	}
}
