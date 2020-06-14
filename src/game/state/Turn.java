package game.state;

import java.util.ArrayList;
import java.util.List;

import game.state.moves.EndTurnMove;
import game.state.moves.Move;

/**
 * This class is responsible for performing some sequence of moves on a given
 * state. Every turn's final move is ending the turn (aka passing the dice).
 * 
 * @author Aaron Tetens
 */
public class Turn {

	private static final String ILLEGAL_MOVES_ERROR = "A turn must consist of one or more moves and end with an end turn move";

	private final List<Move> moves;

	/**
	 * Creates a new Turn that consists of the given list of moves. The final move
	 * must be ending the turn.
	 * 
	 * @throws IllegalArgumentException
	 *             If the final move is not ending the turn.
	 */
	public Turn(final List<Move> moves) throws IllegalArgumentException {
		if (moves == null || moves.isEmpty()) {
			throw new IllegalArgumentException(ILLEGAL_MOVES_ERROR);
		}

		final Move finalMove = moves.get(moves.size() - 1);

		if (!(finalMove instanceof EndTurnMove)) {
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
