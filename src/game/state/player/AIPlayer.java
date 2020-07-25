package game.state.player;

import java.awt.Color;

/**
 * @author Aaron Tetens
 */
public class AIPlayer extends Player {

	public AIPlayer(final String name, final Color color) {
		super(name, color);
	}

	@Override
	protected String getDisplayName() {
		return super.name + " (AI)";
	}
}
