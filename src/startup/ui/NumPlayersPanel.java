package startup.ui;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This is the panel that holds the components that are necessary for choosing
 * the number of players during startup.
 * 
 * @author Aaron Tetens
 */
class NumPlayersPanel extends JPanel {

	private static final long serialVersionUID = -1602013603239879104L;

	private static NumPlayersPanel theInstance;

	private NumPlayersPanel() {
		// TODO
		super.add(new JLabel("NumPlayersPanel"));
	}

	/**
	 * @return The NumPlayersPanel instance
	 */
	static NumPlayersPanel getInstance() {
		if (theInstance == null) {
			theInstance = new NumPlayersPanel();
		}

		return theInstance;
	}
}
