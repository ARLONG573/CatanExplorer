package game.ui;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import game.state.player.Player;

/**
 * This panel displays information about the players in the game.
 * 
 * @author Aaron Tetens
 */
class PlayersPanel extends JPanel {

	private static final long serialVersionUID = -1712793245804958908L;

	private static PlayersPanel theInstance;

	private PlayersPanel() {
		super.setPreferredSize(new Dimension(4 * Player.PAINT_WIDTH, Player.PAINT_HEIGHT));
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
