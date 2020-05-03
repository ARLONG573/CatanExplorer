package startup.board.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;

import startup.board.editable.Editable;
import startup.board.editable.Hex;
import startup.board.editable.Port;
import startup.board.selection.SelectionManager;

/**
 * This is the panel that displays the editable board components.
 * 
 * @author Aaron Tetens
 */
public class BoardEditor extends JPanel {

	private static final long serialVersionUID = -1135127351978142227L;
	private static final int BOARD_SIZE = 900;

	private static BoardEditor theInstance;

	private final Set<Editable> editables;

	private BoardEditor() {
		super.setPreferredSize(new Dimension(BOARD_SIZE, BOARD_SIZE));

		this.editables = new HashSet<>();
		this.addEditables();

		// when the panel is clicked, check to see if the click lies within the bounds
		// of any of the editables

		// if it does, set the editable appropriately and repaint
		super.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent e) {
				final int x = e.getX();
				final int y = e.getY();

				BoardEditor.getInstance().onClick(x, y);
			}
		});
	}

	/**
	 * This method is called whenever the panel is clicked. If the click lies within
	 * the bounds of any of the editables, that editable is updated and the editor
	 * panel is repainted.
	 * 
	 * @param x
	 *            The x-coordinate of the click
	 * @param y
	 *            The y-coordinate of the click
	 */
	private void onClick(final int x, final int y) {
		for (final Editable editable : this.editables) {
			if (editable.containsPoint(x, y)) {
				SelectionManager.getInstance().sendSelection(editable);
				super.repaint();
				break;
			}
		}
	}

	/**
	 * @return The BoardEditor instance
	 */
	public static BoardEditor getInstance() {
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
		this.editables.add(new Hex(5 * Hex.X_DIST, 3 * Hex.RADIUS).addPort(Port.TOP_LEFT));
		this.editables.add(new Hex(7 * Hex.X_DIST, 3 * Hex.RADIUS).addPort(Port.TOP_RIGHT));
		this.editables.add(new Hex(9 * Hex.X_DIST, 3 * Hex.RADIUS));

		// second row
		this.editables.add(new Hex(4 * Hex.X_DIST, 4 * Hex.RADIUS + Hex.Y_DIST).addPort(Port.LEFT));
		this.editables.add(new Hex(6 * Hex.X_DIST, 4 * Hex.RADIUS + Hex.Y_DIST));
		this.editables.add(new Hex(8 * Hex.X_DIST, 4 * Hex.RADIUS + Hex.Y_DIST));
		this.editables.add(new Hex(10 * Hex.X_DIST, 4 * Hex.RADIUS + Hex.Y_DIST).addPort(Port.TOP_RIGHT));

		// third row
		this.editables.add(new Hex(3 * Hex.X_DIST, 5 * Hex.RADIUS + 2 * Hex.Y_DIST));
		this.editables.add(new Hex(5 * Hex.X_DIST, 5 * Hex.RADIUS + 2 * Hex.Y_DIST));
		this.editables.add(new Hex(7 * Hex.X_DIST, 5 * Hex.RADIUS + 2 * Hex.Y_DIST));
		this.editables.add(new Hex(9 * Hex.X_DIST, 5 * Hex.RADIUS + 2 * Hex.Y_DIST));
		this.editables.add(new Hex(11 * Hex.X_DIST, 5 * Hex.RADIUS + 2 * Hex.Y_DIST).addPort(Port.RIGHT));

		// fourth row
		this.editables.add(new Hex(4 * Hex.X_DIST, 6 * Hex.RADIUS + 3 * Hex.Y_DIST).addPort(Port.LEFT));
		this.editables.add(new Hex(6 * Hex.X_DIST, 6 * Hex.RADIUS + 3 * Hex.Y_DIST));
		this.editables.add(new Hex(8 * Hex.X_DIST, 6 * Hex.RADIUS + 3 * Hex.Y_DIST));
		this.editables.add(new Hex(10 * Hex.X_DIST, 6 * Hex.RADIUS + 3 * Hex.Y_DIST).addPort(Port.BOTTOM_RIGHT));

		// fifth row
		this.editables.add(new Hex(5 * Hex.X_DIST, 7 * Hex.RADIUS + 4 * Hex.Y_DIST).addPort(Port.BOTTOM_LEFT));
		this.editables.add(new Hex(7 * Hex.X_DIST, 7 * Hex.RADIUS + 4 * Hex.Y_DIST).addPort(Port.BOTTOM_RIGHT));
		this.editables.add(new Hex(9 * Hex.X_DIST, 7 * Hex.RADIUS + 4 * Hex.Y_DIST));

		// even though the ports are attached to their hexes, we will keep a copy of
		// them in the editables set to easily send them click events
		final Set<Port> ports = new HashSet<>();

		for (final Editable hex : this.editables) {
			final Port port = ((Hex) hex).getPort();

			if (port != null) {
				ports.add(port);
			}
		}

		this.editables.addAll(ports);
	}

	@Override
	protected void paintComponent(final Graphics g) {
		for (final Editable editable : this.editables) {
			editable.draw(g);
		}
	}
}
