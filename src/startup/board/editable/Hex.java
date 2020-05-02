package startup.board.editable;

import java.awt.Color;
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
	public static final int HEX_RADIUS = 75;

	// horizontal distance from center to left/right edge
	public static final int X_DIST = (int) (HEX_RADIUS * Math.sqrt(3) / 2);

	// vertical distance from center to any of the four side points
	public static final int Y_DIST = (int) (HEX_RADIUS / 2);

	private final int[] xPoints;
	private final int[] yPoints;
	private final int nPoints;

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

		this.yPoints[0] = this.y - HEX_RADIUS;
		this.yPoints[1] = this.y - Y_DIST;
		this.yPoints[2] = this.y + Y_DIST;
		this.yPoints[3] = this.y + HEX_RADIUS;
		this.yPoints[4] = this.y + Y_DIST;
		this.yPoints[5] = this.y - Y_DIST;

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
		// fill
		g.setColor(this.resource.getBackgroundColor());
		g.fillPolygon(this.xPoints, this.yPoints, this.nPoints);

		// outline
		g.setColor(Color.BLACK);
		g.drawPolygon(this.xPoints, this.yPoints, this.nPoints);
	}

	@Override
	public boolean containsPoint(final int clickX, final int clickY) {
		// TODO
		return false;
	}
}
