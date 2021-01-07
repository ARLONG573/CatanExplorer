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

	private final Set<Vertex> children;

	private Settlement building;

	public Vertex() {
		this.children = new HashSet<>();
		this.building = null;
	}

	/**
	 * Adds the given vertices as children vertices
	 * 
	 * @param children
	 */
	void addChildren(final Vertex... children) {
		for (final Vertex child : children) {
			this.addChild(child);
		}
	}

	/**
	 * Adds the given vertex as a child vertex
	 * 
	 * @param child
	 */
	private void addChild(final Vertex child) {
		this.children.add(child);
	}
}
