package utils;

/**
 * This class contains static utility methods for geometry calculations.
 * 
 * @author Aaron Tetens
 */
public class GeometryUtils {

	/**
	 * @param x
	 * @param y
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return Whether or not the point (x, y) is located above the line formed by
	 *         (x1, y1) and (x2, y2) when viewed in a Swing context.
	 */
	public static boolean isPointAboveLine(final int x, final int y, final int x1, final int y1, final int x2,
			final int y2) {

		final double m = (y2 - y1) / (double) (x2 - x1);

		// (x1, y1) is chosen arbitrarily, either point works
		// use less than because Swing origin is in top-left
		return y < y1 + m * (x - x1);
	}
}
