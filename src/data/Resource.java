package data;

import java.awt.Color;

/**
 * This is an enumeration of the different types of hexes in the game.
 * 
 * @author Aaron Tetens
 */
public enum Resource {

	WOOD("Wood", new Color(0, 128, 0)), BRICK("Brick", new Color(128, 0, 0)), SHEEP("Sheep",
			new Color(0, 255, 0)), WHEAT("Wheat", new Color(255, 255, 0)), ORE("Ore",
					new Color(128, 128, 128)), DESERT("Desert", new Color(100, 65, 0));

	private final String name;
	private final Color color;

	private Resource(final String name, final Color color) {
		this.name = name;
		this.color = color;
	}

	@Override
	public String toString() {
		return this.name;
	}

	/**
	 * @return The color of this resource when it is drawn
	 */
	public Color getColor() {
		return this.color;
	}
}
