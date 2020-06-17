package utils;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * This class contains static utility methods for general array operations
 * 
 * @author Aaron Tetens
 */
public class ArrayUtils {

	/**
	 * A duplicate is defined as two objects A and B such that Objects.equals(A, B)
	 * returns true.
	 * 
	 * @param arr
	 *            The array to check
	 * @return Whether or not the array contains a duplicate
	 */
	public static boolean containsDuplicate(final Object[] arr) {
		if (arr == null) {
			return false;
		}

		final Set<Object> cache = new HashSet<>();

		for (final Object obj : arr) {
			if (cache.contains(obj)) {
				return true;
			}

			cache.add(obj);
		}

		return false;
	}
}
