import java.awt.Color;

/**
 * This is an enumeration of the possible player colors.
 * 
 * @author Aaron Tetens
 */
public enum PlayerColor {

	RED("Red", Color.RED), WHITE("White", Color.WHITE), BLUE("Blue", Color.BLUE), ORANGE("Orange", Color.ORANGE);

	private final String name;
	private final Color color;

	private PlayerColor(final String name, final Color color) {
		this.name = name;
		this.color = color;
	}

	@Override
	public String toString() {
		return this.name;
	}

	public Color asColor() {
		return this.color;
	}
}
