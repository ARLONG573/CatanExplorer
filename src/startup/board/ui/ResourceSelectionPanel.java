package startup.board.ui;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This is the panel where the user can select which resource to add to some
 * hexes on the startup board editor.
 * 
 * @author Aaron Tetens
 */
class ResourceSelectionPanel extends JPanel {

	private static final long serialVersionUID = -7027202989443098463L;

	private static ResourceSelectionPanel theInstance;

	private ResourceSelectionPanel() {
		super.add(new JLabel("ResourceSelectionPanel"));
	}

	/**
	 * @return The ResourceSelectionPanel instance
	 */
	static ResourceSelectionPanel getInstance() {
		if (theInstance == null) {
			theInstance = new ResourceSelectionPanel();
		}

		return theInstance;
	}
}
