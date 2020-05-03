package startup.board.selection;

import startup.board.data.selectable.HexNumber;
import startup.board.data.selectable.HexResource;
import startup.board.data.selectable.PortType;
import startup.board.data.selectable.Selectable;
import startup.board.editable.Editable;
import startup.board.editable.Hex;
import startup.board.editable.Port;

/**
 * The selection manager receives selection events from the SelectionButton and
 * BoardEditor classes and sends selection events to the Editable classes.
 * 
 * @author Aaron Tetens
 */
public class SelectionManager {

	private static SelectionManager theInstance;

	private Selectable selection;

	private SelectionManager() {
		this.selection = null;
	}

	/**
	 * @param selection
	 *            The new selection to store
	 */
	public void setSelection(final Selectable selection) {
		this.selection = selection;
	}

	/**
	 * Sends the current selection to the given editable. If the given editable is
	 * null or the current selection is null, this method does nothing.
	 * 
	 * @param editable
	 */
	public void sendSelection(final Editable editable) {
		if (editable instanceof Hex) {
			if (this.selection instanceof HexResource) {
				((Hex) editable).setResource((HexResource) this.selection);
			} else if (this.selection instanceof HexNumber) {
				((Hex) editable).setNumber((HexNumber) this.selection);
			}
		} else if (editable instanceof Port) {
			if (this.selection instanceof PortType) {
				((Port) editable).setType((PortType) this.selection);
			}
		}
	}

	/**
	 * @return The SelectionManager instance
	 */
	public static SelectionManager getInstance() {
		if (theInstance == null) {
			theInstance = new SelectionManager();
		}

		return theInstance;
	}
}
