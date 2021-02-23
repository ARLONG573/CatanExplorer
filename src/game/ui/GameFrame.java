package game.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import game.state.State;

/**
 * This is the frame that holds all of the UI components that are necessary for
 * displaying a game state (board, players, and deck).
 * 
 * @author Aaron Tetens
 */
public class GameFrame extends JFrame {

	private static final long serialVersionUID = 163328790265462187L;
	private static final String GAME_START_MESSAGE = "Starting the game.";
	private static final String GAME_OVER_MESSAGE = "Game is over. Thanks for playing!";

	private static GameFrame theInstance;

	private State state;

	private GameFrame() {
		super.setResizable(false);
		super.setLayout(new BorderLayout());
		super.add(BoardPanel.getInstance(), BorderLayout.CENTER);
		super.add(ActionsPanel.getInstance(), BorderLayout.EAST);
		super.add(PlayersPanel.getInstance(), BorderLayout.NORTH);
		// super.add(DeckPanel.getInstance(), BorderLayout.SOUTH);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.pack();
	}

	/**
	 * @return The GameFrame instance
	 */
	public static GameFrame getInstance() {
		if (theInstance == null) {
			theInstance = new GameFrame();
		}

		return theInstance;
	}

	/**
	 * Sets the initial state that the frame displays. This method does nothing if
	 * the frame is already displaying some state.
	 * 
	 * @param state
	 *            The new state to display
	 */
	public void initGameState(final State state) {
		if (this.state == null) {
			this.state = state;

			// update UI
			super.repaint();
		}
	}

	/**
	 * Sets whether or not the game is over in the current game state.
	 * 
	 * @param isGameOver
	 */
	public void setGameOver(final boolean isGameOver) {
		this.state.setGameOver(isGameOver);
	}

	/**
	 * This method is package private because it is only meant for UI subcomponents
	 * to see (these subcomponents are painted by
	 * {@link State#paintBoard(java.awt.Graphics)},
	 * {@link State#paintPlayers(java.awt.Graphics, int)}, and
	 * {@link State#paintDeck(java.awt.Graphics)}).
	 * 
	 * @return The game state that this frame is displaying
	 */
	State getGameState() {
		return this.state;
	}
}
