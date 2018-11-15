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
	ArrayList<Node> node_set = new ArrayList<>();
	Node data_1 = null;
	Node data_2 = null;
	Node data_3 = null;
	Node data_4 = null;
	Node data_5 = null;

	public Union_Find() {
		System.out.println("Union_Find is starting..." + "\n");
		data_read();
		
		// Make Set
		for (int i = 0; i < node_set.size(); i++) {
			Make_Set(node_set.get(i));
		}

		
		// 각 번호별 Union
		for (int i = 0; i < node_set.size(); i++) {
			// data가 1일 경우
			if (node_set.get(i).getdata() == 1) {
				// data가 1인 트리가 null일 경우
				if (data_1 == null)
					data_1 = node_set.get(i);
				// null이 아닐 경우
				else
					Union(node_set.get(i), data_1);
			}
			// data가 2일 경우
			else if (node_set.get(i).getdata() == 2) {
				// data가 2인 트리가 null일 경우
				if (data_2 == null)
					data_2 = node_set.get(i);
				// null이 아닐 경우
				else
					Union(node_set.get(i), data_2);
			}
			// data가 3일 경우
			else if (node_set.get(i).getdata() == 3) {
				// data가 3인 트리가 null일 경우
				if (data_3 == null)
					data_3 = node_set.get(i);
				// null이 아닐 경우
				else
					Union(node_set.get(i), data_3);
			}
			// data가 4일 경우
			else if (node_set.get(i).getdata() == 4) {
				// data가 4인 트리가 null일 경우
				if (data_4 == null)
					data_4 = node_set.get(i);
				// null이 아닐 경우
				else
					Union(node_set.get(i), data_4);
			}
			// data가 5일 경우
			else if (node_set.get(i).getdata() == 5) {
				// data가 5인 트리가 null일 경우
				if (data_5 == null)
					data_5 = node_set.get(i);
				// null이 아닐 경우
				else
					Union(node_set.get(i), data_5);
			}
		}

		data_save();
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

	// 노드의 집합을 만드는 함수
	public void node_set(Node new_node) {
		node_set.add(new_node);
	}

	// 파일 읽어오기 함수
	public void data_read() {
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/src/Resource/Data.txt");
			FileReader filereader = new FileReader(file);
			BufferedReader bufreader = new BufferedReader(filereader);
			String line = "";
			while ((line = bufreader.readLine()) != null) {
				Node new_node = new Node();
				new_node.setID(line.charAt(0));
				// 아스키 코드값이 나오므로 - '0'
				new_node.setdata(line.charAt(2) - '0');
				new_node.setParent(null);
				node_set(new_node);
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
	public void data_save() {
		Node node = null;
		for (int i = 0; i < 5; i++) {
			if(i == 0) node = data_1;
			else if(i == 1) node = data_2;
			else if(i == 2) node = data_3;
			else if(i == 3) node = data_4;
			else if(i == 4) node = data_5;
			
			String path = System.getProperty("user.dir");
			File file = new File(path + "/src/Resource/Find_Result-" + (i+1) + ".txt");
			FileWriter writer = null;
			try {
				writer = new FileWriter(file, false);
				writer.write(i+1 + ": ");
				while(true){
					writer.write(node.getID());
					if(node.getParent() == node) break;
					node = node.getParent();
					writer.write(", ");
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
}
