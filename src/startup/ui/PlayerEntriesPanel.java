package startup.ui;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This is the panel that holds the components that are necessary for entering
 * player information during startup.
 * 
 * @author Aaron Tetens
 */
class PlayerEntriesPanel extends JPanel {

	private static final long serialVersionUID = -6940232339738566884L;

	private static PlayerEntriesPanel theInstance;

	private PlayerEntriesPanel() {
		// TODO
		super.add(new JLabel("PlayerEntriesPanel"));
	}

	/**
	 * @return The PlayerEntriesPanel instance
	 */
	static PlayerEntriesPanel getInstance() {
		if (theInstance == null) {
			theInstance = new PlayerEntriesPanel();
		}

		return theInstance;
	}
}
