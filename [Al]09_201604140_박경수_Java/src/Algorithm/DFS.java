package Algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DFS {
	final int WHITE = 0;
	final int GRAY = 1;
	final int BLACK = 2;
	final int INFINITE = 9999;
	int[][] Graph;
	Vertex[] Vertex;
	int time = 0;

	public DFS() {
		graph_read(); // 파일 읽기
		init(); // 초기화
		DFS(Graph); // DFS

		// 출력
		for (int v = 0; v < Vertex.length; v++) {
			System.out.println(Vertex[v].getD() + "  " + Vertex[v].getF());
		}

	}

	public void init() {
		for (int v = 0; v < Vertex.length; v++) {
			Vertex[v] = new Vertex();
		}
	}

	public void DFS(int[][] G) {
		for (int v = 0; v < Vertex.length; v++) {
			Vertex[v].setColor(WHITE);
			Vertex[v].setP(null);
		}
		time = 0;
		for (int v = 0; v < Vertex.length; v++) {
			if (Vertex[v].getColor() == WHITE) {
				DFS_VISIT(G, Vertex[v]);
			}
		}
	}

	public void DFS_VISIT(int[][] G, Vertex u) {
		time = time + 1;
		u.setD(time);
		u.setColor(GRAY);

		// 몇 번째 Vertex인지 확인
		int uNum = 0;
		for (int v = 0; v < Vertex.length; v++) {
			if (Vertex[v] == u) {
				uNum = v;
			}
		}

		// 인접 행렬
		for (int v = 0; v < Graph[uNum].length; v++) {
			if (Graph[uNum][v] == 1) {
				if (Vertex[v].getColor() == WHITE) {
					Vertex[v].setP(u);
					DFS_VISIT(G, Vertex[v]);
				}
			}
		}

		u.setColor(BLACK);
		time = time + 1;
		u.setF(time);

	}

	// 파일 읽어오기 함수
	public void graph_read() {
		try {
			String path = System.getProperty("user.dir");
			File file = new File(path + "/src/Resource/graph.txt");
			FileReader filereader = new FileReader(file);
			BufferedReader bufreader = new BufferedReader(filereader);
			String line = "";
			int index = 0;
			while ((line = bufreader.readLine()) != null) {
				if (index == 0) {
					Graph = new int[Integer.parseInt(line)][Integer.parseInt(line)];
					Vertex = new Vertex[Integer.parseInt(line)];
				} else {
					int j = 0;
					for (int i = 0; i < line.length(); i++) {
						if (i % 2 == 0) {
							Graph[index - 1][j++] = line.charAt(i) - 48;
						}
					}
				}
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
