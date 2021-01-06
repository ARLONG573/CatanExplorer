package game.state.board;

/**
 * This class represents a hex on the Catan board. Each hex has exactly 6 vertices from the stored network.
 * 
 * @author Aaron Tetens
 */
public class Hex {

	private final Vertex[] vertices;
	
	public Hex(final Vertex... vertices) {
		this.vertices = vertices;
	}
}
