package game.state.board;

import java.awt.Graphics;
import java.util.HashSet;
import java.util.Set;

import startup.board.data.selectable.PortType;

/**
 * This class represents a vertex on the Catan board. Vertices are where
 * settlements are built, and they have 2-3 edges each in the network.
 * 
 * @author Aaron Tetens
 */
public class Vertex {

	private final Set<Vertex> adjacents;
	private final int x;
	private final int y;

	private Settlement settlement;

	// port drawing code is in the Hex class since it is easier to draw from there
	// so, we only need the port type while executing game-related logic
	private PortType port;

	/**
	 * Creates a vertex that will be drawn at (x, y) on the BoardPanel
	 * 
	 * @param x
	 * @param y
	 */
	public Vertex(final int x, final int y) {
		this.x = x;
		this.y = y;

		this.adjacents = new HashSet<>();
		this.settlement = null;
		this.port = null;
	}

	/**
	 * @return The x-coordinate of this vertex
	 */
	int getX() {
		return this.x;
	}

	/**
	 * @return The y-coordinate of this vertex
	 */
	int getY() {
		return this.y;
	}

	/**
	 * Paints this vertex on the given graphics context
	 * 
	 * @param g
	 */
	void paint(final Graphics g) {

	}

	/**
	 * Sets the port type to the given type
	 * 
	 * @param port
	 */
	void setPortType(final PortType port) {
		this.port = port;
	}

	/**
	 * Places the given settlement on this vertex
	 * 
	 * @param settlement
	 */
	void placeSettlement(final Settlement settlement) {
		this.settlement = settlement;
	}

	/**
	 * Adds the given vertices as adjacent vertices
	 * 
	 * @param adjacents
	 */
	void addAdjacentVertices(final Vertex... adjacents) {
		for (final Vertex adjacent : adjacents) {
			this.addAdjacentVertex(adjacent);
		}
	}

	/**
	 * Adds the given vertex as an adjacent vertex
	 * 
	 * @param adjacent
	 */
	private void addAdjacentVertex(final Vertex adjacent) {
		this.adjacents.add(adjacent);
	}
}
