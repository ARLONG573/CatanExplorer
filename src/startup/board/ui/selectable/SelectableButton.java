package startup.board.ui.selectable;

import javax.swing.JButton;

import startup.board.data.selectable.Selectable;

/**
 * This is the superclass that defines the general behavior for the selectable
 * buttons in the startup board editor. This class's subclasses are responsible
 * for their visual representations.
 * 
 * @author Aaron Tetens
 */
public class SelectableButton extends JButton {

	private static final long serialVersionUID = 8049570099616321459L;

	private final Selectable selectable;

	public SelectableButton(final Selectable selectable) {
		this.selectable = selectable;

		super.addActionListener((e) -> System.out.println("Selected " + this.selectable));
	}
}
