package game.ui;

import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This panel displays information about the players in the game.
 * 
 * @author Aaron Tetens
 */
class PlayersPanel extends JPanel {

	private static final long serialVersionUID = -1712793245804958908L;

	private static PlayersPanel theInstance;

	private PlayersPanel() {
		super.add(new JLabel("PLAYERS PANEL"));
	}

	/**
	 * @return The PlayersPanel instance
	 */
	static PlayersPanel getInstance() {
		if (theInstance == null) {
			theInstance = new PlayersPanel();
		}

		return theInstance;
	}

	@Override
	protected void paintComponent(final Graphics g) {
		super.paintComponent(g);

		GameFrame.getInstance().getGameState().paintPlayers(g);
	}
}
