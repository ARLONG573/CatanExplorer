package startup.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * This is the frame that holds all of the UI components for the startup menu.
 * 
 * @author Aaron Tetens
 */
public class StartupUIFrame extends JFrame {

	private static final long serialVersionUID = -3139989974895643941L;

	private static StartupUIFrame theInstance;

	private StartupUIFrame() {
		super.setLayout(new BorderLayout());
		super.add(NumPlayersPanel.getInstance(), BorderLayout.NORTH);
		super.add(PlayerEntriesPanel.getInstance(), BorderLayout.CENTER);
		super.add(LaunchButtonPanel.getInstance(), BorderLayout.SOUTH);
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.pack();
	}

	/**
	 * @return The StartupUIFrame instance
	 */
	public static StartupUIFrame getInstance() {
		if (theInstance == null) {
			theInstance = new StartupUIFrame();
		}

		return theInstance;
	}
}
