import startup.players.StartupPlayersFrame;

/**
 * This is the main class for the CatanExplorer program. Its sole responsibility
 * is to display the startup players UI.
 * 
 * @author Aaron Tetens
 */
public class CatanExplorerMain {
	public static void main(String[] args) {
		StartupPlayersFrame.getInstance().setVisible(true);
	}
}
