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
	TWO(2, "2", 1), THREE(3, "3", 2), FOUR(4, "4", 2), FIVE(5, "5", 2), SIX(6, "6", 2), EIGHT(8, "8", 2), NINE(9, "9",
			2), TEN(10, "10", 2), ELEVEN(11, "11", 2), TWELVE(12, "12", 1), NONE(-1, "", 1);

	public static final Font FONT = new Font("Arial", Font.BOLD, 24);
	public static final int NUM_NUMBERS = 11;

	private final int number;
	private final String name;
	private final int expectedAmount;

	private HexNumber(final int number, final String name, final int expectedAmount) {
		this.number = number;
		this.name = name;
		this.expectedAmount = expectedAmount;
	}

	/**
	 * @return This HexNumber as an integer
	 */
	public int asInt() {
		return this.number;
	}

	@Override
	public int getExpectedAmount() {
		return this.expectedAmount;
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
