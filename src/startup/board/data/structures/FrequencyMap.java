package startup.board.data.structures;

import java.util.HashMap;

import startup.board.data.selectable.Selectable;

/**
 * This class handles verifying the frequencies of each of the selectable
 * elements in the board editor.
 * 
 * @author Aaron Tetens
 */
public class FrequencyMap<T extends Selectable> extends HashMap<T, Integer> {

	private static final long serialVersionUID = 2532312170720965654L;

	/**
	 * Increments the value that the given key maps to. If the given key is not
	 * mapped to a value, it is mapped to 1.
	 * 
	 * @param key
	 *            The key to increment
	 */
	public void add(final T key) {
		super.putIfAbsent(key, 0);
		super.put(key, super.get(key) + 1);
	}

	/**
	 * The frequencies are considered valid if each of the frequencies is equal to
	 * their expected amounts.
	 * 
	 * @return Whether or not the current stored frequencies are valid
	 */
	public boolean isValid() {
		for (final T key : super.keySet()) {
			if (super.get(key) != key.getExpectedAmount()) {
				return false;
			}
		}

		return true;
	}
}
