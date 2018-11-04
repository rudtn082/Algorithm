package Algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Node.Node;

public class Red_Black_Tree {
	Node node = new Node();
	Insert insert = new Insert();
	
	public Red_Black_Tree() {
		node = null; // 노드 초기화
		Data1_read_insert();

		Recursive_Search Rs = new Recursive_Search();
		Rs.Recursive_Search(node, 1);
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
}
