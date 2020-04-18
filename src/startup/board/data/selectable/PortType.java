package startup.board.data.selectable;

import java.awt.Color;

/**
 * This is an enumeration of the port types that can be selected for the startup
 * board editor.
 * 
 * @author Aaron Tetens
 */
public enum PortType implements Selectable {
	WOOD_PORT("Wood Port", HexResource.WOOD.getBackgroundColor()), BRICK_PORT("Brick Port",
			HexResource.BRICK.getBackgroundColor()), SHEEP_PORT("Sheep Port",
					HexResource.SHEEP.getBackgroundColor()), WHEAT_PORT("Wheat Port",
							HexResource.WHEAT.getBackgroundColor()), ORE_PORT("Ore Port",
									HexResource.ORE.getBackgroundColor()), THREE_TO_ONE_PORT("3:1 Port", Color.WHITE);

	private final String name;
	private final Color color;

	private PortType(final String name, final Color color) {
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
