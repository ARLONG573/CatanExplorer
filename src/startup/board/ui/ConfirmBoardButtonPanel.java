package startup.board.ui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import game.state.State;
import game.state.board.Board;
import game.state.player.Player;
import game.ui.GameFrame;
import startup.players.ui.PlayerEntriesPanel;
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
				final Board board = new Board();
				final Player[] players = PlayerEntriesPanel.getInstance().createPlayers();
				final State initialState = new State(board, players, 0);

				GameFrame.getInstance().setGameState(initialState);
				GameFrame.getInstance().setVisible(true);
				GameFrame.getInstance().setLocationRelativeTo(null);

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
