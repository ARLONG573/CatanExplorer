package startup.players.ui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import startup.board.ui.StartupBoardFrame;

/**
 * This is the panel that holds the button that the user clicks to leave the
 * startup menu and enter the board editor. The button's action listener is in
 * charge of validating the user data.
 * 
 * @author Aaron Tetens
 */
class ConfirmPlayersButtonPanel extends JPanel {

	private static final long serialVersionUID = 261221856020394181L;
	private static final String CONFIRM_PLAYERS_BUTTON_TEXT = "Confirm Players";

	private final JButton confirmButton;

	private static ConfirmPlayersButtonPanel theInstance;

	private ConfirmPlayersButtonPanel() {
		super(new BorderLayout());

		this.confirmButton = new JButton(CONFIRM_PLAYERS_BUTTON_TEXT);
		this.confirmButton.addActionListener((evt) -> {
			if (PlayerEntriesPanel.getInstance().hasValidEntries()) {
				// instead of creating the player data and disposing of the player frame now, we
				// will accumulate all of the data at once and dispose of both frames after
				// the board is created
				StartupPlayersFrame.getInstance().setVisible(false);
				StartupBoardFrame.getInstance().setVisible(true);
				StartupBoardFrame.getInstance().setLocationRelativeTo(null);

				// For testing purposes
				// StartupPlayersFrame.getInstance().setVisible(false);
				// GameFrame.getInstance().setGameState(new State(new Board(),
				// PlayerEntriesPanel.getInstance().createPlayers(), new Deck(), 0));
				// GameFrame.getInstance().setVisible(true);
				// GameFrame.getInstance().setLocationRelativeTo(null);
			}
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
}
