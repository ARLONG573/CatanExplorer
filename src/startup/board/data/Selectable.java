package startup.board.data;

import java.awt.Color;

/**
 * This interface describes the behavior of elements that can be selected to add
 * to the startup board editor (hex resources, hex numbers, and port types).
 * 
 * @author Aaron Tetens
 */
interface Selectable {

	/**
	 * @return The background color of the visual representation of this Selectable
	 */
	public Color getBackgroundColor();
}
