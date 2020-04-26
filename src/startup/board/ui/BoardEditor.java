package startup.board.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * This is the panel that displays the editable board components.
 * 
 * @author Aaron Tetens
 */
class BoardEditor extends JPanel {

	private static final long serialVersionUID = -1135127351978142227L;
	private static final int BOARD_SIZE = 1000;

	private static BoardEditor theInstance;

	private BoardEditor() {
		super.setPreferredSize(new Dimension(BOARD_SIZE, BOARD_SIZE));
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

	@Override
	protected void paintComponent(final Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 200, 200);
	}
}
