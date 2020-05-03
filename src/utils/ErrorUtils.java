package utils;

import javax.swing.JOptionPane;

/**
 * This class contains static utility methods for displaying errors.
 * 
 * @author Aaron Tetens
 */
public class ErrorUtils {

	private static final String ERROR_TITLE = "Error";

	/**
	 * 
	 * Convenience method for displaying a default option pane in the center of the
	 * screen
	 * 
	 * @param message
	 *            The message to be displayed
	 */
	public static void displayErrorMessage(final String message) {
		JOptionPane.showConfirmDialog(null, message, ERROR_TITLE, JOptionPane.DEFAULT_OPTION);
	}
}
