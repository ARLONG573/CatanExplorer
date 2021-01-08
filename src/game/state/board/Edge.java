package game.state.board;

import java.util.HashSet;
import java.util.Set;

/**
 * This class represents an edge on the Catan board. Edges are where roads are
 * built, and they have exactly 2 vertices each in the network.
 * 
 * @author Aaron Tetens
 */
public class Edge {

	private final Set<Vertex> vertices;

	private Road road;

	public Edge(final Vertex v1, final Vertex v2) {
		this.road = null;

		this.vertices = new HashSet<>();
		this.vertices.add(v1);
		this.vertices.add(v2);
	}

	/**
	 * Places the given road on this edge
	 * 
	 * @param road
	 */
	void placeRoad(final Road road) {
		this.road = road;
	}
}
