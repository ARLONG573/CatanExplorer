package game.state.board;

import game.state.player.Player;

/**
 * Roads are places on edges in the network and create more legal places for settlements to be built.
 * 
 * @author Aaron Tetens
 */
public class Road {
	
	private final Player player;
	
	public Road(final Player player) {
		this.player = player;
	}

}
