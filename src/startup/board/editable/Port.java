package startup.board.editable;

import java.awt.Color;
import java.awt.Graphics;

import startup.board.data.selectable.PortType;

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

	private final int[] xPoints;
	private final int[] yPoints;
	private final int nPoints;

	private PortType type;

	/**
	 * Creates a port attached to the given hex at the given position on the hex
	 * 
	 * @param hex
	 * @param position
	 */
	Port(final Hex hex, final int position) {
		// use hex and position to compute coordinates
		// ports are drawn as rectangles from the top or top-left (depending on
		// position), moving clockwise
		this.nPoints = 4;
		this.xPoints = new int[nPoints];
		this.yPoints = new int[nPoints];

		if (hex != null) {
			switch (position) {
			case TOP_LEFT:
				break;
			case TOP_RIGHT:
				break;
			case RIGHT:
				break;
			case BOTTOM_RIGHT:
				break;
			case BOTTOM_LEFT:
				break;
			case LEFT:
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

	@Override
	public void draw(final Graphics g) {
		this.setType(PortType.SHEEP_PORT);
		// fill
		g.setColor(this.type.getBackgroundColor());
		g.fillPolygon(this.xPoints, this.yPoints, this.nPoints);

		// outline
		g.setColor(Color.BLACK);
		g.drawPolygon(this.xPoints, this.yPoints, this.nPoints);

	}

	@Override
	public boolean containsPoint(final int clickX, int clickY) {
		// TODO Auto-generated method stub
		return false;
	}

}
