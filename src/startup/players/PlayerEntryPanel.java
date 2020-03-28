package startup.players;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import data.PlayerColor;

/**
 * This is the panel that holds all of the components necessary for entering
 * information about a single player.
 * 
 * @author Aaron Tetens
 */
class PlayerEntryPanel extends JPanel {

	private static final long serialVersionUID = 5947952408283942209L;
	private static final String NAME_LABEL_TEXT = "Name ";
	private static final int DEFAULT_TEXT_FIELD_COLUMNS = 10;

	private final JLabel nameLabel;
	private final JTextField nameField;
	private final JComboBox<PlayerColor> colorComboBox;

	PlayerEntryPanel() {
		super.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		this.nameLabel = new JLabel(NAME_LABEL_TEXT);
		this.nameField = new JTextField(DEFAULT_TEXT_FIELD_COLUMNS);
		this.colorComboBox = new JComboBox<>(PlayerColor.class.getEnumConstants());

		super.add(this.nameLabel);
		super.add(this.nameField);
		super.add(this.colorComboBox);
	}

	String getPlayerName() {
		return this.nameField.getText();
	}

	PlayerColor getPlayerColor() {
		return (PlayerColor) (this.colorComboBox.getSelectedItem());
	}
}
