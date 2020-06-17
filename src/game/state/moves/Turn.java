package game.state.moves;

import java.util.ArrayList;
import java.util.List;

import game.state.State;

/**
 * This class is responsible for performing some sequence of moves on a given
 * state.
 * 
 * @author Aaron Tetens
 */
public class Turn {

	private final List<Move> moves;

	public Turn(final List<Move> moves) {
		this.moves = new ArrayList<>(moves);
	}

	/**
	 * Performs each of the moves in this turn on the given state in order. The
	 * result of some move acts as the input for the next move.
	 * 
	 * @param state
	 *            The starting state for the turn
	 */
	public void performTurn(final State state) {
		for (final Move move : this.moves) {
			move.performMove(state);
		}
	}

	@Override
	public String toString() {
		return this.moves.toString();
	}
}
