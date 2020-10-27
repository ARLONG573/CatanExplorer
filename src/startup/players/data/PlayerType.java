package startup.players.data;

/**
 * This is an enumeration of the possible types of players.
 * 
 * @author Aaron Tetens
 */
public enum PlayerType {

	HUMAN("Human"), AI("AI");

	private String name;

	private PlayerType(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}