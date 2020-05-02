package startup.board.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;

import startup.board.editable.Editable;
import startup.board.editable.Hex;
import startup.board.editable.Port;

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
	 * the board editor (19 hexes and 9 ports). The padding in each direction is
	 * equal to the width of one hex in that direction.
	 */
	private void addEditables() {
		// first row
		this.editables.add(new Hex(5 * Hex.X_DIST, 3 * Hex.HEX_RADIUS).addPort(Port.TOP_LEFT));
		this.editables.add(new Hex(7 * Hex.X_DIST, 3 * Hex.HEX_RADIUS).addPort(Port.TOP_RIGHT));
		this.editables.add(new Hex(9 * Hex.X_DIST, 3 * Hex.HEX_RADIUS));

		// second row
		this.editables.add(new Hex(4 * Hex.X_DIST, 4 * Hex.HEX_RADIUS + Hex.Y_DIST).addPort(Port.LEFT));
		this.editables.add(new Hex(6 * Hex.X_DIST, 4 * Hex.HEX_RADIUS + Hex.Y_DIST));
		this.editables.add(new Hex(8 * Hex.X_DIST, 4 * Hex.HEX_RADIUS + Hex.Y_DIST));
		this.editables.add(new Hex(10 * Hex.X_DIST, 4 * Hex.HEX_RADIUS + Hex.Y_DIST).addPort(Port.TOP_RIGHT));

		// third row
		this.editables.add(new Hex(3 * Hex.X_DIST, 5 * Hex.HEX_RADIUS + 2 * Hex.Y_DIST));
		this.editables.add(new Hex(5 * Hex.X_DIST, 5 * Hex.HEX_RADIUS + 2 * Hex.Y_DIST));
		this.editables.add(new Hex(7 * Hex.X_DIST, 5 * Hex.HEX_RADIUS + 2 * Hex.Y_DIST));
		this.editables.add(new Hex(9 * Hex.X_DIST, 5 * Hex.HEX_RADIUS + 2 * Hex.Y_DIST));
		this.editables.add(new Hex(11 * Hex.X_DIST, 5 * Hex.HEX_RADIUS + 2 * Hex.Y_DIST).addPort(Port.RIGHT));

		// fourth row
		this.editables.add(new Hex(4 * Hex.X_DIST, 6 * Hex.HEX_RADIUS + 3 * Hex.Y_DIST).addPort(Port.LEFT));
		this.editables.add(new Hex(6 * Hex.X_DIST, 6 * Hex.HEX_RADIUS + 3 * Hex.Y_DIST));
		this.editables.add(new Hex(8 * Hex.X_DIST, 6 * Hex.HEX_RADIUS + 3 * Hex.Y_DIST));
		this.editables.add(new Hex(10 * Hex.X_DIST, 6 * Hex.HEX_RADIUS + 3 * Hex.Y_DIST).addPort(Port.BOTTOM_RIGHT));

		// fifth row
		this.editables.add(new Hex(5 * Hex.X_DIST, 7 * Hex.HEX_RADIUS + 4 * Hex.Y_DIST).addPort(Port.BOTTOM_LEFT));
		this.editables.add(new Hex(7 * Hex.X_DIST, 7 * Hex.HEX_RADIUS + 4 * Hex.Y_DIST).addPort(Port.BOTTOM_RIGHT));
		this.editables.add(new Hex(9 * Hex.X_DIST, 7 * Hex.HEX_RADIUS + 4 * Hex.Y_DIST));
	}

	@Override
	protected void paintComponent(final Graphics g) {
		for (final Editable editable : this.editables) {
			editable.draw(g);
		}
	}
}
