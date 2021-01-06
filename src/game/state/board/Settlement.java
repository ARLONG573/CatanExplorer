package game.state.board;

import game.state.player.Player;

/**
 * Settlements are placed on vertices in the network and distribute resources to their owners when their adjaces hexes roll.
 * 
 * @author Aaron Tetens
 */
public class Settlement {
	
	private final Player player;
	
	public Settlement(final Player player) {
		this.player = player;
	}

}
