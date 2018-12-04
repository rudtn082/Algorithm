package Main;

import Algorithm.BFS;
import Algorithm.DFS;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("BFS의 각 Vertex에 도달하는 탐색 시간을 출력합니다...");
		BFS BFS = new BFS();
		System.out.println("-------------------------------------------");
		System.out.println("DFS의 각 Vertex의 도착, 빠져나온 시간을 출력합니다...");
		DFS DFS = new DFS();
	}

}
