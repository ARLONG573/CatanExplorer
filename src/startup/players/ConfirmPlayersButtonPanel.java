package startup.players;

import java.awt.BorderLayout;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import data.PlayerColor;

/**
 * This is the panel that holds the button that the user clicks to leave the
 * startup menu and enter the board editor. The button's action listener is in
 * charge of validating the user data.
 * 
 * @author Aaron Tetens
 */
public class ConfirmPlayersButtonPanel extends JPanel {

	private static final long serialVersionUID = 261221856020394181L;
	private static final String CONFIRM_PLAYERS_BUTTON_TEXT = "Confirm Players";
	private static final String ERROR_TITLE = "Error";
	private static final String EMPTY_NAME_ERROR = "All players must have names";
	private static final String DUPLICATE_NAME_ERROR = "No two players can have the same name";
	private static final String DUPLICATE_COLOR_ERROR = "No two players can have the same color";

	private final JButton confirmButton;

	private static ConfirmPlayersButtonPanel theInstance;

	private ConfirmPlayersButtonPanel() {
		super(new BorderLayout());

		this.confirmButton = new JButton(CONFIRM_PLAYERS_BUTTON_TEXT);
		this.confirmButton.addActionListener((e) -> {
			// only launch the board editor if the player entries are valid
			final String[] playerNames = PlayerEntriesPanel.getInstance().getPlayerNames();
			final PlayerColor[] playerColors = PlayerEntriesPanel.getInstance().getPlayerColors();

			// check for empty names
			for (final String playerName : playerNames) {
				if (playerName == null || playerName.isEmpty()) {
					this.displayErrorDialog(EMPTY_NAME_ERROR);
					return;
				}
			}

			// check for duplicate name
			if (this.containsDuplicate(playerNames)) {
				this.displayErrorDialog(DUPLICATE_NAME_ERROR);
				return;
			}

			// check for duplicate color
			if (this.containsDuplicate(playerColors)) {
				this.displayErrorDialog(DUPLICATE_COLOR_ERROR);
				return;
			}

			// all checks passed, continue to the board editor
			System.out.println("success");
		});

		super.add(this.confirmButton, BorderLayout.EAST);
	}

	/**
	 * @return The ConfirmPlayersButtonPanel instance
	 */
	static ConfirmPlayersButtonPanel getInstance() {
		if (theInstance == null) {
			theInstance = new ConfirmPlayersButtonPanel();
		}

		return theInstance;
	}

	/**
	 * Convenience method for displaying a default option pane in the center of the
	 * screen
	 * 
	 * @param errorMessage
	 *            The error message to display
	 */
	private void displayErrorDialog(final String errorMessage) {
		JOptionPane.showConfirmDialog(null, errorMessage, ERROR_TITLE, JOptionPane.DEFAULT_OPTION);
	}

	/**
	 * A duplicate is defined as two objects A and B such that Objects.equals(A, B)
	 * returns true.
	 * 
	 * @param arr
	 *            The array to check
	 * @return Whether or not the array contains a duplicate
	 */
	private boolean containsDuplicate(final Object[] arr) {
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
