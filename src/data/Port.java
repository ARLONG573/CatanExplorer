package data;

/**
 * This is an enumeration of the different types of ports.
 * 
 * @author Aaron Tetens
 */
public enum Port {

	WOOD_PORT("Wood Port"), BRICK_PORT("Brick Port"), SHEEP_PORT("Sheep Port"), WHEAT_PORT("Wheat Port"), ORE_PORT(
			"Ore Port"), THREE_TO_ONE_PORT("3 to 1 Port");

	private final String name;

	private Port(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
