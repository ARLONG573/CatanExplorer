package startup.board.data.selectable;

import java.awt.Color;

/**
 * This is an enumeration of all of the possible resources that can be selected
 * for some hex on the startup board editor.
 * 
 * @author Aaron Tetens
 */
public enum HexResource implements Selectable {
	WOOD("Wood", new Color(0, 128, 0), 4), BRICK("Brick", new Color(128, 0, 0), 3), SHEEP("Sheep", new Color(0, 255, 0),
			4), WHEAT("Wheat", new Color(255, 255, 0),
					4), ORE("Ore", new Color(128, 128, 128), 3), DESERT("Desert", new Color(100, 65, 0), 1);

	public static final int NUM_RESOURCES = 6;

	private final String name;
	private final Color color;
	private final int expectedAmount;

	private HexResource(final String name, final Color color, final int expectedAmount) {
		this.name = name;
		this.color = color;
		this.expectedAmount = expectedAmount;
	}

	@Override
	public int getExpectedAmount() {
		return this.expectedAmount;
	}

	@Override
	public Color getBackgroundColor() {
		return this.color;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
