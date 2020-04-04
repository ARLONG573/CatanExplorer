package startup.board;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This panel holds the confirm button for the board editor. The confirm
 * button's action listener is responsible for validating the board state.
 * 
 * @author Aaron Tetens
 */
class ConfirmBoardButtonPanel extends JPanel {

	private static final long serialVersionUID = 3350286239540011079L;

	private static ConfirmBoardButtonPanel theInstance;

	private ConfirmBoardButtonPanel() {
		super.add(new JLabel("Confirm Board Button Panel"));
	}

	/**
	 * @return The ConfirmBoardButtonPanel instance
	 */
	static ConfirmBoardButtonPanel getInstance() {
		if (theInstance == null) {
			theInstance = new ConfirmBoardButtonPanel();
		}

		return theInstance;
	}

}
