package game.state.deck;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * This class stores and applies changes to information related to the
 * development card deck.
 * 
 * @author Aaron Tetens
 */
public class Deck {

	/**
	 * The width required to paint the deck status
	 */
	public static final int PAINT_WIDTH = 300;

	/**
	 * The height required to paint the deck status
	 */
	public static final int PAINT_HEIGHT = 100;

	private static final String STATUS_PREFIX = "Dev cards remaining: ";
	private static final Font STATUS_FONT = new Font("Arial", Font.PLAIN, 26);

	private static final int INITIAL_CARD_COUNT = 25;

	// UI variables - consider refactoring if additional member variables make these
	// variables redundant
	private int numCardsRemaining;

	/**
	 * Constructs a new development card deck with the initial distribution of cards
	 */
	public Deck() {
		this.numCardsRemaining = INITIAL_CARD_COUNT;
	}

	/**
	 * @return A copy of this deck that can be modified without affecting this one
	 */
	public Deck copy() {
		// TODO once member variables are implemented
		return null;
	}

	/**
	 * Paints the current state of this deck
	 * 
	 * @param g
	 *            The graphics context to paint this board on
	 */
	public void paint(final Graphics g) {
		final String status = STATUS_PREFIX + this.numCardsRemaining;

		g.setFont(STATUS_FONT);
		g.setColor(Color.BLACK);
		g.drawString(status, 0, PAINT_HEIGHT / 2);
	}
}
