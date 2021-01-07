package game.state.board;

import game.state.player.Player;

/**
 * Cities are the same as settlements, except they are worth an additional VP
 * and give double the resources of a settlement.
 * 
 * @author Aaron Tetens
 */
public class City extends Settlement {

	public City(final Player player) {
		super(player);
	}

}
