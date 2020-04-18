package startup.players;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * This is the panel that holds the components that are necessary for entering
 * player information during startup.
 * 
 * @author Aaron Tetens
 */
class PlayerEntriesPanel extends JPanel {

	private static final long serialVersionUID = -6940232339738566884L;
	private static final int MIN_PLAYERS = 3;
	private static final int MAX_PLAYERS = 4;
	private static final int DEFAULT_NUM_PLAYERS = 4;
	private static final String NUM_PLAYERS_ERROR = "Number of players must be 3 or 4";

	private final List<PlayerEntryPanel> playerEntryPanels;

	private static PlayerEntriesPanel theInstance;

	private PlayerEntriesPanel() {
		super.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.playerEntryPanels = new ArrayList<>();
		this.setNumPlayers(DEFAULT_NUM_PLAYERS);
	}

	/**
	 * @return The PlayerEntriesPanel instance
	 */
	static PlayerEntriesPanel getInstance() {
		if (theInstance == null) {
			theInstance = new PlayerEntriesPanel();
		}

		return theInstance;
	}

	/**
	 * Sets the number of player entry panels to numPlayers. This method tries its
	 * best to retain saved player information by only adding/removing the necessary
	 * panels.
	 * 
	 * @param numPlayers
	 *            The number of player entry panels to be displayed
	 * @throws IllegalArgumentException
	 *             If numPlayers is not a valid number of players
	 */
	final void setNumPlayers(final int numPlayers) throws IllegalArgumentException {
		if (numPlayers < MIN_PLAYERS || numPlayers > MAX_PLAYERS) {
			throw new IllegalArgumentException(NUM_PLAYERS_ERROR);
		}

		final int currentNumPlayers = this.playerEntryPanels.size();

		if (currentNumPlayers < numPlayers) {
			final int numPlayersToAdd = numPlayers - currentNumPlayers;
			int numPlayersAdded = 0;

			while (numPlayersAdded < numPlayersToAdd) {
				final PlayerEntryPanel panelToAdd = new PlayerEntryPanel();

				super.add(panelToAdd);
				this.playerEntryPanels.add(panelToAdd);

				numPlayersAdded++;
			}
		} else if (currentNumPlayers > numPlayers) {
			final int numPlayersToRemove = currentNumPlayers - numPlayers;
			int numPlayersRemoved = 0;

			while (numPlayersRemoved < numPlayersToRemove) {
				final PlayerEntryPanel panelToRemove = this.playerEntryPanels.get(this.playerEntryPanels.size() - 1);

				super.remove(panelToRemove);
				this.playerEntryPanels.remove(panelToRemove);

				numPlayersRemoved++;
			}
		}

		super.revalidate();
		super.repaint();
	}

	/**
	 * @return An array containing the names of the players, in the order they
	 *         appear on the screen
	 */
	String[] getPlayerNames() {
		final String[] playerNames = new String[this.playerEntryPanels.size()];

		for (int i = 0; i < this.playerEntryPanels.size(); i++) {
			playerNames[i] = this.playerEntryPanels.get(i).getPlayerName();
		}

		return playerNames;
	}

	/**
	 * @return An array containing the colors of the playres, in the order they
	 *         appear on the screen
	 */
	PlayerColor[] getPlayerColors() {
		final PlayerColor[] playerColors = new PlayerColor[this.playerEntryPanels.size()];

		for (int i = 0; i < this.playerEntryPanels.size(); i++) {
			playerColors[i] = this.playerEntryPanels.get(i).getPlayerColor();
		}

		return playerColors;
	}
}
