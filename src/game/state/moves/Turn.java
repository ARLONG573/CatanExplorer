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

	private static final String ILLEGAL_MOVES_ERROR = "A turn must consist of one or more moves";

	private final List<Move> moves;

	/**
	 * Creates a new Turn that consists of the given list of moves.
	 * 
	 * @throws IllegalArgumentException
	 *             If the given list of moves is null or empty
	 */
	public Turn(final List<Move> moves) throws IllegalArgumentException {
		if (moves == null || moves.isEmpty()) {
			throw new IllegalArgumentException(ILLEGAL_MOVES_ERROR);
		}

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
