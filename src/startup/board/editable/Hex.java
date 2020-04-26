package startup.board.editable;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class represents a drawable hex on the startup board editor.
 * 
 * @author Aaron Tetens
 */
public class Hex implements Editable {

	public static final int HEX_WIDTH = 150;

	private final int x;
	private final int y;

	private Color color;
	private int number;

	/**
	 * Creates a new Hex centered at (x, y)
	 * 
	 * @param x
	 * @param y
	 */
	public Hex(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Sets this hex's color to the given new color. If the given new color is the
	 * same as the current color, the color is set to white (represents a clear
	 * operation).
	 * 
	 * @param color
	 *            The new color for this hex
	 */
	public void setColor(final Color color) {
		if (color == this.color) {
			this.color = Color.WHITE;
		} else {
			this.color = color;
		}
	}

	/**
	 * Sets this hex's number to the given new number. If the given new number is
	 * the same as the current number, the number is set to -1 (represents a clear
	 * operation).
	 * 
	 * @param number
	 *            The new number for this hex
	 */
	public void setNumber(final int number) {
		if (number == this.number) {
			this.number = -1;
		} else {
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
