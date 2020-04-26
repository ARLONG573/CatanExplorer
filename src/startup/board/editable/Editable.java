package startup.board.editable;

import java.awt.Graphics;

/**
 * This interface describes the behavior of elements that can be edited on the
 * board editor. These elements include hexes and ports.
 * 
 * @author Aaron Tetens
 */
public interface Editable {

	/**
	 * Defines how this drawable board element should draw itself.
	 * 
	 * @param g
	 *            The Graphics object to use
	 */
	public void draw(final Graphics g);

	/**
	 * @param clickX
	 *            The x coordinate of the mouse click
	 * @param clickY
	 *            The y coordinate of the mouse click
	 * @return Whether or not the point (clickX, clickY) lies within the drawing of
	 *         this editable
	 */
	public boolean containsPoint(final int clickX, final int clickY);
}
