package game.ui;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This panel contains the buttons that allows the user to input game actions as
 * they occur (rolling the dice, trading, building, and playing development
 * cards).
 * 
 * @author Aaron Tetens
 */
class ActionsPanel extends JPanel {

	private static final long serialVersionUID = 271961705838330478L;

	private static ActionsPanel theInstance;

	private ActionsPanel() {
		super.add(new JLabel("ACTIONS PANEL"));
	}

	/**
	 * @return The ActionsPanel instance
	 */
	static ActionsPanel getInstance() {
		if (theInstance == null) {
			theInstance = new ActionsPanel();
		}

		return theInstance;
	}
}
