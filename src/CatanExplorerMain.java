import startup.ui.StartupUIFrame;

/**
 * This is the main class for the CatanExplorer program. Its sole responsibility
 * is to display the startup UI.
 * 
 * @author Aaron Tetens
 */
public class CatanExplorerMain {
	public static void main(String[] args) {
		StartupUIFrame.getInstance().setVisible(true);
	}
}
