package Main;

import Algorithm.Dijkstra;
import Algorithm.Kruskal;
import Algorithm.Prim;
import Algorithm.bellmanFord;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Prim Algorithm을 진행합니다...");
		Prim Prim = new Prim();
		System.out.println("Dijkstra Algorithm을 진행합니다...");
		Dijkstra Dijkstra = new Dijkstra();
		System.out.println("Kruskal Algorithm을 진행합니다...");
		Kruskal Kruskal = new Kruskal();
		System.out.println("Bellman Ford Algorithm을 진행합니다...");
		bellmanFord bellmanFord = new bellmanFord();
	}

}
