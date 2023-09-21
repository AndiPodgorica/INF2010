import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.*;



public class Dijkstra {

	private Graph graph;
	private Map<Node, Edge> dijkstraTable[];
	private Stack<Edge> path;


	public Dijkstra(Graph g) {
		this.graph = g;
	}

	public void findPath(Node s, Node d) {

		dijkstraTable = new HashMap[graph.getNodes().size()];
		path = new Stack<Edge>();

		// A compléter
		for(int i = 0; i < graph.getNodes().size(); i++){
			dijkstraTable[i] = new HashMap();
		}

		dijkstraTable[0].put(s, new Edge(s, s));
		Node currentNode = s;
		path.push(dijkstraTable[0].get(currentNode));

		List<Node> visitedNodes = new LinkedList<>();
		int previousDist = 0;
		for (int i = 1; i < graph.getNodes().size() && currentNode != d; i++) {
			dijkstraTable[i].putAll(dijkstraTable[i-1]);
			dijkstraTable[i].remove(currentNode);
			List<Edge> e = graph.getEdgesGoingFrom(currentNode);
			visitedNodes.add(currentNode);

			for (Edge edgeToSuccessors: e) {
				edgeToSuccessors = new Edge(edgeToSuccessors.getSource(), edgeToSuccessors.getDestination(), edgeToSuccessors.getDistance() + previousDist);
				Node successorDestionation = edgeToSuccessors.getDestination();
				if (!visitedNodes.contains(successorDestionation)){
					if (dijkstraTable[i-1].containsKey(successorDestionation)){
						dijkstraTable[i].put(successorDestionation, getMinimum(dijkstraTable[i-1].get(successorDestionation), edgeToSuccessors));
					} else {
						dijkstraTable[i].put(successorDestionation, edgeToSuccessors);
					}
				}
			}
			currentNode = getMinimum(dijkstraTable[i]);
			previousDist = dijkstraTable[i].get(currentNode).getDistance();
			path.push(dijkstraTable[i].get(currentNode));
		}
	}


	private Node getMinimum(Map<Node, Edge> map) {
		Edge min = null;
		for (Node Key : map.keySet()) {
			if (min ==null || map.get(Key).getDistance() < min.getDistance()) {
				min = map.get(Key);
			}
		}
		return min.getDestination();
	}

	private Edge getMinimum(Edge e1, Edge e2) {
		// A completer
		if (e1 == null || e2 == null)
			return (e1 == null) ? e2 : e1;
		return (e1.getDistance() < e2.getDistance()) ? e1 : e2;
	}


	public void showTable() {
		// A complete
		List<Node> nodes = graph.getNodes();
		HashSet<Node> nodeDisplayed = new HashSet<>();

		for (Node key : nodes) {
			System.out.print(key.getName() + " | ");
		}
		System.out.println();

		for (Map<Node, Edge> map : dijkstraTable)
		{
			if (map != null)
			{
				for (Node key : nodes)
				{
					if (map.get(key) != null)
					{
						System.out.print(map.get(key).getDistance() + map.get(key).getSource().getName() + "| ");
						nodeDisplayed.add(key);
					}
					else if (!(nodeDisplayed.contains(key)))
					{
						System.out.print(" -| ");
					}
					else {
						System.out.print("  | ");
					}
				}
			} else {
				break;
			}
			System.out.println();
		}
	}


		public String printShortPath (Node source, Node destination)
		{
			this.findPath(source, destination);
			StringBuilder chemin = new StringBuilder();
			Edge lastEdge = path.pop();

			int longeurDuChemin = lastEdge.getDistance();
			chemin.append(lastEdge.getDestination().getName() + " ");

			while (!path.empty()) {
				if (!path.empty() && path.peek().getDestination() == lastEdge.getSource()) {
					chemin.append(lastEdge.getSource().getName() + " ");
					lastEdge = path.pop();
				} else {
					path.pop();
				}
			}
			System.out.print("La longueur du plus court chemin est : ");
			System.out.println(longeurDuChemin);
			return "Le chemin le plus court est : " + chemin.reverse().toString();

		}
	}

