package startup.players.ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import game.state.player.AIPlayer;
import game.state.player.HumanPlayer;
import game.state.player.Player;
import startup.players.data.PlayerColor;
import startup.players.data.PlayerType;

/**
 * This is the panel that holds all of the components necessary for entering
 * information about a single player.
 * 
 * @author Aaron Tetens
 */
class PlayerEntryPanel extends JPanel {

	private static final long serialVersionUID = 5947952408283942209L;
	private static final String NAME_LABEL_TEXT = "Name";
	private static final int DEFAULT_TEXT_FIELD_COLUMNS = 10;
	private static final int PADDING = 5;

	private final JLabel nameLabel;
	private final JTextField nameField;
	private final JComboBox<PlayerColor> colorComboBox;
	private final JComboBox<PlayerType> typeComboBox;

	PlayerEntryPanel() {
		super.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		this.nameLabel = new JLabel(NAME_LABEL_TEXT);
		this.nameField = new JTextField(DEFAULT_TEXT_FIELD_COLUMNS);
		this.colorComboBox = new JComboBox<>(PlayerColor.class.getEnumConstants());
		this.typeComboBox = new JComboBox<>(PlayerType.class.getEnumConstants());

		super.add(this.nameLabel);
		super.add(Box.createRigidArea(new Dimension(PADDING, 0)));
		super.add(this.nameField);
		super.add(Box.createRigidArea(new Dimension(PADDING, 0)));
		super.add(this.colorComboBox);
		super.add(Box.createRigidArea(new Dimension(PADDING, 0)));
		super.add(this.typeComboBox);
	}

	/**
	 * @return The player's name (trimmed). If the name is null, an empty String is
	 *         returned.
	 */
	String getPlayerName() {
		final String text = this.nameField.getText();

		return text == null ? "" : text.trim();
	}

	/**
	 * @return The player's color.
	 */
	PlayerColor getPlayerColor() {
		return (PlayerColor) (this.colorComboBox.getSelectedItem());
	}

	/**
	 * @return A new player object that is initialized with the current state of
	 *         this player editor.
	 */
	Player createPlayer() {
		final String name = this.getPlayerName();
		final Color color = this.getPlayerColor().asColor();

		switch (this.getPlayerType()) {
		case HUMAN:
			return new HumanPlayer(name, color);
		case AI:
			return new AIPlayer(name, color);
		default:
			return null;
		}
	}

	/**
	 * @return The player's type.
	 */
	private PlayerType getPlayerType() {
		return (PlayerType) (this.typeComboBox.getSelectedItem());
	}
}
