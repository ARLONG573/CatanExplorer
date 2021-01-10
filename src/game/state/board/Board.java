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
	private static final int NUM_EDGES = 72;
	private static final int NUM_HEXES = 19;

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

	// these variables define which 2 vertices belong to each edge
	private static final int[] EDGE_V1_ID = { 3, 0, 4, 1, 5, 2, 3, 4, 5, 6, 11, 7, 12, 8, 13, 9, 14, 10, 11, 12, 13, 14,
			15, 21, 16, 22, 17, 23, 18, 24, 19, 25, 20, 21, 22, 23, 24, 25, 26, 27, 33, 28, 34, 29, 35, 30, 36, 31, 37,
			33, 34, 35, 36, 37, 38, 43, 39, 44, 40, 45, 41, 46, 43, 44, 45, 46, 47, 51, 48, 52, 49, 53 };
	private static final int[] EDGE_V2_ID = { 0, 4, 1, 5, 2, 6, 7, 8, 9, 10, 7, 12, 8, 13, 9, 14, 10, 15, 16, 17, 18,
			19, 20, 16, 22, 17, 23, 18, 24, 19, 25, 20, 26, 27, 28, 29, 30, 31, 32, 33, 28, 34, 29, 35, 30, 36, 31, 37,
			32, 38, 39, 40, 41, 42, 43, 39, 44, 40, 45, 41, 46, 42, 47, 48, 49, 50, 51, 48, 52, 49, 53, 50 };

	// these variables define which 6 vertices belong to each hex
	private static final int[] HEX_V1_ID = { 0, 1, 2, 7, 8, 9, 10, 16, 17, 18, 19, 20, 28, 29, 30, 31, 39, 40, 41 };
	private static final int[] HEX_V2_ID = { 4, 5, 6, 12, 13, 14, 15, 22, 23, 24, 25, 26, 34, 35, 36, 37, 44, 45, 46 };
	private static final int[] HEX_V3_ID = { 8, 9, 10, 17, 18, 19, 20, 28, 29, 30, 31, 32, 39, 40, 41, 42, 48, 49, 50 };
	private static final int[] HEX_V4_ID = { 12, 13, 14, 22, 23, 24, 25, 33, 34, 35, 36, 37, 43, 44, 45, 46, 51, 52,
			53 };
	private static final int[] HEX_V5_ID = { 7, 8, 9, 16, 17, 18, 19, 27, 28, 29, 30, 31, 38, 39, 40, 41, 47, 48, 49 };
	private static final int[] HEX_V6_ID = { 3, 4, 5, 11, 12, 13, 14, 21, 22, 23, 24, 25, 33, 34, 35, 36, 43, 44, 45 };

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
		for (int i = 0; i < NUM_EDGES; i++) {
			this.edges.add(new Edge(this.getVertex(EDGE_V1_ID[i]), this.getVertex(EDGE_V2_ID[i])));
		}

		// make hexes
		for (int i = 0; i < NUM_HEXES; i++) {
			this.hexes.add(new Hex(hexData.get(i), this.getVertex(HEX_V1_ID[i]), this.getVertex(HEX_V2_ID[i]),
					this.getVertex(HEX_V3_ID[i]), this.getVertex(HEX_V4_ID[i]), this.getVertex(HEX_V5_ID[i]),
					this.getVertex(HEX_V6_ID[i])));
		}

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
		// paint the hexes and ports first
		for (final Hex hex : this.hexes) {
			hex.paint(g);
		}

		// paint the edges next
		for (final Edge edge : this.edges) {
			edge.paint(g);
		}

		// paint the vertices on top
		for (final Vertex vertex : this.getVertices()) {
			vertex.paint(g);
		}

	}

	/**
	 * @return The vertices on this board
	 */
	private Collection<Vertex> getVertices() {
		return this.vertices.values();
	}

	/**
	 * @param id
	 * @return The vertex on this board with the given id
	 */
	private Vertex getVertex(final int id) {
		return this.vertices.get(id);
	}
}
