package startup.board;

import javax.swing.JLabel;
import javax.swing.JPanel;

class BoardToolbar extends JPanel {

	private static final long serialVersionUID = 8360605363339741336L;

	private static BoardToolbar theInstance;

	private BoardToolbar() {
		super.add(new JLabel("Board Toolbar"));
	}

	static BoardToolbar getInstance() {
		if (theInstance == null) {
			theInstance = new BoardToolbar();
		}

		return theInstance;
	}

}
