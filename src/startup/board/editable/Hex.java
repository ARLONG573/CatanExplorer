package startup.board.editable;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

import startup.board.data.selectable.HexNumber;
import startup.board.data.selectable.HexResource;

/**
 * This class represents a drawable hex on the startup board editor.
 * 
 * @author Aaron Tetens
 */
public class Hex implements Editable {

	// distance from center to any point
	public static final int RADIUS = 75;

	// horizontal distance from center to left/right edge
	public static final int X_DIST = (int) (RADIUS * Math.sqrt(3) / 2);

	// vertical distance from center to any of the four side points
	public static final int Y_DIST = (int) (RADIUS / 2);

	private final int[] xPoints;
	private final int[] yPoints;
	private final int nPoints;

	private final int x;
	private final int y;

	private HexResource resource;
	private HexNumber number;
	private Port port;

	/**
	 * Creates a new Hex centered at (x, y)
	 * 
	 * @param x
	 * @param y
	 */
	public Hex(final int x, final int y) {
		this.x = x;
		this.y = y;

		// the points are drawn from the top, going clockwise
		this.nPoints = 6;
		this.xPoints = new int[nPoints];
		this.yPoints = new int[nPoints];

		this.xPoints[0] = this.x;
		this.xPoints[1] = this.x + X_DIST;
		this.xPoints[2] = this.x + X_DIST;
		this.xPoints[3] = this.x;
		this.xPoints[4] = this.x - X_DIST;
		this.xPoints[5] = this.x - X_DIST;

		this.yPoints[0] = this.y - RADIUS;
		this.yPoints[1] = this.y - Y_DIST;
		this.yPoints[2] = this.y + Y_DIST;
		this.yPoints[3] = this.y + RADIUS;
		this.yPoints[4] = this.y + Y_DIST;
		this.yPoints[5] = this.y - Y_DIST;

		this.resource = HexResource.DESERT;
		this.number = HexNumber.NONE;
		this.port = null;
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

	/**
	 * @param position
	 *            Where on the hex the port is located; should be one of the static
	 *            constants in the Port class.
	 * 
	 * @return This hex instance with the port attached
	 */
	public Hex addPort(final int position) {
		this.port = new Port(this, position);

		return this;
	}

	/**
	 * @return The port that is attached to this hex, or null if there isn't one
	 */
	public Port getPort() {
		return this.port;
	}

	/**
	 * @return The x-coordinate of the center of this hex
	 */
	int getX() {
		return this.x;
	}

	/**
	 * @return The y-coordinate of the center of this hex
	 */
	int getY() {
		return this.y;
	}

	@Override
	public void draw(final Graphics g) {
		// fill
		g.setColor(this.resource.getBackgroundColor());
		g.fillPolygon(this.xPoints, this.yPoints, this.nPoints);

		// outline
		g.setColor(Color.BLACK);
		g.drawPolygon(this.xPoints, this.yPoints, this.nPoints);

		// number
		g.setFont(HexNumber.FONT);

		final FontMetrics metrics = g.getFontMetrics();
		final String text = this.number.toString();
		final int textWidth = metrics.stringWidth(text);
		final int textHeight = metrics.getHeight();

		g.drawString(text, this.x - textWidth / 2, this.y + textHeight / 2);

		// port
		if (this.port != null) {
			this.port.draw(g);
		}
	}

	@Override
	public boolean containsPoint(final int clickX, final int clickY) {
		// TODO
		return true;
	}
}
