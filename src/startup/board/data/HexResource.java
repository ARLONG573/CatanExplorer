package startup.board.data;

import java.awt.Color;

enum HexResource implements Selectable {
	WOOD("Wood", new Color(0, 128, 0)), BRICK("Brick", new Color(128, 0, 0)), SHEEP("Sheep",
			new Color(0, 255, 0)), WHEAT("Wheat", new Color(255, 255, 0)), ORE("Ore",
					new Color(128, 128, 128)), DESERT("Desert", new Color(100, 65, 0));

	private final String name;
	private final Color color;

	private HexResource(final String name, final Color color) {
		this.name = name;
		this.color = color;
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
