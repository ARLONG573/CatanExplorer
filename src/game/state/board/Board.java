package game.state.board;

import java.awt.Graphics;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This class stores and applies changes to information related to the game
 * board.
 * 
 * @author Aaron Tetens
 */
public class Board {

	/**
	 * The width/height required to paint the board
	 */
	public static final int PAINT_SIZE = 600;

	private static final int NUM_VERTICES = 54;

	// these variables help with the math to assign (x, y) values to vertices
	// the board is split into an uneven lattice whose points contain the vertices
	private static final int V_GAP_SMALL = (int) (40 * Math.sqrt(3) / 3);
	private static final int V_GAP_LARGE = (int) (80 - 16 * Math.sqrt(3));
	private static final int[] X_POINTS = { 220, 300, 380, 180, 260, 340, 420, 180, 260, 340, 420, 140, 220, 300, 380,
			460, 140, 220, 300, 380, 460, 100, 180, 260, 340, 420, 500, 100, 180, 260, 340, 420, 500, 140, 220, 300,
			380, 460, 140, 220, 300, 380, 460, 180, 260, 340, 420, 180, 260, 340, 420, 220, 300, 380 };
	private static final int[] Y_POINTS = { 100, 100, 100, 100 + V_GAP_SMALL, 100 + V_GAP_SMALL, 100 + V_GAP_SMALL,
			100 + V_GAP_SMALL, 100 + V_GAP_SMALL + V_GAP_LARGE, 100 + V_GAP_SMALL + V_GAP_LARGE,
			100 + V_GAP_SMALL + V_GAP_LARGE, 100 + V_GAP_SMALL + V_GAP_LARGE, 100 + 2 * V_GAP_SMALL + V_GAP_LARGE,
			100 + 2 * V_GAP_SMALL + V_GAP_LARGE, 100 + 2 * V_GAP_SMALL + V_GAP_LARGE,
			100 + 2 * V_GAP_SMALL + V_GAP_LARGE, 100 + 2 * V_GAP_SMALL + V_GAP_LARGE,
			100 + 2 * V_GAP_SMALL + 2 * V_GAP_LARGE, 100 + 2 * V_GAP_SMALL + 2 * V_GAP_LARGE,
			100 + 2 * V_GAP_SMALL + 2 * V_GAP_LARGE, 100 + 2 * V_GAP_SMALL + 2 * V_GAP_LARGE,
			100 + 2 * V_GAP_SMALL + 2 * V_GAP_LARGE, 100 + 3 * V_GAP_SMALL + 2 * V_GAP_LARGE,
			100 + 3 * V_GAP_SMALL + 2 * V_GAP_LARGE, 100 + 3 * V_GAP_SMALL + 2 * V_GAP_LARGE,
			100 + 3 * V_GAP_SMALL + 2 * V_GAP_LARGE, 100 + 3 * V_GAP_SMALL + 2 * V_GAP_LARGE,
			100 + 3 * V_GAP_SMALL + 2 * V_GAP_LARGE, 100 + 3 * V_GAP_SMALL + 3 * V_GAP_LARGE,
			100 + 3 * V_GAP_SMALL + 3 * V_GAP_LARGE, 100 + 3 * V_GAP_SMALL + 3 * V_GAP_LARGE,
			100 + 3 * V_GAP_SMALL + 3 * V_GAP_LARGE, 100 + 3 * V_GAP_SMALL + 3 * V_GAP_LARGE,
			100 + 3 * V_GAP_SMALL + 3 * V_GAP_LARGE, 100 + 4 * V_GAP_SMALL + 3 * V_GAP_LARGE,
			100 + 4 * V_GAP_SMALL + 3 * V_GAP_LARGE, 100 + 4 * V_GAP_SMALL + 3 * V_GAP_LARGE,
			100 + 4 * V_GAP_SMALL + 3 * V_GAP_LARGE, 100 + 4 * V_GAP_SMALL + 3 * V_GAP_LARGE,
			100 + 4 * V_GAP_SMALL + 4 * V_GAP_LARGE, 100 + 4 * V_GAP_SMALL + 4 * V_GAP_LARGE,
			100 + 4 * V_GAP_SMALL + 4 * V_GAP_LARGE, 100 + 4 * V_GAP_SMALL + 4 * V_GAP_LARGE,
			100 + 4 * V_GAP_SMALL + 4 * V_GAP_LARGE, 100 + 5 * V_GAP_SMALL + 4 * V_GAP_LARGE,
			100 + 5 * V_GAP_SMALL + 4 * V_GAP_LARGE, 100 + 5 * V_GAP_SMALL + 4 * V_GAP_LARGE,
			100 + 5 * V_GAP_SMALL + 4 * V_GAP_LARGE, 100 + 5 * V_GAP_SMALL + 5 * V_GAP_LARGE,
			100 + 5 * V_GAP_SMALL + 5 * V_GAP_LARGE, 100 + 5 * V_GAP_SMALL + 5 * V_GAP_LARGE,
			100 + 5 * V_GAP_SMALL + 5 * V_GAP_LARGE, 100 + 6 * V_GAP_SMALL + 5 * V_GAP_LARGE,
			100 + 6 * V_GAP_SMALL + 5 * V_GAP_LARGE, 100 + 6 * V_GAP_SMALL + 5 * V_GAP_LARGE, };

	// The board is stored as a network of vertices and edges (in other words,
	// settlement spots and road spots)
	// Hexes store which vertices are on them, allowing us to apply real-world
	// actions to the network
	private final Map<Integer, Vertex> vertices;
	private final Set<Edge> edges;
	private final Set<Hex> hexes;

	// Vertex reference map, needed to construct the network after creating the set
	// of hexes

	public Board(final List<startup.board.editable.Hex> hexData) {
		this.vertices = new HashMap<>();
		this.edges = new HashSet<>();
		this.hexes = new HashSet<>();

		// make vertices (ids are assigned left-right, then top-bottom)
		for (int i = 0; i < NUM_VERTICES; i++) {
			this.vertices.put(i, new Vertex(X_POINTS[i], Y_POINTS[i]));
		}
		
		// make edges
		// make hexes

		// assign vertex adjacencies
	}

	/**
	 * @return A copy of this board that can be modified without affecting this one
	 */
	public Board copy() {
		// TODO once member variables are implemented
		return null;
	}

	/**
	 * Paints the current state of this board
	 * 
	 * @param g
	 *            The graphics context to paint this board on
	 */
	public void paint(final Graphics g) {
		// paint the vertices
		for (final Vertex vertex : this.getVertices()) {
			vertex.paint(g);
		}

		// paint the edges
		for (final Edge edge : this.edges) {
			edge.paint(g);
		}

		// paint the hexes and ports
		for (final Hex hex : this.hexes) {
			hex.paint(g);
		}
	}

	private Collection<Vertex> getVertices() {
		return this.vertices.values();
	}
}
