package game.state.moves;

import game.state.State;

/**
 * A move is defined as some operation on a game state. Each move should
 * override toString() so that {@link Turn#toString()} can be used for
 * debugging.
 * 
 * @author Aaron Tetens
 */
public interface Move {

	/**
	 * Performs this move on the given state
	 */
	public void performMove(final State state);

}
