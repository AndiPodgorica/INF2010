import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class Main {
	
	public static void main(String[] args) {
		Graph g = new Graph();
		System.out.println("TP05 : Graphes");
		
		// Partie 1: A completer : Création du graphe
		Node A = new Node(1, "A");
		Node B = new Node(2, "B");
		Node C = new Node(3, "C");
		Node D = new Node(4, "D");
		Node E = new Node(5, "E");
		Node F = new Node(6, "F");
		Node G = new Node(7, "G");

		List<Node> nodes = new LinkedList<>();
		nodes.add(A);
		nodes.add(B);
		nodes.add(C);
		nodes.add(D);
		nodes.add(E);
		nodes.add(F);
		nodes.add(G);
		g.setNodes(nodes);

		List<Edge> edges = new LinkedList<>();
		edges.add(new Edge(A, B, 2));
		edges.add(new Edge(B, A, 2));
		edges.add(new Edge(A, C, 1));
		edges.add(new Edge(C, A, 1));
		edges.add(new Edge(B, D, 1));
		edges.add(new Edge(D, B, 1));
		edges.add(new Edge(B, C, 2));
		edges.add(new Edge(C, B, 2));
		edges.add(new Edge(B, E, 3));
		edges.add(new Edge(E, B, 3));
		edges.add(new Edge(C, D, 4));
		edges.add(new Edge(D, C, 4));
		edges.add(new Edge(C, E, 3));
		edges.add(new Edge(E, C, 3));
		edges.add(new Edge(C, F, 5));
		edges.add(new Edge(F, C, 5));
		edges.add(new Edge(D, F, 6));
		edges.add(new Edge(F, D, 6));
		edges.add(new Edge(D, G, 5));
		edges.add(new Edge(G, D, 5));
		edges.add(new Edge(E, F, 1));
		edges.add(new Edge(F, E, 1));
		edges.add(new Edge(F, G, 2));
		edges.add(new Edge(G, F, 2));
		g.setEdges(edges);



		
		// Partie 2: A completer : Implémentation de l’algorithme Dijkstra

		Dijkstra d = new Dijkstra(g);

		d.findPath(A,G);

		d.showTable();

		// Affichage le chemin le plus court :
		System.out.println(d.printShortPath(A,G));

	}
}
