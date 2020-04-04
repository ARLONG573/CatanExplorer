package startup.board;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This is where the user can select which board component they would like to
 * add to the editable board.
 * 
 * @author Aaron Tetens
 */
class BoardToolbarSelectionPanel extends JPanel {

	private static final long serialVersionUID = 7345269466179575642L;

	private static BoardToolbarSelectionPanel theInstance;

	private BoardToolbarSelectionPanel() {
		super.add(new JLabel("Board Toolbar Selection Panel"));
	}

	/**
	 * @return The BoardToolbarSelectionPanel instance
	 */
	static BoardToolbarSelectionPanel getInstance() {
		if (theInstance == null) {
			theInstance = new BoardToolbarSelectionPanel();
		}

		return theInstance;
	}
}
