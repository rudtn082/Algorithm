package Algorithm;

import Node.Node;

public class Recursive_Search {
	static int repeat = 0;
	public static Node Recursive_Search(Node node, int key) {
		if(node == null || key == node.getData()) {
			System.out.println(repeat + "�� �ݺ��Ͽ� " + key + "���� ������ϴ�.");
			return node;
		}
		if(key < node.getData()) {
			repeat++;
			return Recursive_Search(node.getLeft(), key);
		}	
		else {
			repeat++;
			return Recursive_Search(node.getRight(), key);
		}	
	}
}

