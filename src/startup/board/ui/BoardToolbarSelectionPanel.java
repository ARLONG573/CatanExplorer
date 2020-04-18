package startup.board.ui;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * This is where the user can select which board component they would like to
 * add to the editable board.
 * 
 * @author Aaron Tetens
 */
class BoardToolbarSelectionPanel extends JPanel {

	private static final long serialVersionUID = 7345269466179575642L;
	private static final int PADDING = 5;

	private static BoardToolbarSelectionPanel theInstance;

	private BoardToolbarSelectionPanel() {
		super.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		super.add(ResourceSelectionPanel.getInstance());
		super.add(Box.createRigidArea(new Dimension(PADDING, 0)));
		super.add(NumberSelectionPanel.getInstance());
		super.add(Box.createRigidArea(new Dimension(PADDING, 0)));
		super.add(PortSelectionPanel.getInstance());
	}

	/**
	 * @return The BoardToolbarSelectionPanel instance
	 */
	static BoardToolbarSelectionPanel getInstance() {
		if (theInstance == null) {
			theInstance = new BoardToolbarSelectionPanel();
		}

		return theInstance;
	}
}
