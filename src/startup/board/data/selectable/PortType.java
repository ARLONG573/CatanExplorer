package startup.board.data.selectable;

import java.awt.Color;

/**
 * This is an enumeration of the port types that can be selected for the startup
 * board editor.
 * 
 * @author Aaron Tetens
 */
public enum PortType implements Selectable {
	WOOD_PORT("Wood Port", HexResource.WOOD.getBackgroundColor(), 1), BRICK_PORT("Brick Port",
			HexResource.BRICK.getBackgroundColor(), 1), SHEEP_PORT("Sheep Port", HexResource.SHEEP.getBackgroundColor(),
					1), WHEAT_PORT("Wheat Port", HexResource.WHEAT.getBackgroundColor(), 1), ORE_PORT("Ore Port",
							HexResource.ORE.getBackgroundColor(), 1), THREE_TO_ONE_PORT("3:1 Port", Color.WHITE, 4);

	public static final int NUM_PORTS = 6;

	private final String name;
	private final Color color;
	private final int expectedAmount;

	private PortType(final String name, final Color color, final int expectedAmount) {
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
