package startup.board.ui;

import javax.swing.JButton;

import startup.board.data.selectable.Selectable;

/**
 * This is a button that the users clicks to select the board element that they
 * want to add to the startup board editor.
 * 
 * @author Aaron Tetens
 */
class SelectableButton extends JButton {

	private static final long serialVersionUID = 8049570099616321459L;

	private final Selectable selectable;

	SelectableButton(final Selectable selectable) {
		this.selectable = selectable;

		super.setBackground(this.selectable.getBackgroundColor());
		super.setText(this.selectable.toString());

		super.addActionListener((e) -> System.out.println("Selected " + this.selectable));
	}
}
