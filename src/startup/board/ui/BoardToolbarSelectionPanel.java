package startup.board.ui;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import startup.board.data.selectable.HexNumber;
import startup.board.data.selectable.HexResource;
import startup.board.data.selectable.PortType;

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
		super.add(new SelectionPanel(HexResource.class));
		super.add(Box.createRigidArea(new Dimension(PADDING, 0)));
		super.add(new SelectionPanel(HexNumber.class));
		super.add(Box.createRigidArea(new Dimension(PADDING, 0)));
		super.add(new SelectionPanel(PortType.class));
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
