package Algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Node.Node;

public class Binary_Search_Tree {
	Node node = new Node();
	Insert insert = new Insert();
	
	public Binary_Search_Tree() {
		node = null; // ��� �ʱ�ȭ
		Data1_read();
		Data1_save();
		node = null; // ��� �ʱ�ȭ
		Data2_read();
		Data2_save();
	}
	
	// Data1.txt ���� �б� �� ��� �߰� �Լ�
	public void Data1_read() {
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/src/Resource/Data1.txt");
			FileReader filereader = new FileReader(file);
			BufferedReader bufreader = new BufferedReader(filereader);
			String line = "";
			int index = 0;
			while ((line = bufreader.readLine()) != null) {
				Node new_node = new Node(Integer.parseInt(line));
				Node temp = insert.Insert(node, new_node);
				node = temp;
				index++;
			}
			bufreader.close();
			filereader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	// Data2.txt ���� �б� �� ��� �߰� �Լ�
	public void Data2_read() {
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/src/Resource/Data2.txt");
			FileReader filereader = new FileReader(file);
			BufferedReader bufreader = new BufferedReader(filereader);
			String line = "";
			int index = 0;
			while ((line = bufreader.readLine()) != null) {
				Node new_node = new Node(Integer.parseInt(line));
				Node temp = insert.Insert(node, new_node);
				node = temp;
				index++;
			}
			bufreader.close();
			filereader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	// ���� ��ȸ�ϸ� ���Ͽ� ����
	public void inorder(Node node, FileWriter writer) {
		
		if (node.getLeft() != null)
			inorder(node.getLeft(), writer);
		try {
			writer.write(node.getData() + "\r\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
        if (node.getRight() != null)
        	inorder(node.getRight(), writer);
	}
	
	// Data1.txt ���� ����
	public void Data1_save() {
		String path = System.getProperty("user.dir");
		File file = new File(path + "/src/Resource/BST1.txt");
		FileWriter writer = null;
		try {
			writer = new FileWriter(file, false);
				inorder(node, writer);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// Data2.txt ���� ����
	public void Data2_save() {
		String path = System.getProperty("user.dir");
		File file = new File(path + "/src/Resource/BST2.txt");
		FileWriter writer = null;
		try {
			writer = new FileWriter(file, false);
				inorder(node, writer);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
