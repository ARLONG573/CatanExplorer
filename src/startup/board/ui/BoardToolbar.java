package startup.board.ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;

/**
 * This is where the user selects the board components that they would like to
 * add to the board, as well as confirms that the board is finished.
 * 
 * @author Aaron Tetens
 */
class BoardToolbar extends JPanel {

	private static final long serialVersionUID = 8360605363339741336L;

	private static BoardToolbar theInstance;

	private BoardToolbar() {
		super(new BorderLayout());
		super.add(BoardToolbarSelectionPanel.getInstance(), BorderLayout.CENTER);
		super.add(ConfirmBoardButtonPanel.getInstance(), BorderLayout.SOUTH);
	}

	/**
	 * @return The BoardToolbar instance
	 */
	static BoardToolbar getInstance() {
		if (theInstance == null) {
			theInstance = new BoardToolbar();
		}

		return theInstance;
	}

}
