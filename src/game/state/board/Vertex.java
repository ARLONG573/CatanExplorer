package game.state.board;

import java.util.HashSet;
import java.util.Set;

/**
 * This class represents a vertex on the Catan board. Vertices are where
 * settlements are built, and they have 2-3 edges each in the network.
 * 
 * @author Aaron Tetens
 */
public class Vertex {

	private final Set<Vertex> adjacents;

	private Settlement settlement;

	public Vertex() {
		this.adjacents = new HashSet<>();
		this.settlement = null;
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
