package game.state.board;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import startup.board.data.selectable.HexNumber;
import startup.board.data.selectable.HexResource;
import startup.board.data.selectable.PortType;
import startup.board.editable.Port;

/**
 * This class represents a hex on the Catan board. Each hex has exactly 6
 * vertices from the stored network.
 * 
 * @author Aaron Tetens
 */
public class Hex {

	private static final Font NUMBER_FONT = new Font("Arial", Font.BOLD, 18);

	// variables to help with drawing the port
	private static final int PORT_WIDTH = (int) (20 + 8 * Math.sqrt(3) / 3);
	private static final int PORT_X_DIST = (int) (PORT_WIDTH * Math.sqrt(3) / 3);
	private static final int PORT_Y_DIST = PORT_WIDTH / 2;

	private final HexNumber number;
	private final HexResource resource;

	// saving the port here makes drawing it easier, the actual game logic for ports
	// is in the Vertex class
	private final Port port;

	// these need to be ordered for drawing purposes
	// start at the top and go clockwise
	private final Vertex[] vertices;

	// used for drawing the hex, defined by the vertices
	private final int[] xPointsHex;
	private final int[] yPointsHex;

	// used for drawing the hex number, can be inferred from the vertices
	private final int x;
	private final int y;

	// used for drawing the port, defined by (x, y) and the port position
	private final int[] xPointsPort;
	private final int[] yPointsPort;

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

		this.xPointsHex = new int[6];
		this.yPointsHex = new int[6];
		for (int i = 0; i < 6; i++) {
			this.xPointsHex[i] = this.vertices[i].getX();
			this.yPointsHex[i] = this.vertices[i].getY();
		}

		// figure out this hex's (x, y)
		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxY = Integer.MIN_VALUE;

		for (final Vertex vertex : this.vertices) {
			final int vertexX = vertex.getX();
			final int vertexY = vertex.getY();

			minX = Math.min(minX, vertexX);
			maxX = Math.max(maxX, vertexX);
			minY = Math.min(minY, vertexY);
			maxY = Math.max(maxY, vertexY);
		}

		this.x = (minX + maxX) / 2;
		this.y = (minY + maxY) / 2;

