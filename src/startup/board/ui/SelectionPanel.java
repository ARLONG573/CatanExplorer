package startup.board.ui;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import startup.board.data.selectable.Selectable;

/**
 * Given a Selectable enum, this class generates a SelectionButton for each enum
 * constant and adds it to a panel.
 * 
 * @author Aaron Tetens
 */
class SelectionPanel extends JPanel {

	private static final long serialVersionUID = 5999121376729676317L;
	private static final int PADDING = 5;

	public SelectionPanel(final Class<? extends Selectable> clazz) {
		super.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		for(final Selectable selectable : clazz.getEnumConstants()) {
			final SelectionButton selectionButton = new SelectionButton(selectable);
			selectionButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			super.add(selectionButton);
			super.add(Box.createRigidArea(new Dimension(0, PADDING)));
		}
	}
}
