package Algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Node.Node;

public class Binary_Search_Tree {
	Node node = new Node();
	Insert insert = new Insert();

	public Binary_Search_Tree() {
		//Data1
		node = null; // 노드 초기화
		Data1_read_insert();
		System.out.println("Data1, Root node의 Successor값 : " + Successor.Successor(node).getData());
		System.out.println("Data1, Root node의 Predecessor값 : " + Predecessor.Predecessor(node).getData()+"\n");
		
		//Delete.Delete(node, node.getRight().getLeft().getRight());
		//node.inorder(node);
		Recursive_Search Rs = new Recursive_Search();
		Rs.Recursive_Search(node, 1);
		
		Data1_save();
		
		
		//Data1
		node = null; // 노드 초기화
		Data2_read_insert();
		int repeat = Insert.get_repeat();
		System.out.println("Data2, insert 방법 : " + repeat + "번 반복 하였습니다.");
		node = null; // 노드 초기화
		Insert.init_repeat(); // 반복 횟수 초기화
		Data2_read_median_insert();
		repeat = Insert.get_repeat();
		System.out.println("Data2, Median_insert 방법 : " + repeat + "번 반복 하였습니다.");
		Data2_save();
		System.out.println("\n" + "Binary_Search_Tree save successful");
		System.out.println("------------------------------------------------");
	}

	// Data1.txt 파일 읽기 및 노드 추가 함수(insert)
	public void Data1_read_insert() {
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

	// Data1.txt 파일 읽기 및 노드 추가 함수(Median_insert)
	public void Data1_read_median_insert() {
		ArrayList<Integer> array = new ArrayList<>();
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/src/Resource/Data1.txt");
			FileReader filereader = new FileReader(file);
			BufferedReader bufreader = new BufferedReader(filereader);
			String line = "";
			int index = 0;
			// 먼저 array에 저장
			while ((line = bufreader.readLine()) != null) {
				array.add(Integer.parseInt(line));
				index++;
			}
			// 이후 삽입정렬을 통해 정렬
			for (int i = 1; i < array.size(); i++) {
				int temp_int = array.get(i);
				int j = i;
				for (; j > 0 && temp_int < array.get(j - 1); j--) {
					array.remove(j);
					array.add(j, array.get(j - 1));
				}
				array.remove(j);
				array.add(j, temp_int);
			}
			// 중간값 부터 끝까지 트리에 insert
			for (int i = array.size() / 2; i < array.size(); i++) {
				Node new_node = new Node(array.get(i));
				Node temp = insert.Insert(node, new_node);
				node = temp;
			}
			// 0부터 중간값을 트리에 insert
			for (int i = 0; i < array.size() / 2; i++) {
				Node new_node = new Node(array.get(i));
				Node temp = insert.Insert(node, new_node);
				node = temp;
			}
			bufreader.close();
			filereader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	// Data2.txt 파일 읽기 및 노드 추가 함수(insert)
	public void Data2_read_insert() {
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

	// Data2.txt 파일 읽기 및 노드 추가 함수(Median_insert)
	public void Data2_read_median_insert() {
		ArrayList<Integer> array = new ArrayList<>();
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/src/Resource/Data2.txt");
			FileReader filereader = new FileReader(file);
			BufferedReader bufreader = new BufferedReader(filereader);
			String line = "";
			int index = 0;
			// 먼저 array에 저장
			while ((line = bufreader.readLine()) != null) {
				array.add(Integer.parseInt(line));
				index++;
			}
			// 이후 삽입정렬을 통해 정렬
			for (int i = 1; i < array.size(); i++) {
				int temp_int = array.get(i);
				int j = i;
				for (; j > 0 && temp_int < array.get(j - 1); j--) {
					array.remove(j);
					array.add(j, array.get(j - 1));
				}
				array.remove(j);
				array.add(j, temp_int);
			}
			// 중간값 부터 끝까지 트리에 insert
			for (int i = array.size() / 2; i < array.size(); i++) {
				Node new_node = new Node(array.get(i));
				Node temp = insert.Insert(node, new_node);
				node = temp;
			}
			// 0부터 중간값을 트리에 insert
			for (int i = 0; i < array.size() / 2; i++) {
				Node new_node = new Node(array.get(i));
				Node temp = insert.Insert(node, new_node);
				node = temp;
			}
			bufreader.close();
			filereader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	// 중위 순회하며 파일에 쓰기
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

	// Data1.txt 파일 저장
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

	// Data2.txt 파일 저장
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
