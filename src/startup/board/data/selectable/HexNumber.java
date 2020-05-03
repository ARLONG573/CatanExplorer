package startup.board.data.selectable;

import java.awt.Color;
import java.awt.Font;

/**
 * This is an enumeration of all of the numbers that can be selected for some
 * hex on the startup board editor.
 * 
 * @author Aaron Tetens
 */
public enum HexNumber implements Selectable {
	TWO(2, "2"), THREE(3, "3"), FOUR(4, "4"), FIVE(5, "5"), SIX(6, "6"), EIGHT(8, "8"), NINE(9, "9"), TEN(10,
			"10"), ELEVEN(11, "11"), TWELVE(12, "12"), NONE(-1, "");

	public static final Font FONT = new Font("Arial", Font.BOLD, 24);

	private final int number;
	private final String name;

	private HexNumber(final int number, final String name) {
		this.number = number;
		this.name = name;
	}

	/**
	 * @return This HexNumber as an integer
	 */
	public int asInt() {
		return this.number;
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
