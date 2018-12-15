package Kruskal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

class Root {
	int number;
	Root Parent;
	
	public int getnumber() {
		return number;
	}
	public void setnumber(int number) {
		this.number = number;
	}

	public Root getParent() {
		return Parent;
	}
	public void setParent(Root Parent) {
		this.Parent = Parent;
	}
}

public class Kruskal {
	Root[] vertexList; // 정점 집합
	Edge[] vertexInfo; // vertex의 정보 리스트
	ArrayList<Edge> vertexSort = new ArrayList<>(); // 간선을 가중치를 기준으로 오름차순한 리스트
	ArrayList<Edge> A;

	public Kruskal() {
		graph_read();
		A = MST_Kruskal(vertexInfo, vertexInfo.length);
		file_save();
		System.out.println("Kruskal Algorithm완료!");
		System.out.println("================================");
	}

	public ArrayList<Edge> MST_Kruskal(Edge[] vertex, int w) {
		for (Root v : vertexList) {
			Make_Set(v);
		}

		for (int i = 0; i < vertex.length; i++) {
			vertexSort.add(vertex[i]);
		}

		for (int i = 0; i < vertexSort.size(); i++) {
			for (int j = i; j < vertexSort.size(); j++) {
				if (vertexSort.get(i).getWeight() > vertexSort.get(j).getWeight()) {
					Collections.swap(vertexSort, i, j);
				}
			}
		}

		A = new ArrayList<>(); // 새로운 집합 리스트

		while (!vertexSort.isEmpty()) {
			int start = vertexSort.get(0).getStart();
			int end = vertexSort.get(0).getEnd();
			Root root1 = Find_Set(vertexList[start]);
			Root root2 = Find_Set(vertexList[end]);

			if (root1 != root2) {
				A.add(vertexSort.get(0));
				Union(root1, root2);
			}
			vertexSort.remove(0);
		}
		return A;
	}

	public void Make_Set(Root root) {
		root.setParent(root);
	}

	public Root Find_Set(Root root) {
		if (root.getParent() == root)
			return root;
		else
			return Find_Set(root.getParent());
	}

	public void Union(Root root1, Root root2) {
		Find_Set(root1).setParent(Find_Set(root2));
	}

	// 파일 읽어오기 함수
	public void graph_read() {
		ArrayList<String> array = new ArrayList<>();
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/src/Resource/graph_sample_prim_kruskal.txt");
			FileReader filereader = new FileReader(file);
			BufferedReader bufreader = new BufferedReader(filereader);
			String line = "";
			boolean index = false;
			while ((line = bufreader.readLine()) != null) {
				if (!index) {
					vertexList = new Root[Integer.parseInt(line)];
					for (int i = 0; i < vertexList.length; i++) {
						vertexList[i] = new Root();
						vertexList[i].setnumber(i);
					}
					index = true;
					continue;
				} else {
					array.add(line);
				}
			}
			bufreader.close();
			filereader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			vertexInfo = new Edge[array.size()];
			for (int i = 0; i < vertexInfo.length; i++) {
				String[] splitStr = array.get(i).split(" ");

				vertexInfo[i] = new Edge();
				vertexInfo[i].setStart(Integer.parseInt(splitStr[0]));
				vertexInfo[i].setEnd(Integer.parseInt(splitStr[1]));
				vertexInfo[i].setWeight(Integer.parseInt(splitStr[2]));
			}
		}
	}

	// 파일 저장 함수
	public void file_save() {
		String path = System.getProperty("user.dir");
		File file = new File(path + "/src/Resource/Kruskal_output.txt");
		FileWriter writer = null;
		try {
			writer = new FileWriter(file, false);
			writer.write("Vertex, Vertex, 비용" + "\r\n");
			for (int i = 0; i < A.size(); i++) {
				writer.write(A.get(i).getStart() + " " + A.get(i).getEnd() + " " + A.get(i).getWeight() + "\r\n");
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
