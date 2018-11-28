package Algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
	final int WHITE = 0;
	final int GRAY = 1;
	final int BLACK = 2;
	final int INFINITE = 9999;
	int[][] Graph;
	Vertex[] Vertex;
	Queue<Vertex> q = new LinkedList<Vertex>();

	public BFS() {
		int startNum; // 시작점 번호
		while (true) {
			System.out.println("시작점 번호를 선택하세요");
			Scanner sc = new Scanner(System.in);
			startNum = sc.nextInt();
			if (startNum > 7 || startNum < 0)
				continue;
			break;
		}

		graph_read(); // 파일 읽기
		init(); // 초기화
		BFS(Graph, startNum); // BFS

		// 출력
		for (int i = 0; i < Vertex.length; i++) {
			System.out.println(Vertex[i].getD());
		}
	}

	public void init() {
		for (int i = 0; i < Vertex.length; i++) {
			Vertex[i] = new Vertex();
		}
	}

	public void BFS(int[][] Graph, int s) {
		for (int i = 0; i < Vertex.length; i++) {
			Vertex[i].setColor(WHITE);
			Vertex[i].setD(9999);
			Vertex[i].setP(null);
		}
		Vertex[s].setColor(GRAY);
		Vertex[s].setD(0);
		Vertex[s].setP(null);
		q.offer(Vertex[s]);
		while (!q.isEmpty()) {
			Vertex u = q.poll();
			int uNum = 0;
			for (int i = 0; i < Vertex.length; i++) {
				if (Vertex[i] == u) {
					uNum = i;
				}
			}
			for (int i = 0; i < Graph[s].length; i++) {
				if (Graph[uNum][i] == 1) {
					System.out.println(uNum + "," + i);
					if (Vertex[i].getColor() == WHITE) {
						Vertex[i].setColor(GRAY);
						Vertex[i].setD(u.getD() + 1);
						;
						Vertex[i].setP(u);
						q.offer(Vertex[i]);
					}
				}
			}
			u.setColor(BLACK);
		}
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
