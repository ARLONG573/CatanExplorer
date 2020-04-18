package startup.board.ui;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This is the panel that displays the editable board components.
 * 
 * @author Aaron Tetens
 */
class BoardEditor extends JPanel {

	private static final long serialVersionUID = -1135127351978142227L;

	private static BoardEditor theInstance;

	private BoardEditor() {
		super.add(new JLabel("Board Editor"));
	}

	/**
	 * @return The BoardEditor instance
	 */
	static BoardEditor getInstance() {
		if (theInstance == null) {
			theInstance = new BoardEditor();
		}

		return theInstance;
	}

}
