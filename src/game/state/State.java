package game.state;

import game.state.board.Board;
import game.state.deck.Deck;
import game.state.player.Player;

/**
 * This class stores and applies changes to information related to some game
 * state.
 * 
 * @author Aaron Tetens
 */
public class State {

	private final Board board;
	private final Player[] players;
	private final Deck deck; // refers to the dev card deck

	private int currentPlayerIndex;

	/**
	 * Creates a new game state
	 * 
	 * @param board
	 *            The current state of the board
	 * @param players
	 *            An array of the players in the game (in turn order)
	 * @param deck
	 *            The current state of the development card deck
	 * @param currentPlayerIndex
	 *            The index of the current player in the players array
	 */
	public State(final Board board, final Player[] players, final Deck deck, final int currentPlayerIndex) {
		this.board = board;
		this.players = players;
		this.deck = deck;
		this.currentPlayerIndex = currentPlayerIndex;
	}

	/**
	 * @return A copy of this game state that can be modified without affecting this
	 *         one.
	 */
	public State copy() {

		// copy board
		final Board boardCopy = this.board.copy();

		// copy players
		final int numPlayers = this.getNumPlayers();
		final Player[] playersCopy = new Player[numPlayers];

		for (int i = 0; i < numPlayers; i++) {
			playersCopy[i] = this.players[i].copy();
		}

		// copy deck
		final Deck deckCopy = this.deck.copy();

		return new State(boardCopy, playersCopy, deckCopy, this.currentPlayerIndex);
	}

	/**
	 * @return The player whose turn it currently is
	 */
	private Player getCurrentPlayer() {
		return this.players[this.currentPlayerIndex];
	}

	/**
	 * @return The number of players in the game
	 */
	private int getNumPlayers() {
		return this.players.length;
	}
}
