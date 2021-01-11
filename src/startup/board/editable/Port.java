package startup.board.editable;

import java.awt.Color;
import java.awt.Graphics;

import startup.board.data.selectable.PortType;
import utils.GeometryUtils;

/**
 * This class represents a drawable port on the startup board editor.
 * 
 * @author Aaron Tetens
 */
public class Port implements Editable {

	// choices for which side of the hex the port is attached to
	public static final int TOP_LEFT = 1;
	public static final int TOP_RIGHT = 2;
	public static final int RIGHT = 3;
	public static final int BOTTOM_RIGHT = 4;
	public static final int BOTTOM_LEFT = 5;
	public static final int LEFT = 6;

	// port thickness
	public static final int WIDTH = Hex.RADIUS / 2;

	// horizontal distance from hex point to port point (angled cases only)
	private static final int X_DIST = (int) (WIDTH * Math.sqrt(3) / 3);

	// vertical distance from hex point to port point (angled cases only)
	private static final int Y_DIST = WIDTH / 2;

	private final int[] xPoints;
	private final int[] yPoints;
	private final int nPoints;

	private final int position;

	private PortType type;

	/**
	 * Creates a port attached to the given hex at the given position on the hex
	 * 
	 * @param hex
	 * @param position
	 */
	Port(final Hex hex, final int position) {
		this.position = position;

		// use hex and position to compute coordinates
		// ports are drawn as rectangles from the top (for angled cases) or top-left
		// (for orthogonal cases), moving clockwise
		this.nPoints = 4;
		this.xPoints = new int[nPoints];
		this.yPoints = new int[nPoints];

		if (hex != null) {
			final int hexX = hex.getX();
			final int hexY = hex.getY();

			switch (this.position) {
			case TOP_LEFT:
				this.xPoints[0] = hexX - X_DIST;
				this.xPoints[1] = hexX;
				this.xPoints[2] = hexX - Hex.X_DIST;
				this.xPoints[3] = hexX - Hex.X_DIST - X_DIST;

				this.yPoints[0] = hexY - Hex.RADIUS - Y_DIST;
				this.yPoints[1] = hexY - Hex.RADIUS;
				this.yPoints[2] = hexY - Hex.Y_DIST;
				this.yPoints[3] = hexY - Hex.Y_DIST - Y_DIST;

				break;
			case TOP_RIGHT:
				this.xPoints[0] = hexX + X_DIST;
				this.xPoints[1] = hexX + Hex.X_DIST + X_DIST;
				this.xPoints[2] = hexX + Hex.X_DIST;
				this.xPoints[3] = hexX;

				this.yPoints[0] = hexY - Hex.RADIUS - Y_DIST;
				this.yPoints[1] = hexY - Hex.Y_DIST - Y_DIST;
				this.yPoints[2] = hexY - Hex.Y_DIST;
				this.yPoints[3] = hexY - Hex.RADIUS;

				break;
			case RIGHT:
				this.xPoints[0] = hexX + Hex.X_DIST;
				this.xPoints[1] = hexX + Hex.X_DIST + WIDTH;
				this.xPoints[2] = hexX + Hex.X_DIST + WIDTH;
				this.xPoints[3] = hexX + Hex.X_DIST;

				this.yPoints[0] = hexY - Hex.Y_DIST;
				this.yPoints[1] = hexY - Hex.Y_DIST;
				this.yPoints[2] = hexY + Hex.Y_DIST;
				this.yPoints[3] = hexY + Hex.Y_DIST;

				break;
			case BOTTOM_RIGHT:
				this.xPoints[0] = hexX + Hex.X_DIST;
				this.xPoints[1] = hexX + Hex.X_DIST + X_DIST;
				this.xPoints[2] = hexX + X_DIST;
				this.xPoints[3] = hexX;

				this.yPoints[0] = hexY + Hex.Y_DIST;
				this.yPoints[1] = hexY + Hex.Y_DIST + Y_DIST;
				this.yPoints[2] = hexY + Hex.RADIUS + Y_DIST;
				this.yPoints[3] = hexY + Hex.RADIUS;

				break;
			case BOTTOM_LEFT:
				this.xPoints[0] = hexX - Hex.X_DIST;
				this.xPoints[1] = hexX;
				this.xPoints[2] = hexX - X_DIST;
				this.xPoints[3] = hexX - Hex.X_DIST - X_DIST;

				this.yPoints[0] = hexY + Hex.Y_DIST;
				this.yPoints[1] = hexY + Hex.RADIUS;
				this.yPoints[2] = hexY + Hex.RADIUS + Y_DIST;
				this.yPoints[3] = hexY + Hex.Y_DIST + Y_DIST;

				break;
			case LEFT:
				this.xPoints[0] = hexX - Hex.X_DIST - WIDTH;
				this.xPoints[1] = hexX - Hex.X_DIST;
				this.xPoints[2] = hexX - Hex.X_DIST;
				this.xPoints[3] = hexX - Hex.X_DIST - WIDTH;

				this.yPoints[0] = hexY - Hex.Y_DIST;
				this.yPoints[1] = hexY - Hex.Y_DIST;
				this.yPoints[2] = hexY + Hex.Y_DIST;
				this.yPoints[3] = hexY + Hex.Y_DIST;

				break;
			}
		}

		this.type = PortType.THREE_TO_ONE_PORT;
	}

	/**
	 * Sets this port's type to the given new type. If the given new type is null,
	 * this method does nothing.
	 * 
	 * @param type
	 *            The new type for this port
	 */
	public void setType(final PortType type) {
		if (type != null) {
			this.type = type;
		}
	}

	/**
	 * @return The current type of this port in the board editor.
	 */
	public PortType getType() {
		return this.type;
	}

	/**
	 * @return The position number of the port relative to its hex
	 */
	public int getPosition() {
		return this.position;
	}

	@Override
	public void draw(final Graphics g) {
		// fill
		g.setColor(this.type.getBackgroundColor());
		g.fillPolygon(this.xPoints, this.yPoints, this.nPoints);

		// outline
		g.setColor(Color.BLACK);
		g.drawPolygon(this.xPoints, this.yPoints, this.nPoints);
	}

	@Override
	public boolean containsPoint(final int clickX, int clickY) {
		// check equations based on port orientatoin
		switch (this.position) {
		case TOP_LEFT:
		case TOP_RIGHT:
		case BOTTOM_RIGHT:
		case BOTTOM_LEFT:
			// top right line
			if (GeometryUtils.isPointAboveLine(clickX, clickY, this.xPoints[0], this.yPoints[0], this.xPoints[1],
					this.yPoints[1])) {

				return false;
			}
			// bottom right line
			if (!GeometryUtils.isPointAboveLine(clickX, clickY, this.xPoints[1], this.yPoints[1], this.xPoints[2],
					this.yPoints[2])) {

				return false;
			}
			// bottom left line
			if (!GeometryUtils.isPointAboveLine(clickX, clickY, this.xPoints[2], this.yPoints[2], this.xPoints[3],
					this.yPoints[3])) {

				return false;
			}

			// top left line
			if (GeometryUtils.isPointAboveLine(clickX, clickY, this.xPoints[3], this.yPoints[3], this.xPoints[0],
					this.yPoints[0])) {

				return false;
			}

			break;
		case LEFT:
		case RIGHT:
			// x-coordinate check
			if (clickX < this.xPoints[0] || clickX > this.xPoints[1]) {
				return false;
			}

			// y-coordinate check, remember that Swing y-axis is inverted
			if (clickY < this.yPoints[0] || clickY > this.yPoints[2]) {
				return false;
			}

			break;
		}

		return true;
	}
}
