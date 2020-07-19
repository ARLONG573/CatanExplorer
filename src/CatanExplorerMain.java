import java.util.Arrays;

import game.state.State;
import game.state.board.Board;
import game.state.deck.Deck;
import game.state.player.Player;
import game.ui.GameFrame;

/**
 * This is the main class for the CatanExplorer program. Its sole responsibility
 * is to display the startup players UI.
 * 
 * @author Aaron Tetens
 */
public class CatanExplorerMain {
	public static void main(String[] args) {
		// commenting these out for development of the GameFrame UI
		// StartupPlayersFrame.getInstance().setVisible(true);
		// StartupPlayersFrame.getInstance().setLocationRelativeTo(null);

		// adding these for development of the GameFrame UI
		GameFrame.getInstance().setVisible(true);
		GameFrame.getInstance().setLocationRelativeTo(null);
		final Player[] samplePlayers = new Player[4];
		Arrays.fill(samplePlayers, new Player("", false));
		GameFrame.getInstance().setGameState(new State(new Board(), samplePlayers, new Deck(), 0));
	}
}
