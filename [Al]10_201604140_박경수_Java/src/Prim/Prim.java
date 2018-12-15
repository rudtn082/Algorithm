package Prim;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Root {
	int number;
	int key;
	Root link;
	
	public int getnumber() {
		return number;
	}
	public void setnumber(int number) {
		this.number = number;
	}
	public int getkey() {
		return key;
	}
	public void setkey(int key) {
		this.key = key;
	}
	public Root getlink() {
		return link;
	}
	public void setlink(Root link) {
		this.link = link;
	}
}

public class Prim {
	final int INFINITE = 99999; // 무한은 99999로 표현
	Root[] vertexList; // 정점 집합
	Edge[] vertexInfo; // vertex의 정보 리스트
	ArrayList<Root> adjRoot = new ArrayList<>(); // 인접 정점 집합
	ArrayList<Edge> adjVertex = new ArrayList<>(); // 인접 간선 집합
	ArrayList<Root> Q = new ArrayList<>(); // 큐
	
	public Prim() {
		graph_read();
		MST_Prim(vertexInfo, 0);
		file_save();
		System.out.println("Prim Algorithm완료!");
		System.out.println("================================");
	}
	
	public void MST_Prim(Edge[] G, int r) {
		for(int i = 0; i < vertexList.length; i++) {
			vertexList[i].setkey(INFINITE);
			vertexList[i].setlink(null);
		}
		vertexList[r].setkey(0);
		
		for(int i = 0; i < vertexList.length; i++) {
			Q.add(vertexList[i]);
		}
		
		while(!Q.isEmpty()) {
			if(Q.isEmpty()) continue;
			Root u = ExtractMin(Q);
			
			for(Root v : adjRoot(u)) {
				if(isinqueue(Q, v) && w(u, v) < v.getkey()) {
					v.setlink(u);
					v.setkey(w(u, v));
				}
			}
			// Q에서 삭제
			for(int i = 0; i < Q.size(); i++) {
				if(Q.get(i).equals(u)) {
					Q.remove(i);
					break;
				}
			}
			adjVertex.clear();
			adjRoot.clear();
		}
	}
	
	public int w(Root v1, Root v2) {
		int start = v1.getnumber();
		int end = v2.getnumber();
		
		for(int i = 0; i < vertexInfo.length; i ++) {
			if(vertexInfo[i].getStart() == start && vertexInfo[i].getEnd() == end) {
				return vertexInfo[i].getWeight();
			}
		}
		return INFINITE;
	}
	
	public boolean isinqueue(ArrayList<Root> q, Root v) {
		for(int i = 0; i < q.size(); i++) {
			if(v.getnumber() == q.get(i).getnumber()) {
				return true;
			}
		}
		return false;
	}
	
	// 인접  정점을 리턴
	public ArrayList<Root> adjRoot(Root u) {		
		for(int i=0; i< vertexInfo.length; i++) {
			if(u.getnumber() == vertexInfo[i].getStart()) {
				adjRoot.add(vertexList[vertexInfo[i].getEnd()]);
			}
		}
		return adjRoot;
	}
	
	// Min-Heap
	public Root ExtractMin(ArrayList<Root> array) {
		ArrayList<Root> TempQ = new ArrayList<>();
		
		for(int i = 0; i < array.size(); i++) {
			TempQ.add(array.get(i));
		}
		
		// build-heap
		Build_Heap(TempQ, TempQ.size()-1);
		// heap-sort
		for(int i = TempQ.size()-1; i > 0; i--) {
			Collections.swap(TempQ, 0, i);
			Heapify(TempQ, 0, i-1);
		}
		return TempQ.get(TempQ.size()-1);
	}
	
	public void Build_Heap(ArrayList<Root> array, int length) {
		for(int i = (length / 2); i >= 0; i--) {
			Heapify(array, i, length);
		}
	}
	
	public void Heapify(ArrayList<Root> array, int i, int length) {
		int l = 2*i;
		int r = 2*i+1;
		int smallest = 0;
		if(r <= length) {
			if(array.get(l).getkey() < array.get(r).getkey())
				smallest = l;
			else smallest = r;
		}
		else if(l <= length) smallest = l;
		else return;
		
		if(array.get(smallest).getkey() < array.get(i).getkey()) {
			Collections.swap(array, i, smallest);
			Heapify(array, smallest, length);
		}
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
			for(int i = 0; i< vertexInfo.length; i++) {
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
		File file = new File(path + "/src/Resource/prim_output.txt");
		FileWriter writer = null;
		try {
			writer = new FileWriter(file, false);
			writer.write("Vertex, Vertex, 비용" + "\r\n");
				for (int i = 0; i < vertexList.length; i++) {
					int tempNum = 0;
					if(vertexList[i].getlink() != null) {
						tempNum = vertexList[i].getlink().getnumber();
					}
					writer.write(vertexList[i].getnumber() + " " + tempNum + " " + vertexList[i].getkey() + "\r\n");
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
