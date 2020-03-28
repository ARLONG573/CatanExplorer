package startup.players;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * This is the panel that holds the button that the user clicks to leave the
 * startup menu and enter the board editor. The button's action listener is in
 * charge of validating the user data.
 * 
 * @author Aaron Tetens
 */
public class LaunchButtonPanel extends JPanel {

	private static final long serialVersionUID = 261221856020394181L;
	private static final String LAUNCH_BUTTON_TEXT = "Launch";

	private final JButton launchButton;

	private static LaunchButtonPanel theInstance;

	private LaunchButtonPanel() {
		super(new BorderLayout());

		this.launchButton = new JButton(LAUNCH_BUTTON_TEXT);
		this.launchButton.addActionListener((e) -> {
			// TODO
		});

		super.add(this.launchButton, BorderLayout.EAST);
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
