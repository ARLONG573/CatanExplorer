package startup.board.ui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import game.ui.GameFrame;
import startup.players.ui.StartupPlayersFrame;

/**
 * This panel holds the confirm button for the board editor. The confirm
 * button's action listener is responsible for validating the board state.
 * 
 * @author Aaron Tetens
 */
class ConfirmBoardButtonPanel extends JPanel {

	private static final long serialVersionUID = 3350286239540011079L;
	private static final String CONFIRM_BOARD_BUTTON_TEXT = "Confirm Board";

	private final JButton confirmBoardButton;

	private static ConfirmBoardButtonPanel theInstance;

	private ConfirmBoardButtonPanel() {
		super(new BorderLayout());

		this.confirmBoardButton = new JButton(CONFIRM_BOARD_BUTTON_TEXT);
		this.confirmBoardButton.addActionListener((e) -> {
			if (BoardEditor.getInstance().hasValidConfiguration()) {
				GameFrame.getInstance().setVisible(true);
				GameFrame.getInstance().setLocationRelativeTo(null);
				// TODO store initial game state from the two startup screens

				// we no longer need the data stored in these frames, so dispose them
				StartupPlayersFrame.getInstance().dispose();
				StartupBoardFrame.getInstance().dispose();
			}
		});

		super.add(this.confirmBoardButton, BorderLayout.EAST);
	}

	/**
	 * @return The ConfirmBoardButtonPanel instance
	 */
	static ConfirmBoardButtonPanel getInstance() {
		if (theInstance == null) {
			theInstance = new ConfirmBoardButtonPanel();
		}

		return theInstance;
	}

}
