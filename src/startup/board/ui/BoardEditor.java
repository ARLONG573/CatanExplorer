package startup.board.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import game.state.board.Board;
import startup.board.data.selectable.HexNumber;
import startup.board.data.selectable.HexResource;
import startup.board.data.selectable.PortType;
import startup.board.data.structures.FrequencyMap;
import startup.board.editable.Editable;
import startup.board.editable.Hex;
import startup.board.editable.Port;
import startup.board.selection.SelectionManager;
import utils.ErrorUtils;

/**
 * This is the panel that displays the editable board components.
 * 
 * @author Aaron Tetens
 */
class BoardEditor extends JPanel {

	private static final long serialVersionUID = -1135127351978142227L;
	private static final int BOARD_SIZE = 900;
	private static final String RESOURCE_CONFIGURATION_ERROR = "Invalid resource distribution";
	private static final String NUMBER_CONFIGURATION_ERROR = "Invalid number distribution";
	private static final String PORT_CONFIGURATION_ERROR = "Invalid port distribution";
	private static final String INVALID_DESERT_ERROR = "The desert cannot have a number on it";

	private static BoardEditor theInstance;

	private final List<Editable> editables;

	private BoardEditor() {
		super.setPreferredSize(new Dimension(BOARD_SIZE, BOARD_SIZE));

		this.editables = new ArrayList<>();
		this.addEditables();

		super.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(final MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)) {
					final int x = e.getX();
					final int y = e.getY();

					BoardEditor.getInstance().onMousePress(x, y);
				}
			}
		});
	}

	/**
	 * This method is called whenever the mouse is pressed on the panel. If the
	 * press lies within the bounds of any of the editables, that editable is
	 * updated and the editor panel is repainted.
	 * 
	 * @param x
	 *            The x-coordinate of the mouse press
	 * @param y
	 *            The y-coordinate of the mouse press
	 */
	private void onMousePress(final int x, final int y) {
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
		// them in the editables list to easily send them click events
		final Set<Port> ports = new HashSet<>();

		for (final Editable hex : this.editables) {
			final Port port = ((Hex) hex).getPort();

			if (port != null) {
				ports.add(port);
			}
		}

		this.editables.addAll(ports);
	}

	/**
	 * The board editor's configuration is valid if it meets all of the following
	 * criteria:
	 * 
	 * Numbers - One 2, one 12, and two of every other possible hex number. Hexes -
	 * Three ore, three brick, four sheep, four wood, four wheat, and one desert.
	 * Ports - Five 3:1, and one of each of the 2:1.
	 * 
	 * It must also be the case that the desert does not have a number.
	 * 
	 * @return Whether or not the current configuration of the board editor can be
	 *         used to set up a game.
	 */
	boolean hasValidConfiguration() {
		final FrequencyMap<HexResource> resourceFreqs = new FrequencyMap<>();
		final FrequencyMap<HexNumber> numberFreqs = new FrequencyMap<>();
		final FrequencyMap<PortType> portFreqs = new FrequencyMap<>();

		for (final Editable editable : this.editables) {
			if (editable instanceof Hex) {
				final Hex hex = (Hex) editable;

				resourceFreqs.add(hex.getResource());
				numberFreqs.add(hex.getNumber());
			} else if (editable instanceof Port) {
				final Port port = (Port) editable;

				portFreqs.add(port.getType());
			}
		}

		// verify resource distribution
		// check that all resources are present
		if (resourceFreqs.size() != HexResource.NUM_RESOURCES) {
			ErrorUtils.displayErrorMessage(RESOURCE_CONFIGURATION_ERROR);
			return false;
		}
		// check that all resources have correct amount
		if (!resourceFreqs.isValid()) {
			ErrorUtils.displayErrorMessage(RESOURCE_CONFIGURATION_ERROR);
			return false;
		}

		// verify number distribution
		// check that all numbers are present
		if (numberFreqs.size() != HexNumber.NUM_NUMBERS) {
			ErrorUtils.displayErrorMessage(NUMBER_CONFIGURATION_ERROR);
			return false;
		}

		// check that all numbers have correct amount
		if (!numberFreqs.isValid()) {
			ErrorUtils.displayErrorMessage(NUMBER_CONFIGURATION_ERROR);
			return false;
		}

		// verify port distribution
		// check that all ports are present
		if (portFreqs.size() != PortType.NUM_PORTS) {
			ErrorUtils.displayErrorMessage(PORT_CONFIGURATION_ERROR);
			return false;
		}

		// check that all ports have correct amount
		if (!portFreqs.isValid()) {
			ErrorUtils.displayErrorMessage(PORT_CONFIGURATION_ERROR);
			return false;
		}

		// find the desert and verify that it does not have a number on it
		for (final Hex hex : this.getHexes()) {
			if (hex.getResource() == HexResource.DESERT) {
				if (hex.getNumber() != HexNumber.NONE) {
					ErrorUtils.displayErrorMessage(INVALID_DESERT_ERROR);
					return false;
				}

				break;
			}
		}

		return true;
	}

	/**
	 * This method does not call {@link hasValidConfiguration()}, since this method
	 * is called only when the Confirm Board button is pressed, which checks the
	 * configuration before calling this method.
	 * 
	 * @return A Board object based on the current state of the board.
	 * 
	 */
	Board createBoard() {
		return new Board(this.getHexes());
	}

	@Override
	protected void paintComponent(final Graphics g) {
		super.paintComponent(g);

		// only draw hexes, since each hex is responsible for drawing the port attached
		// to it (if it has one)
		for (final Hex hex : this.getHexes()) {
			hex.draw(g);
		}
	}

	private List<Hex> getHexes() {
		final List<Hex> hexes = new ArrayList<>();

		for (final Editable editable : this.editables) {
			if (editable instanceof Hex) {
				hexes.add((Hex) editable);
			}
		}

		return hexes;
	}
}
