package Main;

import Algorithm.Dijkstra;
import Algorithm.Kruskal;
import Algorithm.Prim;
import Algorithm.bellmanFord;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Prim Algorithm�� �����մϴ�...");
		Prim Prim = new Prim();
		System.out.println("Dijkstra Algorithm�� �����մϴ�...");
		Dijkstra Dijkstra = new Dijkstra();
		System.out.println("Kruskal Algorithm�� �����մϴ�...");
		Kruskal Kruskal = new Kruskal();
		System.out.println("Bellman Ford Algorithm�� �����մϴ�...");
		bellmanFord bellmanFord = new bellmanFord();
	}

}
