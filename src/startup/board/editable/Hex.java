package startup.board.editable;

import java.awt.Graphics;

import startup.board.data.selectable.HexNumber;
import startup.board.data.selectable.HexResource;

/**
 * This class represents a drawable hex on the startup board editor.
 * 
 * @author Aaron Tetens
 */
public class Hex implements Editable {

	public static final int HEX_WIDTH = 150;

	private final int x;
	private final int y;

	private HexResource resource;
	private HexNumber number;

	/**
	 * Creates a new Hex centered at (x, y)
	 * 
	 * @param x
	 * @param y
	 */
	public Hex(final int x, final int y) {
		this.x = x;
		this.y = y;

		this.resource = HexResource.DESERT;
		this.number = HexNumber.NONE;
	}

	/**
	 * Sets this hex's resource to the given new resource. If the given new resource
	 * is null, this method does nothing.
	 * 
	 * @param resource
	 *            The new resource for this hex
	 */
	public void setResource(final HexResource resource) {
		if (resource != null) {
			this.resource = resource;
		}
	}

	/**
	 * Sets this hex's number to the given new number. If the given new number is
	 * null, this method does nothing.
	 * 
	 * @param number
	 *            The new number for this hex
	 */
	public void setNumber(final HexNumber number) {
		if (number != null) {
			this.number = number;
		}
	}

	@Override
	public void draw(final Graphics g) {
		// TODO
	}

	@Override
	public boolean containsPoint(final int clickX, final int clickY) {
		// TODO
		return false;
	}
}
