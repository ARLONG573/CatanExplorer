package game.ui;

import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This is the panel that renders a given board state.
 * 
 * @author Aaron Tetens
 */
class BoardPanel extends JPanel {

	private static final long serialVersionUID = 161733293155598936L;

	private static BoardPanel theInstance;

	private BoardPanel() {
		super.add(new JLabel("BOARD PANEL"));
	}

	/**
	 * @return The BoardPanel instance
	 */
	static BoardPanel getInstance() {
		if (theInstance == null) {
			theInstance = new BoardPanel();
		}

		return theInstance;
	}

	@Override
	protected void paintComponent(final Graphics g) {
		super.paintComponent(g);

		GameFrame.getInstance().getGameState().paintBoard(g);
	}
}