		// assign port properties to the correct vertices
		// while we're here, also assign port-drawing coordinates
		if (this.port != null) {
			final PortType portType = this.port.getType();
			this.xPointsPort = new int[4];
			this.yPointsPort = new int[4];

			switch (this.port.getPosition()) {
			case Port.TOP_LEFT:
				this.vertices[5].setPortType(portType);
				this.vertices[0].setPortType(portType);

				this.xPointsPort[0] = this.vertices[0].getX() - PORT_X_DIST;
				this.xPointsPort[1] = this.vertices[0].getX();
				this.xPointsPort[2] = this.vertices[5].getX();
				this.xPointsPort[3] = this.vertices[5].getX() - PORT_X_DIST;

				this.yPointsPort[0] = this.vertices[0].getY() - PORT_Y_DIST;
				this.yPointsPort[1] = this.vertices[0].getY();
				this.yPointsPort[2] = this.vertices[5].getY();
				this.yPointsPort[3] = this.vertices[5].getY() - PORT_Y_DIST;

				break;
			case Port.TOP_RIGHT:
				this.vertices[0].setPortType(portType);
				this.vertices[1].setPortType(portType);

				this.xPointsPort[0] = this.vertices[0].getX() + PORT_X_DIST;
				this.xPointsPort[1] = this.vertices[1].getX() + PORT_X_DIST;
				this.xPointsPort[2] = this.vertices[1].getX();
				this.xPointsPort[3] = this.vertices[0].getX();

				this.yPointsPort[0] = this.vertices[0].getY() - PORT_Y_DIST;
				this.yPointsPort[1] = this.vertices[1].getY() - PORT_Y_DIST;
				this.yPointsPort[2] = this.vertices[1].getY();
				this.yPointsPort[3] = this.vertices[0].getY();

				break;
			case Port.RIGHT:
				this.vertices[1].setPortType(portType);
				this.vertices[2].setPortType(portType);

				this.xPointsPort[0] = this.vertices[1].getX();
				this.xPointsPort[1] = this.vertices[1].getX() + PORT_WIDTH;
				this.xPointsPort[2] = this.vertices[2].getX() + PORT_WIDTH;
				this.xPointsPort[3] = this.vertices[2].getX();

				this.yPointsPort[0] = this.vertices[1].getY();
				this.yPointsPort[1] = this.vertices[1].getY();
				this.yPointsPort[2] = this.vertices[2].getY();
				this.yPointsPort[3] = this.vertices[2].getY();

				break;
			case Port.BOTTOM_RIGHT:
				this.vertices[2].setPortType(portType);
				this.vertices[3].setPortType(portType);

				this.xPointsPort[0] = this.vertices[2].getX();
				this.xPointsPort[1] = this.vertices[2].getX() + PORT_X_DIST;
				this.xPointsPort[2] = this.vertices[3].getX() + PORT_X_DIST;
				this.xPointsPort[3] = this.vertices[3].getX();

				this.yPointsPort[0] = this.vertices[2].getY();
				this.yPointsPort[1] = this.vertices[2].getY() + PORT_Y_DIST;
				this.yPointsPort[2] = this.vertices[3].getY() + PORT_Y_DIST;
				this.yPointsPort[3] = this.vertices[3].getY();

				break;
			case Port.BOTTOM_LEFT:
				this.vertices[3].setPortType(portType);
				this.vertices[4].setPortType(portType);

				this.xPointsPort[0] = this.vertices[4].getX();
				this.xPointsPort[1] = this.vertices[3].getX();
				this.xPointsPort[2] = this.vertices[3].getX() - PORT_X_DIST;
				this.xPointsPort[3] = this.vertices[4].getX() - PORT_X_DIST;

				this.yPointsPort[0] = this.vertices[4].getY();
				this.yPointsPort[1] = this.vertices[3].getY();
				this.yPointsPort[2] = this.vertices[3].getY() + PORT_Y_DIST;
				this.yPointsPort[3] = this.vertices[4].getY() + PORT_Y_DIST;

				break;
			case Port.LEFT:
				this.vertices[4].setPortType(portType);
				this.vertices[5].setPortType(portType);

				this.xPointsPort[0] = this.vertices[5].getX() - PORT_WIDTH;
				this.xPointsPort[1] = this.vertices[5].getX();
				this.xPointsPort[2] = this.vertices[4].getX();
				this.xPointsPort[3] = this.vertices[4].getX() - PORT_WIDTH;

				this.yPointsPort[0] = this.vertices[5].getY();
				this.yPointsPort[1] = this.vertices[5].getY();
				this.yPointsPort[2] = this.vertices[4].getY();
				this.yPointsPort[3] = this.vertices[4].getY();

				break;
			}
		} else {
			this.xPointsPort = null;
			this.yPointsPort = null;
		}
	}

	/**
	 * Paints this hex on the given graphics context
	 * 
	 * @param g
	 */
	void paint(final Graphics g) {
		// paint the resource color
		g.setColor(this.resource.getBackgroundColor());
		g.fillPolygon(this.xPointsHex, this.yPointsHex, 6);

		// paint the number
		g.setColor(Color.BLACK);
		g.setFont(NUMBER_FONT);

		final FontMetrics metrics = g.getFontMetrics();
		final String text = this.number.toString();
		final int textWidth = metrics.stringWidth(text);
		final int textHeight = metrics.getHeight();

		g.drawString(text, this.x - textWidth / 2, this.y + textHeight / 2);

		// paint the port
		if (this.port != null) {
			g.setColor(this.port.getType().getBackgroundColor());
			g.fillPolygon(this.xPointsPort, this.yPointsPort, 4);

			g.setColor(Color.BLACK);
			g.drawPolygon(this.xPointsPort, this.yPointsPort, 4);
		}
	}
}
