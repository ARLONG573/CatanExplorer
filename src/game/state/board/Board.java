package game.state.board;

import java.awt.Color;
import java.awt.Graphics;

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
