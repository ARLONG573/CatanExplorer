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

	public Edge() {
		this.vertices = new HashSet<>();
		this.road = null;
	}

	/**
	 * Places the given road on this edge
	 * 
	 * @param road
	 */
	void placeRoad(final Road road) {
		this.road = road;
	}

	/**
	 * Adds the given vertices as the endpoints of this edge
	 * 
	 * @param vertices
	 */
	void addVertices(final Vertex... vertices) {
		for (final Vertex vertex : vertices) {
			this.addVertex(vertex);
		}
	}

	/**
	 * Adds the given vertex as an endpoint of this edge
	 * 
	 * @param vertex
	 */
	private void addVertex(final Vertex vertex) {
		this.vertices.add(vertex);
	}
}
