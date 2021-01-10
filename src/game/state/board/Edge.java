package game.state.board;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class represents an edge on the Catan board. Edges are where roads are
 * built, and they have exactly 2 vertices each in the network.
 * 
 * @author Aaron Tetens
 */
public class Edge {

	private final Vertex v1;
	private final Vertex v2;

	private Road road;

	public Edge(final Vertex v1, final Vertex v2) {
		this.road = null;

		this.v1 = v1;
		this.v2 = v2;
	}

	/**
	 * Paints this edge on the given graphics context
	 * 
	 * @param g
	 */
	void paint(final Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(this.v1.getX(), this.v1.getY(), this.v2.getX(), this.v2.getY());
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
