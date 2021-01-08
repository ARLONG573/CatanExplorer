package game.state.board;

import java.util.HashSet;
import java.util.Set;

import startup.board.data.selectable.HexNumber;
import startup.board.data.selectable.HexResource;
import startup.board.data.selectable.PortType;

/**
 * This class represents a hex on the Catan board. Each hex has exactly 6
 * vertices from the stored network.
 * 
 * @author Aaron Tetens
 */
public class Hex {

	private final HexNumber number;
	private final HexResource resource;
	private final PortType port;

	private final Set<Vertex> vertices;

	public Hex(final startup.board.editable.Hex hex, final Vertex v1, Vertex v2, Vertex v3, Vertex v4, Vertex v5, Vertex v6) {
		this.number = hex.getNumber();
		this.resource = hex.getResource();
		this.port = hex.getPort() == null ? null : hex.getPort().getType();

		this.vertices = new HashSet<>();
		this.vertices.add(v1);
		this.vertices.add(v2);
		this.vertices.add(v3);
		this.vertices.add(v4);
		this.vertices.add(v5);
		this.vertices.add(v6);
	}
}
