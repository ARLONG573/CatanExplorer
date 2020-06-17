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

	private Player currentPlayer;

	public State(final Board board, final Player[] players) {
		this.board = board;
		this.players = players;
		this.deck = new Deck();

		this.currentPlayer = this.players[0];
	}
}
