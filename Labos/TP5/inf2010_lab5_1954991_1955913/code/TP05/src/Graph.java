import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Graph {

	private List<Node> nodes; // Noeuds
	private List<Edge> edges; // Les arcs
	
	public Graph() {
		// A compléter
		nodes=new ArrayList<Node>();
		edges=new ArrayList<Edge>();
	}
	
	public List<Edge> getEdgesGoingFrom(Node source) {
		// A complèter
		List<Edge> edgesFromSource = new LinkedList<>();
		for (Edge edge: edges) {
			if (edge.getSource().equals(source)){
				edgesFromSource.add(edge);
			}
		}
		return edgesFromSource;
	}


	public List<Edge> getEdgesGoingTo(Node dest) {
		// A complèter
		List<Edge> edgesToDest = new LinkedList<>();
		for (Edge edge: edges) {
			if (edge.getDestination().equals(dest)){
				edgesToDest.add(edge);
			}
		}
		return edgesToDest;
	}
	
	// Accesseurs 
	public List<Node> getNodes() {
		return nodes;
	}
	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
	public List<Edge> getEdges() {
		return edges;
	}
	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
	
}
