package game.state.board;

import java.awt.Graphics;

import startup.board.data.selectable.HexNumber;
import startup.board.data.selectable.HexResource;
import startup.board.editable.Port;

/**
 * This class represents a hex on the Catan board. Each hex has exactly 6
 * vertices from the stored network.
 * 
 * @author Aaron Tetens
 */
public class Hex {

	private final HexNumber number;
	private final HexResource resource;

	// saving the port here makes drawing it easier, the actual game logic for ports
	// is in the Vertex class
	private final Port port;

	// these need to be ordered for drawing purposes
	// start at the top and go clockwise
	private final Vertex[] vertices;

	// used for drawing the hex, defined by the vertices
	private final int[] xPoints;
	private final int[] yPoints;

	public Hex(final startup.board.editable.Hex hex, final Vertex v1, Vertex v2, Vertex v3, Vertex v4, Vertex v5,
			Vertex v6) {
		this.number = hex.getNumber();
		this.resource = hex.getResource();
		this.port = hex.getPort();

		this.vertices = new Vertex[6];
		this.vertices[0] = v1;
		this.vertices[1] = v2;
		this.vertices[2] = v3;
		this.vertices[3] = v4;
		this.vertices[4] = v5;
		this.vertices[5] = v6;

		this.xPoints = new int[6];
		this.yPoints = new int[6];
		for (int i = 0; i < 6; i++) {
			this.xPoints[i] = this.vertices[i].getX();
			this.yPoints[i] = this.vertices[i].getY();
		}
	}

	/**
	 * Paints this hex on the given graphics context
	 * 
	 * @param g
	 */
	void paint(final Graphics g) {
		g.setColor(this.resource.getBackgroundColor());
		g.fillPolygon(this.xPoints, this.yPoints, 6);
	}
}
