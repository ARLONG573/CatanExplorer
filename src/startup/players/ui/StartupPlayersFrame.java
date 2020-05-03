package startup.players.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * This is the frame that holds all of the UI components for the startup players menu.
 * 
 * @author Aaron Tetens
 */
public class StartupPlayersFrame extends JFrame {

	private static final long serialVersionUID = -3139989974895643941L;

	private static StartupPlayersFrame theInstance;

	private StartupPlayersFrame() {
		super.setLayout(new BorderLayout());
		super.add(NumPlayersPanel.getInstance(), BorderLayout.NORTH);
		super.add(PlayerEntriesPanel.getInstance(), BorderLayout.CENTER);
		super.add(ConfirmPlayersButtonPanel.getInstance(), BorderLayout.SOUTH);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.pack();
	}

	/**
	 * @return The StartupPlayersFrame instance
	 */
	public static StartupPlayersFrame getInstance() {
		if (theInstance == null) {
			theInstance = new StartupPlayersFrame();
		}

		return theInstance;
	}
}
