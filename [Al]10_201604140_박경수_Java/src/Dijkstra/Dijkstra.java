package dijkstra;

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
	int d;
	Root link;

	public int getnumber() {
		return number;
	}

	public void setnumber(int number) {
		this.number = number;
	}

	public int getd() {
		return d;
	}

	public void setd(int d) {
		this.d = d;
	}

	public Root getlink() {
		return link;
	}

	public void setlink(Root link) {
		this.link = link;
	}
}

public class dijkstra {
	final int INFINITE = 99999; // ������ 99999�� ǥ��
	Root[] vertexList; // ���� ����
	Edge[] vertexInfo; // vertex�� ���� ����Ʈ
	ArrayList<Root> adjRoot = new ArrayList<>(); // ���� ���� ����
	ArrayList<Edge> adjVertex = new ArrayList<>(); // ���� ���� ����
	ArrayList<Root> Q = new ArrayList<>(); // ť
	ArrayList<Root> S = new ArrayList<>(); // ���� ����
	ArrayList<String> Str = new ArrayList<>(); // ���� ����� ����� ���� ����

	public dijkstra() {
		graph_read();
		MST_dijkstra(vertexInfo, 0);
		
		int D = 0;
		for(int i = 0; i < S.size(); i++) {
			String str = "";
			Root temp = vertexList[i];
			if(temp.getlink() == null) {
				str = str + temp.getnumber() + " 0";
				Str.add(str);
				continue;
			}
			D = temp.getd();
			while(temp != null) {
				str = str + temp.getnumber();
				temp = temp.getlink();
				if(temp == null) {
					str = str + " " + D;
				} else {
					str = str + "<-";
				}
			}
			D = 0;
			Str.add(str);
		}

		file_save();
		
		System.out.println("dijkstra Algorithm�Ϸ�!");
		System.out.println("================================");
	}

	public void MST_dijkstra(Edge[] G, int r) {
		for (int i = 0; i < vertexList.length; i++) {
			vertexList[i].setd(INFINITE);
			vertexList[i].setlink(null);
		}
		vertexList[r].setd(0);

		for (int i = 0; i < vertexList.length; i++) {
			Q.add(vertexList[i]);
		}

		while (!Q.isEmpty()) {
			if (Q.isEmpty())
				continue;
			Root u = ExtractMin(Q);
			
			S.add(u);

			for (Root v : adjRoot(u)) {
				//relax
				if(v.getd() > u.getd() + w(u, v)) {
					v.setd(u.getd()+w(u, v));
					v.setlink(u);
				}
			}
			// Q���� ����
			for (int i = 0; i < Q.size(); i++) {
				if (Q.get(i).equals(u)) {
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

		for (int i = 0; i < vertexInfo.length; i++) {
			if (vertexInfo[i].getStart() == start && vertexInfo[i].getEnd() == end) {
				return vertexInfo[i].getWeight();
			}
		}
		return INFINITE;
	}

	// ���� ������ ����
	public ArrayList<Root> adjRoot(Root u) {
		for (int i = 0; i < vertexInfo.length; i++) {
			if (u.getnumber() == vertexInfo[i].getStart()) {
				adjRoot.add(vertexList[vertexInfo[i].getEnd()]);
			}
		}
		return adjRoot;
	}

	// Min-Heap
	public Root ExtractMin(ArrayList<Root> array) {
		ArrayList<Root> TempQ = new ArrayList<>();

		for (int i = 0; i < array.size(); i++) {
			TempQ.add(array.get(i));
		}

		// build-heap
		Build_Heap(TempQ, TempQ.size() - 1);
		// heap-sort
		for (int i = TempQ.size() - 1; i > 0; i--) {
			Collections.swap(TempQ, 0, i);
			Heapify(TempQ, 0, i - 1);
		}
		return TempQ.get(TempQ.size() - 1);
	}

	public void Build_Heap(ArrayList<Root> array, int length) {
		for (int i = (length / 2); i >= 0; i--) {
			Heapify(array, i, length);
		}
	}

	public void Heapify(ArrayList<Root> array, int i, int length) {
		int l = 2 * i;
		int r = 2 * i + 1;
		int smallest = 0;
		if (r <= length) {
			if (array.get(l).getd() < array.get(r).getd())
				smallest = l;
			else
				smallest = r;
		} else if (l <= length)
			smallest = l;
		else
			return;

		if (array.get(smallest).getd() < array.get(i).getd()) {
			Collections.swap(array, i, smallest);
			Heapify(array, smallest, length);
		}
	}

	// ���� �о���� �Լ�
	public void graph_read() {
		ArrayList<String> array = new ArrayList<>();
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/src/Resource/graph_sample_dijkstra.txt");
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

	// ���� ���� �Լ�
	public void file_save() {
		String path = System.getProperty("user.dir");
		File file = new File(path + "/src/Resource/dijkstra_output.txt");
		FileWriter writer = null;
		try {
			writer = new FileWriter(file, false);
			for (int i = 0; i < Str.size(); i++) {
				writer.write(Str.get(i) + "\r\n");
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
