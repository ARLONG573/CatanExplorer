import startup.players.ui.StartupPlayersFrame;

/**
 * This is the main class for the CatanExplorer program. Its sole responsibility
 * is to display the startup players UI.
 * 
 * @author Aaron Tetens
 */
public class CatanExplorerMain {
	public static void main(String[] args) {
		// comment these lines for development of the GameFrame UI
		StartupPlayersFrame.getInstance().setVisible(true);
		StartupPlayersFrame.getInstance().setLocationRelativeTo(null);
	}
}
