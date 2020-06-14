package game.state.moves;

import game.state.State;

/**
 * This class performs the end turn operation on a given state.
 * 
 * @author Aaron Tetens
 */
public class EndTurnMove implements Move {

	@Override
	public void performMove(final State state) {
		// TODO empty for now, just needed this class to exist so that the Turn class
		// could be implemented
	}

	@Override
	public String toString() {
		return "End Turn";
	}
}
