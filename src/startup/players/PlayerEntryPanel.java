package startup.players;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This is the panel that holds all of the components necessary for entering
 * information about a single player.
 * 
 * @author Aaron Tetens
 */
class PlayerEntryPanel extends JPanel {

	private static final long serialVersionUID = 5947952408283942209L;

	PlayerEntryPanel() {
		super.add(new JLabel("PlayerEntryPanel"));
	}
}
