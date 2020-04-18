package startup.board.ui;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This is the panel where the user can choose which ports to add to the startup
 * board editor.
 * 
 * @author Aaron Tetens
 */
class PortSelectionPanel extends JPanel {

	private static final long serialVersionUID = 4229946890942404234L;

	private static PortSelectionPanel theInstance;

	private PortSelectionPanel() {
		super.add(new JLabel("PortSelectionPanel"));
	}

	/**
	 * @return The PortSelectionPanel instance
	 */
	static PortSelectionPanel getInstance() {
		if (theInstance == null) {
			theInstance = new PortSelectionPanel();
		}

		return theInstance;
	}
}
