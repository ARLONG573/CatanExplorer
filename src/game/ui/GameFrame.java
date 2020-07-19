package game.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * This is the frame that holds all of the UI components that are necessary for
 * displaying a game state (board, players, and deck).
 * 
 * @author Aaron Tetens
 */
public class GameFrame extends JFrame {

	private static final long serialVersionUID = 163328790265462187L;

	private static GameFrame theInstance;

	private GameFrame() {
		super.setLayout(new BorderLayout());
		// TODO add components
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
}
