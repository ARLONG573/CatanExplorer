package game.state.board;

import java.awt.Graphics;

/**
 * This class represents an edge on the Catan board. Edges are where roads are
 * built, and they have exactly 2 vertices each in the network.
 * 
 * @author Aaron Tetens
 */
public class Edge {

	private final Vertex[] vertices;

	private Road road;

	public Edge(final Vertex v1, final Vertex v2) {
		this.road = null;

		this.vertices = new Vertex[2];
		this.vertices[0] = v1;
		this.vertices[1] = v2;
	}

	/**
	 * Paints this edge on the given graphics context
	 * 
	 * @param g
	 */
	void paint(final Graphics g) {

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
