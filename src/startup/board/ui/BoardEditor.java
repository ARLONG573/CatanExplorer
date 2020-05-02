package startup.board.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;

import startup.board.editable.Editable;
import startup.board.editable.Hex;

/**
 * This is the panel that displays the editable board components.
 * 
 * @author Aaron Tetens
 */
class BoardEditor extends JPanel {

	private static final long serialVersionUID = -1135127351978142227L;
	private static final int BOARD_SIZE = 900;

	private static BoardEditor theInstance;

	private final Set<Editable> editables;

	private BoardEditor() {
		super.setPreferredSize(new Dimension(BOARD_SIZE, BOARD_SIZE));

		this.editables = new HashSet<>();
		this.addEditables();
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

	/**
	 * Initializes this class's editable set with all of the editable elements for
	 * the board editor (19 hexes and 9 ports).
	 */
	private void addEditables() {
		this.editables.add(new Hex(300, 300));
	}

	@Override
	protected void paintComponent(final Graphics g) {
		for (final Editable editable : this.editables) {
			editable.draw(g);
		}
	}
}
