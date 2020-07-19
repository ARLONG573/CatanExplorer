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
	}
}
