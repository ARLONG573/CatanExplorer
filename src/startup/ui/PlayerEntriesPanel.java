package startup.ui;

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
	 *             If numPlayers is not in the range [3, 4]
	 */
	final void setNumPlayers(final int numPlayers) throws IllegalArgumentException {
		if (numPlayers < 3 || numPlayers > 4) {
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
}
