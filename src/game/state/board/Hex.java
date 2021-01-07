package game.state.board;

import java.util.HashSet;
import java.util.Set;

/**
 * This class represents a hex on the Catan board. Each hex has exactly 6
 * vertices from the stored network.
 * 
 * @author Aaron Tetens
 */
public class Hex {

	private final Set<Vertex> vertices;

	public Hex(final Vertex... vertices) {
		this.vertices = new HashSet<>();

		for (final Vertex vertex : vertices) {
			this.vertices.add(vertex);
		}
	}
}
