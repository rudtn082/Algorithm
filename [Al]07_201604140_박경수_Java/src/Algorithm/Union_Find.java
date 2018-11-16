package Algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Node.Node;

public class Union_Find {
	Node root = null;
	Node temp = null;
	Node data_1 = null;
	Node data_2 = null;
	Node data_3 = null;
	Node data_4 = null;
	Node data_5 = null;
	Node data_all = null;

	public Union_Find() {
		System.out.println("Union_Find is starting..." + "\n");
		data_read();
		
		Node temp_root = root;
		
		// Make Set
		while(temp_root != null) {
			Make_Set(temp_root);
			temp_root = temp_root.getNext();
		}

		temp_root = root;
		// 각 숫자별 Union
		while(temp_root != null) {
			if(temp_root.getnumber() == 1) {
				if(data_1 == null) data_1 = temp_root;
				else Union(temp_root, data_1);
			} else if(temp_root.getnumber() == 2) {
				if(data_2 == null) data_2 = temp_root;
				else Union(temp_root, data_2);
			} else if(temp_root.getnumber() == 3) {
				if(data_3 == null) data_3 = temp_root;
				else Union(temp_root, data_3);
			} else if(temp_root.getnumber() == 4) {
				if(data_4 == null) data_4 = temp_root;
				else Union(temp_root, data_4);
			} else if(temp_root.getnumber() == 5) {
				if(data_5 == null) data_5 = temp_root;
				else Union(temp_root, data_5);
			}
			temp_root = temp_root.getNext();
		}

		// Output1 저장
		data_save_1();
		
		// 모든 트리를 유니온
		data_all = data_1;
		Union(data_2, data_all);
		Union(data_3, data_all);
		Union(data_4, data_all);
		Union(data_5, data_all);
		
		// Output2 저장
		data_save_2();
		System.out.println("Union_Find save successful");
		System.out.println("------------------------------------------------");
	}

	public void Make_Set(Node node) {
		node.setParent(node);
	}

	public Node Find_Set(Node node) {
		if (node.getParent() == node)
			return node;
		else
			return Find_Set(node.getParent());
	}

	public void Union(Node node1, Node node2) {
		Find_Set(node2).setParent(Find_Set(node1));
	}

	// 파일 읽어오기 함수
	public void data_read() {
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/src/Resource/Data_updated.txt");
			FileReader filereader = new FileReader(file);
			BufferedReader bufreader = new BufferedReader(filereader);
			String line = "";
			while ((line = bufreader.readLine()) != null) {
				Node new_node = new Node();
				char[] str = new char[6];
				line.getChars(0, 5, str, 0);
				new_node.setID(String.valueOf(str));
				// 아스키 코드값이 나오므로 - '0'
				new_node.setnumber(line.charAt(6) - '0');
				new_node.setParent(null);
				if(temp == null) {
					root = new_node;
					temp = new_node;
				}
				else {
					temp.setNext(new_node);
					temp = new_node;
				}
			}
			bufreader.close();
			filereader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	// 파일 저장 함수
	public void data_save_1() {
		Node node = root;
		String path = System.getProperty("user.dir");
		File file = new File(path + "/src/Resource/Output1.txt");
		FileWriter writer = null;
		try {
			writer = new FileWriter(file, false);
			while(node != null){
				System.out.println("1");
				writer.write(node.getID().toString() + "   " + node.getParent().getID() + "\r\n");
				node = node.getNext();
			}
			
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
	
	// 파일 저장 함수
	public void data_save_2() {
		Node node = root;
		String path = System.getProperty("user.dir");
		File file = new File(path + "/src/Resource/Output2.txt");
		FileWriter writer = null;
		try {
			writer = new FileWriter(file, false);
			while(node != null){
				writer.write(node.getID().toString() + "   " + node.getParent().getID() + "\r\n");
				node = node.getNext();
			}
			
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