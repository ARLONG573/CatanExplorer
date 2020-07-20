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

	private static GameFrame theInstance;

	private State state;

	private GameFrame() {
		super.setResizable(false);
		super.setLayout(new BorderLayout());
		super.add(BoardPanel.getInstance(), BorderLayout.CENTER);
		super.add(ActionsPanel.getInstance(), BorderLayout.EAST);
		super.add(PlayersPanel.getInstance(), BorderLayout.NORTH);
		super.add(DeckPanel.getInstance(), BorderLayout.SOUTH);
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
	 * Updates the state that this frame is displaying.
	 * 
	 * @param state
	 *            The new state to display
	 */
	public void setGameState(final State state) {
		this.state = state;

		super.repaint();
	}

	/**
	 * This method is package private because it is only meant for UI subcomponents
	 * to see (these subcomponents are painted by
	 * {@link State#paintBoard(java.awt.Graphics)},
	 * {@link State#paintPlayer(java.awt.Graphics, int)}, and
	 * {@link State#paintDeck(java.awt.Graphics)}).
	 * 
	 * @return The game state that this frame is displaying
	 */
	State getGameState() {
		return this.state;
	}
}
