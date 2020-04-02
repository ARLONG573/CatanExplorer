package startup.players;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utils.ErrorUtils;

/**
 * This is the panel that holds the components that are necessary for choosing
 * the number of players during startup.
 * 
 * @author Aaron Tetens
 */
class NumPlayersPanel extends JPanel {

	private static final long serialVersionUID = -1602013603239879104L;
	private static final String NUM_PLAYERS_LABEL_TEXT = "Number of Players";
	private static final String THREE_PLAYERS_BUTTON_TEXT = "3";
	private static final String FOUR_PLAYERS_BUTTON_TEXT = "4";
	private static final int PADDING = 5;

	private final JLabel numPlayersLabel;
	private final JButton threePlayersButton;
	private final JButton fourPlayersButton;

	private static NumPlayersPanel theInstance;

	private NumPlayersPanel() {
		super.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		this.numPlayersLabel = new JLabel(NUM_PLAYERS_LABEL_TEXT);
		this.threePlayersButton = new JButton(THREE_PLAYERS_BUTTON_TEXT);
		this.fourPlayersButton = new JButton(FOUR_PLAYERS_BUTTON_TEXT);

		this.threePlayersButton.addActionListener((e) -> this.setNumPlayers(3));
		this.fourPlayersButton.addActionListener((e) -> this.setNumPlayers(4));

		super.add(this.numPlayersLabel);
		super.add(Box.createRigidArea(new Dimension(PADDING, 0)));
		super.add(this.threePlayersButton);
		super.add(Box.createRigidArea(new Dimension(PADDING, 0)));
		super.add(this.fourPlayersButton);
	}

	/**
	 * @return The NumPlayersPanel instance
	 */
	static NumPlayersPanel getInstance() {
		if (theInstance == null) {
			theInstance = new NumPlayersPanel();
		}

		return theInstance;
	}

	/**
	 * This method tells the PlayerEntriesPanel how many player entires it should
	 * display.
	 * 
	 * @param numPlayers
	 *            The number of player entries to be displayed
	 */
	private void setNumPlayers(final int numPlayers) {
		try {
			PlayerEntriesPanel.getInstance().setNumPlayers(numPlayers);
		} catch (final IllegalArgumentException e) {
			ErrorUtils.displayErrorMessage(e.getMessage());
		}
	}
}
