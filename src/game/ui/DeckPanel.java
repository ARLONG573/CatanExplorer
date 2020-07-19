package game.ui;

import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This panel displays information about the current state of the deck.
 * 
 * @author Aaron Tetens
 */
class DeckPanel extends JPanel {

	private static final long serialVersionUID = -8530374916509543309L;

	private static DeckPanel theInstance;

	private DeckPanel() {
		super.add(new JLabel("DECK PANEL"));
	}

	/**
	 * @return The DeckPanel instance
	 */
	static DeckPanel getInstance() {
		if (theInstance == null) {
			theInstance = new DeckPanel();
		}

		return theInstance;
	}

	@Override
	protected void paintComponent(final Graphics g) {
		super.paintComponent(g);

		GameFrame.getInstance().getGameState().paintDeck(g);
	}
}
