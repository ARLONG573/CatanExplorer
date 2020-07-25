package game.state.player;

import java.awt.Color;

/**
 * @author Aaron Tetens
 */
public class HumanPlayer extends Player {

	public HumanPlayer(final String name, final Color color) {
		super(name, color);
	}

	@Override
	protected String getDisplayName() {
		return super.name;
	}
}
