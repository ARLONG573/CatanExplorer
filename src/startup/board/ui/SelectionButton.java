package startup.board.ui;

import javax.swing.JButton;

import startup.board.data.selectable.Selectable;

/**
 * This is a button that the users clicks to select the board element that they
 * want to add to the startup board editor.
 * 
 * @author Aaron Tetens
 */
class SelectionButton extends JButton {

	private static final long serialVersionUID = 8049570099616321459L;

	/**
	 * If the given selectable is null, this button displays and does nothing.
	 * 
	 * @param selectable
	 *            The selectable that this button handles
	 */
	SelectionButton(final Selectable selectable) {
		if (selectable != null) {
			super.setBackground(selectable.getBackgroundColor());
			super.setText(selectable.toString());

			super.addActionListener((e) -> System.out.println("Selected " + selectable));
		}
	}
}
