package game.ui;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import game.state.board.Board;
import game.state.player.Player;

/**
 * This panel contains the buttons that allows the user to input game actions as
 * they occur (rolling the dice, trading, building, and playing development
 * cards).
 * 
 * @author Aaron Tetens
 */
class ActionsPanel extends JPanel {

	private static final long serialVersionUID = 271961705838330478L;
	private static final String ROLL_DICE_BUTTON_TEXT = "Roll dice";
	private static final String TRADE_BUTTON_TEXT = "Trade";
	private static final String BUILD_BUTTON_TEXT = "Build";
	private static final String PLAY_DEV_CARD_BUTTON_TEXT = "Play dev card";
	private static final int PADDING = 10;

	private static ActionsPanel theInstance;

	private final JButton rollDiceButton;
	private final JButton tradeButton;
	private final JButton buildButton;
	private final JButton playDevCardButton;
	private final JTextArea gameLogArea;

	private ActionsPanel() {
		this.rollDiceButton = new JButton(ROLL_DICE_BUTTON_TEXT);
		this.rollDiceButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		this.tradeButton = new JButton(TRADE_BUTTON_TEXT);
		this.tradeButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		this.buildButton = new JButton(BUILD_BUTTON_TEXT);
		this.buildButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		this.playDevCardButton = new JButton(PLAY_DEV_CARD_BUTTON_TEXT);
		this.playDevCardButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		this.gameLogArea = new JTextArea();
		this.gameLogArea.setEditable(false);

		super.setPreferredSize(new Dimension(4 * Player.PAINT_WIDTH - Board.PAINT_SIZE, 0));
		super.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		super.add(Box.createRigidArea(new Dimension(0, PADDING)));
		super.add(this.rollDiceButton);
		super.add(Box.createRigidArea(new Dimension(0, PADDING)));
		super.add(this.tradeButton);
		super.add(Box.createRigidArea(new Dimension(0, PADDING)));
		super.add(this.buildButton);
		super.add(Box.createRigidArea(new Dimension(0, PADDING)));
		super.add(this.playDevCardButton);
		super.add(Box.createRigidArea(new Dimension(0, PADDING)));
		super.add(this.gameLogArea);
	}

	/**
	 * @return The ActionsPanel instance
	 */
	static ActionsPanel getInstance() {
		if (theInstance == null) {
			theInstance = new ActionsPanel();
		}

		return theInstance;
	}
}
