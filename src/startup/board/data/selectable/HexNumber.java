package startup.board.data.selectable;

import java.awt.Color;

/**
 * This is an enumeration of all of the numbers that can be selected for some
 * hex on the startup board editor.
 * 
 * @author Aaron Tetens
 */
enum HexNumber implements Selectable {
	TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), EIGHT("8"), NINE("9"), TEN("10"), ELEVEN("11"), TWELVE("12");

	private final String name;

	private HexNumber(final String name) {
		this.name = name;
	}

	@Override
	public Color getBackgroundColor() {
		return Color.WHITE;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
