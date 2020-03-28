package startup.ui;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This is the panel that holds the button that the user clicks to leave the
 * startup menu and enter the board editor.
 * 
 * @author Aaron Tetens
 */
public class LaunchButtonPanel extends JPanel {

	private static final long serialVersionUID = 261221856020394181L;

	private static LaunchButtonPanel theInstance;

	private LaunchButtonPanel() {
		// TODO
		super.add(new JLabel("LaunchButtonPanel"));
	}

	/**
	 * @return The LaunchButtonPanel instance
	 */
	static LaunchButtonPanel getInstance() {
		if (theInstance == null) {
			theInstance = new LaunchButtonPanel();
		}

		return theInstance;
	}
}
