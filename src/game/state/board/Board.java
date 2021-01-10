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
		this.assignAdjacencies(0, 3, 4);
		this.assignAdjacencies(1, 4, 5);
		this.assignAdjacencies(2, 5, 6);
		this.assignAdjacencies(3, 0, 7);
		this.assignAdjacencies(4, 0, 1, 8);
		this.assignAdjacencies(5, 1, 2, 9);
		this.assignAdjacencies(6, 2, 10);
		this.assignAdjacencies(7, 3, 11, 12);
		this.assignAdjacencies(8, 4, 12, 13);
		this.assignAdjacencies(9, 5, 13, 14);
		this.assignAdjacencies(10, 6, 14, 15);
		this.assignAdjacencies(11, 7, 16);
		this.assignAdjacencies(12, 7, 8, 17);
		this.assignAdjacencies(13, 8, 9, 18);
		this.assignAdjacencies(14, 9, 10, 19);
		this.assignAdjacencies(15, 10, 20);
		this.assignAdjacencies(16, 11, 21, 22);
		this.assignAdjacencies(17, 12, 22, 23);
		this.assignAdjacencies(18, 13, 23, 24);
		this.assignAdjacencies(19, 14, 24, 25);
		this.assignAdjacencies(20, 15, 25, 26);
		this.assignAdjacencies(21, 16, 27);
		this.assignAdjacencies(22, 16, 17, 28);
		this.assignAdjacencies(23, 17, 18, 29);
		this.assignAdjacencies(24, 18, 19, 30);
		this.assignAdjacencies(25, 19, 20, 31);
		this.assignAdjacencies(26, 20, 32);
		this.assignAdjacencies(27, 21, 33);
		this.assignAdjacencies(28, 22, 33, 34);
		this.assignAdjacencies(29, 23, 34, 35);
		this.assignAdjacencies(30, 24, 35, 36);
		this.assignAdjacencies(31, 25, 36, 37);
		this.assignAdjacencies(32, 26, 37);
		this.assignAdjacencies(33, 27, 28, 38);
		this.assignAdjacencies(34, 28, 29, 39);
		this.assignAdjacencies(35, 29, 30, 40);
		this.assignAdjacencies(36, 30, 31, 41);
		this.assignAdjacencies(37, 31, 32, 42);
		this.assignAdjacencies(38, 33, 43);
		this.assignAdjacencies(39, 34, 43, 44);
		this.assignAdjacencies(40, 35, 44, 45);
		this.assignAdjacencies(41, 36, 45, 46);
		this.assignAdjacencies(42, 37, 46);
		this.assignAdjacencies(43, 38, 39, 47);
		this.assignAdjacencies(44, 39, 40, 48);
		this.assignAdjacencies(45, 40, 41, 49);
		this.assignAdjacencies(46, 41, 42, 50);
		this.assignAdjacencies(47, 43, 51);
		this.assignAdjacencies(48, 44, 51, 52);
		this.assignAdjacencies(49, 45, 52, 53);
		this.assignAdjacencies(50, 46, 53);
		this.assignAdjacencies(51, 47, 48);
		this.assignAdjacencies(52, 48, 49);
		this.assignAdjacencies(53, 49, 50);

		// test everything
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
	 * Assigns an array of vertices as adjacent to some vertex
	 * 
	 * @param id
	 *            The id of the vertex that is being assigned to
	 * @param ids
	 *            The ids of the vertices that are adjacent to it
	 */
	private void assignAdjacencies(final int id, final int... ids) {
		final int n = ids.length;
		final Vertex[] vertices = new Vertex[n];

		for (int i = 0; i < n; i++) {
			vertices[i] = this.getVertex(ids[i]);
		}

		this.getVertex(id).addAdjacentVertices(vertices);
	}

	/**
	 * @param id
	 * @return The vertex on this board with the given id
	 */
	private Vertex getVertex(final int id) {
		return this.vertices.get(id);
	}
}
