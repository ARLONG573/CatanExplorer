package game.ui;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;

import game.state.deck.Deck;

/**
 * The deck label is where the deck status is drawn in a given state.
 * 
 * @author Aaron Tetens
 */
class DeckLabel extends JLabel {

	private static final long serialVersionUID = 559679362561033667L;

	private static DeckLabel theInstance;

	private DeckLabel() {
		super.setPreferredSize(new Dimension(Deck.PAINT_WIDTH, Deck.PAINT_HEIGHT));
	}

	/**
	 * @return The DeckLabel instance
	 */
	static DeckLabel getInstance() {
		if (theInstance == null) {
			theInstance = new DeckLabel();
		}

		return theInstance;
	}

	@Override
	protected void paintComponent(final Graphics g) {
		super.paintComponent(g);

		GameFrame.getInstance().getGameState().paintDeck(g);
	}

}
