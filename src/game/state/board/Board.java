package game.state.board;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashSet;
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

	// The board is stored as a network of vertices and edges (in other words,
	// settlement spots and road spots)
	// Hexes store which vertices are on them, allowing us to apply real-world
	// actions to the network
	private final Set<Vertex> vertices;
	private final Set<Edge> edges;
	private final Set<Hex> hexes;

	public Board() {
		this.vertices = new HashSet<>();
		this.edges = new HashSet<>();
		this.hexes = new HashSet<>();

		// TODO populate the above sets
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
		// TODO this is a placeholder until member variables are implemented
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, PAINT_SIZE, PAINT_SIZE);
	}
}
