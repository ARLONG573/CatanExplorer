package startup.board;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This is the panel where the user can choose which number to add to some hexes
 * on the startup board editor.
 * 
 * @author Aaron Tetens
 */
class NumberSelectionPanel extends JPanel {

	private static final long serialVersionUID = -8960094058684180723L;

	private static NumberSelectionPanel theInstance;

	private NumberSelectionPanel() {
		super.add(new JLabel("NumberSelectionPanel"));
	}

	/**
	 * @return The NumberSelectionPanel instance
	 */
	static NumberSelectionPanel getInstance() {
		if (theInstance == null) {
			theInstance = new NumberSelectionPanel();
		}

		return theInstance;
	}
}
