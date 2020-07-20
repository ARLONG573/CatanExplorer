package game.ui;

import java.awt.BorderLayout;

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
		super.setLayout(new BorderLayout());
		super.add(DeckLabel.getInstance(), BorderLayout.EAST);
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
}
